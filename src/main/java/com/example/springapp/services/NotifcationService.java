package com.example.springapp.services;

import com.example.springapp.classes.Notification;

import java.util.List;
import java.util.Optional;

public interface NotifcationService {
    public List<Notification> getAllNotifcation() throws Exception;
    public Notification saveNotification(Notification notification) throws Exception;
    public Optional<Notification> deleteNotification(Long notId) throws Exception;
    public Optional<List<Notification>> getNotificationByUser(Long userId) throws Exception;
    public Notification updateNotification(Long notId ,  Notification notification) throws Exception;
}
