package features.notification.controller;

import java.util.List;

import features.notification.model.Notification;
import features.notification.usecase.NotificationUsecase;

public class NotificationController {
    private NotificationUsecase notificationUsecase;
    
    public NotificationController(NotificationUsecase notificationUsecase){
        this.notificationUsecase = notificationUsecase;
    }

    public boolean createNotification(int userId, String title, String message){
        return notificationUsecase.createNotification(userId, title, message);
    }

    public void markNotificationAsSeen(int notificationId){
        notificationUsecase.markNotificationAsSeen(notificationId);
    }
    
    public void deleteNotification(int notificationId){
        notificationUsecase.deleteNotification(notificationId);
    }
    
    public List<Notification> getAllUserNotification(int userId){
        return notificationUsecase.getAllUserNotification(userId);
    }
}
