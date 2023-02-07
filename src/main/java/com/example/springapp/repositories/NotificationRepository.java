package com.example.springapp.repositories;

import com.example.springapp.classes.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification , Long> {
}
