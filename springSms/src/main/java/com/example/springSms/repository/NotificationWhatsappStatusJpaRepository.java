package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSms.model.NotificationWhatsappStatus;

@Repository

public interface NotificationWhatsappStatusJpaRepository extends JpaRepository<NotificationWhatsappStatus, Integer> {

}