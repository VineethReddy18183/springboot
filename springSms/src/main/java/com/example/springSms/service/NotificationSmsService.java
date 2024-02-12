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
import com.example.springSms.model.TwilioConfig;
import com.example.springSms.repository.NotificationSmsJpaRepository;
//import com.example.springSms.model.SmsPojo;
import com.example.springSms.repository.NotificationSmsRepository;
import com.example.springSms.repository.NotificationSmsStatusJpaRepository;
import com.twilio.Twilio;
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

   /* private final String ACCOUNT_SID = "AC61b259eb289150ca9cdb2aaf4d8f51b4";
    private final String AUTH_TOKEN = "54b3b7d5d3138b341db6ba43bd39d6e7";
    private final String FROM_NUMBER = "+12137862316";*/

    public void send(NotificationSms sms) {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        Message message = Message.creator(new PhoneNumber(sms.getPhoneNumber()), new PhoneNumber(twilioConfig.getFromNumber()), sms.getMessage())
                .create();

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

        System.out.println("here is my id:" + message.getSid());
    }

    public void receive(MultiValueMap<String, String> smscallback) {
        // Implementation for receiving SMS callbacks
    }
	
}

