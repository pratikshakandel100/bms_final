package features.notification.view;

import java.util.List;
import features.notification.controller.NotificationController;
import features.notification.model.Notification;
import core.BaseApp;

public class NotificationView {
    public static void main(String[] args) {
        // NotificationController nc = new NotificationController();
    NotificationController notificationController = BaseApp.getNotificationController();
    List<Notification> notifications = notificationController.getAllUserNotification(1);

    notificationController.createNotification(0, null, null);

    notificationController.markNotificationAsSeen(1);
        // Check if notifications list is empty
if (notifications.isEmpty()) {
    System.out.println("No notifications available.");
} else {
    System.out.println("Notifications:");

    // Loop through each notification and display details
    for (Notification notification : notifications) {
        System.out.println("ID: " + notification.getId());
        System.out.println("Title: " + notification.getTitle());
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Timestamp: " + notification.getCreatedAt());
        System.out.println("----------------------------");
    }
}
    }
}
