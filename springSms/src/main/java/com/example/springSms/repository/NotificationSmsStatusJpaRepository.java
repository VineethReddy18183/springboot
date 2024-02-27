package com.example.springSms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSms.model.NotificationSmsStatus;

@Repository

public interface NotificationSmsStatusJpaRepository extends JpaRepository<NotificationSmsStatus, Integer> {

}
