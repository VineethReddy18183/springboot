package com.example.springSms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.springSms.model.Client;
import com.example.springSms.model.NotificationWhatsapp;
import com.example.springSms.model.NotificationWhatsappStatus;
import com.example.springSms.model.RequestModel;
import com.example.springSms.model.ResponseModel;
import com.example.springSms.model.TwilioConfig;
import com.example.springSms.repository.ClientJpaRepository;
import com.example.springSms.repository.NotificationWhatsappJpaRepository;
import com.example.springSms.repository.NotificationWhatsappRepository;
import com.example.springSms.repository.NotificationWhatsappStatusJpaRepository;
import com.twilio.exception.ApiException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class NotificationWhatsappService implements NotificationWhatsappRepository {

	@Autowired
	private NotificationWhatsappJpaRepository notificationWhatsappJpaRepository;

	@Autowired
	private NotificationWhatsappStatusJpaRepository notificationWhatsappStatusJpaRepository;

	@Autowired
	private TwilioConfig twilioConfig;

	@Autowired
	private ClientJpaRepository clientJpaRepository;

	private ResponseModel responseModel = new ResponseModel();
	private RequestModel requestModel = new RequestModel();

	@Override
	public void send(int clientId, NotificationWhatsapp whatsapp) {
		TwilioRestClient twilioRestClient = new TwilioRestClient.Builder(twilioConfig.getWhatsappAccountSid(),
				twilioConfig.getWhatsappAuthToken()).build();

		Client client = clientJpaRepository.findById(clientId).get();

		Message message = null;

		try {
			message = Message
					.creator(new PhoneNumber("whatsapp:" + client.getPhoneNumber()),
							new PhoneNumber("whatsapp:" + client.getWhatsappFromNumber()), whatsapp.getMessage())
					.create(twilioRestClient);

		} catch (ApiException e) {

			e.printStackTrace();

		}
		responseModel.setSid(message.getSid());
		/* responseModel.setDateCreated(message.getDateCreated().toDate());
		responseModel.setDateUpdated(message.getDateUpdated().toDate());*/
		responseModel.setAccountSid(message.getAccountSid());
		responseModel.setTo(message.getTo());
		responseModel.setFrom(message.getFrom());
		responseModel.setBody(message.getBody());
		responseModel.setStatus(message.getStatus());

		responseModel.setApiVersion(message.getApiVersion());
		responseModel.setPrice(message.getPrice());
		responseModel.setUri(message.getUri());

		//populating request model object
		requestModel.setAccountSid(message.getAccountSid());
		requestModel.setApiVersion(message.getApiVersion());
		requestModel.setBody(message.getBody());
		/* requestModel.setDateCreated(message.getDateCreated().toDate());
		requestModel.setDateSent(message.getDateSent().toDate());
		requestModel.setDateUpdated(message.getDateUpdated().toDate());*/
		requestModel.setDirection(message.getDirection());
		requestModel.setErrorCode(message.getErrorCode());
		requestModel.setErrorMessage(message.getErrorMessage());
		requestModel.setFrom(message.getFrom());

		requestModel.setNumMedia(message.getNumMedia());
		requestModel.setNumSegments(message.getNumSegments());
		requestModel.setPrice(message.getPrice());
		requestModel.setPriceUnit(message.getPriceUnit());
		requestModel.setSid(message.getSid());
		requestModel.setStatus(message.getStatus());
		requestModel.setSubresourceUris(message.getSubresourceUris());
		requestModel.setTo(message.getTo());
		requestModel.setUri(message.getUri());

		notificationWhatsappJpaRepository.save(whatsapp);
		NotificationWhatsappStatus status = whatsapp.getNotificationWhatsappStatus();
		if (status == null) {
			status = new NotificationWhatsappStatus();
			status.setMessageStatus("SENT");
			whatsapp.setNotificationWhatsappStatus(status); // Associate status with sms
		} else {
			status.setMessageStatus("SENT");
		}
		notificationWhatsappStatusJpaRepository.save(status);
		System.out.println("Response : ");
		System.out.println(responseModel);
		System.out.println("Request: ");
		System.out.println(requestModel);

	}

	public ResponseModel getResponseModel() {
		return responseModel;
	}

	public RequestModel getRequestModel() {
		return requestModel;
	}

	public void receive(MultiValueMap<String, String> whatsappcallback) {
		// Implementation for receiving SMS callbacks
	}

}