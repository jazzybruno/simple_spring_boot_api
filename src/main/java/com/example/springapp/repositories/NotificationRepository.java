package com.example.springapp.repositories;

import com.example.springapp.classes.Notification;
import com.example.springapp.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification , Long> {
    Optional<List<Notification>> findByUser(User user);
}
