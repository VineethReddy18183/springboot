package com.example.springSms.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TwilioConfig {

	@Value("${twilio.sms.accountSid}")
	private String smsAccountSid;
	@Value("${twilio.sms.authToken}")
	private String smsAuthToken;
	@Value("${twilio.sms.fromNumber}")
	private String smsfromNumber;

	@Value("${twilio.whatsapp.accountSid}")
	private String whatsappAccountSid;

	@Value("${twilio.whatsapp.authToken}")
	private String whatsappAuthToken;

	@Value("${twilio.whatsapp.fromNumber}")
	private String whatsappFromNumber;

}
