package com.example.springSms.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springSms.model.CustomResponse;
import com.example.springSms.model.NotificationWhatsapp;
import com.example.springSms.service.NotificationWhatsappService;

@RestController
public class WhatsappController {
	@Autowired
	private NotificationWhatsappService notificationWhatsappService;
	@Autowired
	private SimpMessagingTemplate webSocket;

	private final String TOPIC_DESTINATION = "/lesson/whatsapp";

	@PostMapping(value = "/whatsapp/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<CustomResponse> whatsappSubmit(@PathVariable("clientId") int clientId,
			@RequestBody NotificationWhatsapp whatsapp) {
		try {
			notificationWhatsappService.send(clientId, whatsapp);
			CustomResponse customResponse = new CustomResponse(

					notificationWhatsappService.getResponseModel(), notificationWhatsappService.getRequestModel());
			return ResponseEntity.ok().body(customResponse);
		}

		catch (Exception e) {

			webSocket.convertAndSend(TOPIC_DESTINATION,
					getTimeStamp() + ": Error sending the whatsapp: " + e.getMessage());
			throw e;

		}
	}

	@PostMapping(value = "/whatsappcallback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
		notificationWhatsappService.receive(map);
		webSocket.convertAndSend(TOPIC_DESTINATION,
				getTimeStamp() + ": Twilio has made a callback request! Here are the contents: " + map.toString());
	}

	private String getTimeStamp() {

		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

}