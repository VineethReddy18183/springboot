package com.example.springSms.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "notification_sms_status")

public class NotificationSmsStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int statusId;
	
	@Column(name = "status")
	private String messageStatus;
	
	@OneToOne(mappedBy = "notificationSmsStatus")
	private NotificationSms notificationSms;

	public NotificationSmsStatus(int statusId, String messageStatus) {
		super();
		this.statusId = statusId;
		this.messageStatus = messageStatus;
		
	}

	public NotificationSmsStatus() {
		
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	
	
}
