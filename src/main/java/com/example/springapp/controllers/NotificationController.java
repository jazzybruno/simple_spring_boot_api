package com.example.springapp.controllers;

import com.example.springapp.classes.Notification;
import com.example.springapp.repositories.NotificationRepository;
import com.example.springapp.services.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;
    public NotificationController(NotificationService notificationService , NotificationRepository notificationRepository){
        this.notificationService = notificationService;
        this.notificationRepository = notificationRepository;
    }
    @GetMapping
    public List<Notification> getAllNotifications() throws Exception{
     return notificationService.getAllNotifcation();
    }

    @GetMapping("/user/{user_id}")
    public Optional<List<Notification>> getNotificationByUser(@PathVariable Long user_id) throws Exception{
        return notificationService.getNotificationByUser(user_id);
    }

    @PostMapping
    public Notification saveNotification(@RequestBody Notification notification) throws Exception{
        return notificationService.saveNotification(notification);
    }

    @DeleteMapping("/{not_id}")
    public Optional<Notification> deleteNotification(@PathVariable Long not_id) throws Exception{
        return notificationService.deleteNotification(not_id);
    }

    public Optional<Notification> updateNotification() throws Exception{

    }
}
