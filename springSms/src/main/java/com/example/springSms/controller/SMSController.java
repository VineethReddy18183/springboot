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
import com.example.springSms.model.NotificationSms;
//import com.example.springSms.model.NotificationSms;
import com.example.springSms.service.NotificationSmsService;

@RestController
public class SMSController {

	@Autowired
	NotificationSmsService service;

	@Autowired
	private SimpMessagingTemplate webSocket;

	private final String TOPIC_DESTINATION = "/lesson/sms";

	@PostMapping(value = "/sms/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<CustomResponse> smsSubmit(@PathVariable("clientId") int clientId,
			@RequestBody NotificationSms sms) {
		try {
			service.send(clientId, sms);
			CustomResponse customResponse = new CustomResponse(service.getResponseModel(), service.getRequestModel());
			return ResponseEntity.ok().body(customResponse);

		} catch (Exception e) {

			webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: " + e.getMessage());
			throw e;
		}
		// webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getPhoneNumber());

	}

	@PostMapping(value = "/smscallback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
		service.receive(map);
		webSocket.convertAndSend(TOPIC_DESTINATION,
				getTimeStamp() + ": Twilio has made a callback request! Here are the contents: " + map.toString());
	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
}
