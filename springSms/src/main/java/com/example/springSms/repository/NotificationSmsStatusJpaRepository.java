package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springSms.model.NotificationSmsStatus;

public interface NotificationSmsStatusJpaRepository extends JpaRepository<NotificationSmsStatus,Integer> {
	

}
