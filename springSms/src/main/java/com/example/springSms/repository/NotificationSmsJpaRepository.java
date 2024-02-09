package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSms.model.NotificationSms;

@Repository
public interface NotificationSmsJpaRepository extends JpaRepository<NotificationSms,Integer>{

}
