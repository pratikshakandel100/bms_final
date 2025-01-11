package features.notification.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import features.notification.model.Notification;
import features.notification.utils.NotificationQueryManager;
import core.CustomMapper;
import core.Session;

public class NotificationRepositoryImpl implements NotificationRepository {
    DbConnection dbConnection = Session.getSession().getDbConnection();

    @Override
    public boolean createNotification(int userId, String title, String message){
        String createNotificationQuery = NotificationQueryManager.createNotificationQuery(userId, title, message);
        int result = dbConnection.executeOnly(createNotificationQuery);
        return (result>0) ? true : false;
    }

    @Override
    public void markNotificationAsSeen(int userId){
        String updateNotificationStatusQuery = NotificationQueryManager.updateNotificatonStatusQuery(userId);
        dbConnection.executeOnly(updateNotificationStatusQuery);
    }

    @Override
    public void deleteNotification(int notificationId){
        String deleteNotificationQuery = NotificationQueryManager.deleteNotificationQuery(notificationId);
        dbConnection.executeOnly(deleteNotificationQuery);
    }

    @Override
    public List<Notification> getAllUserNotification(int userId){
        List<Notification> notifications = new ArrayList<>();
        try {
        String getNotificationQuery = NotificationQueryManager.getAllUserNotificationQuery(userId);
        ResultSet result = dbConnection.executeWithResult(getNotificationQuery);
        while (result.next()) {
            Notification notification = CustomMapper.mapResultSetToObject(result, Notification.class);
            notifications.add(notification);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notifications;
    }
    
}
