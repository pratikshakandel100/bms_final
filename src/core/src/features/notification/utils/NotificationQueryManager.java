package features.notification.utils;

import java.util.Map;

import core.CustomFormatter;

public class NotificationQueryManager {
    static String notification_table = "bms_notifications";

    public static String createNotificationQuery(int userId, String title, String message){
        String template = "insert into {notification_table}(userId, title, message) values ('{userId}','{title}','{message}')";
        Map<String,String> values = Map.of("notification_table",notification_table, "userId",Integer.toString(userId),"title",title,"message",message);
        return CustomFormatter.format(template, values);
    }

    // update notification status (markNotificationAsSeen) --> int userId
    public static String updateNotificatonStatusQuery(int notificationId ){
        String template = "update {notification_table} set isSeen= !isSeen where notificationId = {notificationId}";
        Map<String,String> values = Map.of("notification_table", notification_table, "notificationId", Integer.toString(notificationId) );
        return CustomFormatter.format(template, values); 
    }

    // delete notification --> int id
   public static String deleteNotificationQuery(int notificationId){
      String templete = "delete from {notification_table} where notificationId = {notificationId}";
      Map<String,String> values = Map.of("notification_table", notification_table, "notificationId", Integer.toString(notificationId));
      return CustomFormatter.format(templete, values);

   }
    // getall notification
    public static String getAllUserNotificationQuery(int userId){
        String template = "Select * from {notification_table} where userId = {userId} order by createdAt desc";
        Map<String,String> values = Map.of("notification_table", notification_table,"userId", Integer.toString(userId));
        return CustomFormatter.format(template, values);
    }
    
}
