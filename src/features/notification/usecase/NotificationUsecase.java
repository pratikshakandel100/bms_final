package features.notification.usecase;

import java.util.List;

import features.notification.model.Notification;
import features.notification.repository.NotificationRepository;

public class NotificationUsecase {
    // deligate-->forward
    private NotificationRepository notificationRepository;

    public NotificationUsecase(NotificationRepository notificationRepository){
        this.notificationRepository= notificationRepository;
    }

    public boolean createNotification(int userId, String title, String message){
        return notificationRepository.createNotification(userId, title, message);
    }

    public void markNotificationAsSeen(int userId){
        notificationRepository.markNotificationAsSeen(userId);
    }
   
    public List<Notification> getAllUserNotification(int userId){
      return notificationRepository.getAllUserNotification(userId);
    }
}
