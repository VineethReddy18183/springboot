package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springSms.model.NotificationWhatsapp;

public interface NotificationWhatsappJpaRepository extends JpaRepository<NotificationWhatsapp, Integer> {

}