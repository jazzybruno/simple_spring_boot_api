package com.example.springapp.servicesImpl;

import com.example.springapp.classes.Notification;
import com.example.springapp.classes.User;
import com.example.springapp.repositories.LikeRepository;
import com.example.springapp.repositories.NotificationRepository;
import com.example.springapp.repositories.UserRepository;
import com.example.springapp.services.NotifcationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NotificationServiceImpl  implements NotifcationService {
    private final NotificationRepository notificationRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   LikeRepository likeRepository,
                                   UserRepository userRepository){
        this.notificationRepository = notificationRepository;
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
    }
    public List<Notification> getAllNotifcation() throws Exception {
        try {
            return notificationRepository.findAll();
        }catch (Exception e){
            throw new Exception("Failed to get all users");
        }
    }

    public Notification saveNotification(Notification notification) throws Exception{
        try {
             notificationRepository.save(notification);
             return notification;
        }catch (Exception e){
            throw new Exception("Failed to save the notification");
        }
    }

    public Optional<Notification> deleteNotification(Long notId) throws Exception{
        if(notificationRepository.existsById(notId)){
            try {
                Optional<Notification> notification = notificationRepository.findById(notId);
                notificationRepository.deleteById(notId);
                return notification;
            }catch (Exception e){
                throw new Exception("Failed to delete the notification");
            }
        }
        throw new Exception("The notification with id: " + notId + " does not exist");
    }

    public Optional<List<Notification>> getNotificationByUser(Long userId) throws Exception {
        if(userRepository.existsById(userId)){
            Optional<User> user = userRepository.findById(userId);
            User user1 = user.get();
           try {
               Optional<List<Notification>> notifications = notificationRepository.findByUser(user1);
               return notifications;
           }catch (Exception e){
               e.printStackTrace();
               throw new Exception("Failed to fetch the notifications");
           }
        }
        throw new Exception("The user with the id:" + userId + " does not exist");
    }

    @Transactional
    public Notification updateNotification(Long notId ,  Notification notification) throws Exception {
        if(notificationRepository.existsById(notId)){
            Optional<Notification> notification1 = notificationRepository.findById(notId);
            Notification notification2 = notification1.get();
            notification2.setContent(notification.getContent());
            notification2.setRead(notification.isRead());
            return notification2;
        }
        throw new Exception("The notification with id: " + notId + " is not present");
    }
}
