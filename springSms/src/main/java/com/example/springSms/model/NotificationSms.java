package com.example.springSms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_sms")
public class NotificationSms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private int notificationId;
	
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "message")
	private String message;
	
	@OneToOne
	@JoinColumn(name ="status_id")
	private NotificationSmsStatus notificationSmsStatus;
	
	

	public NotificationSms(int notificationId, String phoneNumber, String message,NotificationSmsStatus notificationSmsStatus) {
		super();
		this.notificationId = notificationId;
		this.phoneNumber = phoneNumber;
		this.message = message;
		this.notificationSmsStatus = notificationSmsStatus;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotificationSmsStatus getNotificationSmsStatus() {
		return notificationSmsStatus;
	}

	public void setNotificationSmsStatus(NotificationSmsStatus notificationSmsStatus) {
		this.notificationSmsStatus = notificationSmsStatus;
	}
	

}
