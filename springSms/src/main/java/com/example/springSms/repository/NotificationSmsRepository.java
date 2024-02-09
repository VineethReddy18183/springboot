package com.example.springSms.repository;

import com.example.springSms.model.NotificationSms;

public interface NotificationSmsRepository {
	
	 void send(NotificationSms sms);
}
