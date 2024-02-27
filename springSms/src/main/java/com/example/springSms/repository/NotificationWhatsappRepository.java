package com.example.springSms.repository;

import com.example.springSms.model.NotificationWhatsapp;

public interface NotificationWhatsappRepository {
	void send(int clientId, NotificationWhatsapp whatsapp);

}