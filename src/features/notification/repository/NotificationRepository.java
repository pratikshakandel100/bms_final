package features.notification.repository;

import java.util.List;

import features.notification.model.Notification;

public interface NotificationRepository {
    public boolean createNotification(int userId, String title, String message) ;
    public void markNotificationAsSeen(int notificationId);
    public void deleteNotification(int notificationId);
    public List<Notification> getAllUserNotification(int userId);
}
