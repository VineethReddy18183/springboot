package com.example.springSms.service;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;

import com.example.springSms.model.NotificationSms;
import com.example.springSms.model.NotificationSmsStatus;
import com.example.springSms.model.RequestModel;
import com.example.springSms.model.ResponseModel;
import com.example.springSms.model.TwilioConfig;
import com.example.springSms.repository.NotificationSmsJpaRepository;
//import com.example.springSms.model.SmsPojo;
import com.example.springSms.repository.NotificationSmsRepository;
import com.example.springSms.repository.NotificationSmsStatusJpaRepository;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Service
public class NotificationSmsService implements NotificationSmsRepository{
	   
        
	@Autowired
    private NotificationSmsJpaRepository notificationSmsJpaRepository;

    @Autowired
    private NotificationSmsStatusJpaRepository notificationSmsStatusJpaRepository;
    
    @Autowired
    private TwilioConfig twilioConfig;
    
    
    private ResponseModel responseModel = new ResponseModel();
    
    private RequestModel requestModel = new RequestModel();



    public void send(NotificationSms sms) {
       /* Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
         
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNumber()), new PhoneNumber(twilioConfig.getFromNumber()), sms.getMessage())
                .create();*/
        
        TwilioRestClient twilioRestClient = new TwilioRestClient.Builder(
                twilioConfig.getAccountSid(), twilioConfig.getAuthToken()).build();
        System.out.println("test try");
        // Create a message using the TwilioRestClient
        Message message = null;
        try {
            message = Message.creator(
                    new PhoneNumber(sms.getPhoneNumber()),
                    new PhoneNumber(twilioConfig.getFromNumber()),
                    sms.getMessage()
            ).create(twilioRestClient);
            
        } catch (ApiException e) {
            
            e.printStackTrace();
        }
        //populating responseModel Object
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
        
       

        
        
        

        
    
        
        
       
        // Save NotificationSms
        notificationSmsJpaRepository.save(sms);

        // Create or update NotificationSmsStatus
        NotificationSmsStatus status = sms.getNotificationSmsStatus();
        if (status == null) {
            status = new NotificationSmsStatus();
            status.setMessageStatus("SENT");
            sms.setNotificationSmsStatus(status); // Associate status with sms
        } else {
            status.setMessageStatus("SENT");
        }
        notificationSmsStatusJpaRepository.save(status);
       

        
        System.out.println("Response : ");
        System.out.println(responseModel);
        System.out.println("Request: ");
        System.out.println(requestModel);
    }
    
    public ResponseModel getResponseModel()
    {
    	return responseModel;
    }
    public RequestModel getRequestModel()
    {
    	return requestModel;
    }
   
    
    


    public void receive(MultiValueMap<String, String> smscallback) {
        // Implementation for receiving SMS callbacks
    }
	
}

