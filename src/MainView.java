
// UI Design

import core.Session;
import features.auth.view.LoginScreen;

public class MainView {
    public static void main(String[] args) {
        Session currentSession = Session.getSession();
        currentSession.startDbConnection();
        
        new LoginScreen().setVisible(true);

        // BaseApp.getAccountController().openBankAccount(loggedInUser.getUserId());

//        BaseApp.getAccountController().approveAccountOpeningRequest(loggedInUser.getUserId());
//        List<Notification> notificationList = BaseApp.getNotificationController().getAllUserNotification(loggedInUser.getUserId());
//        
        // Loop through each notification and display details
//    for (Notification notification : notificationList) {
//        System.out.println("ID: " + notification.getId());
//        System.out.println("Title: " + notification.getTitle());
//        System.out.println("Message: " + notification.getMessage());
//        System.out.println("Timestamp: " + notification.getCreatedAt());
//        System.out.println("----------------------------");
//    }


    System.out.println("#######################################");
//    System.out.println("#########  After LOAN ACCOUNT  ###########");
//    BaseApp.getAccountController().openLoanAccount(loggedInUser.getUserId(),20000.0);
//    BaseApp.getAccountController().approveLoanAccountOpeningRequest(loggedInUser.getUserId());
//
//    List<Notification> notificationList2 = BaseApp.getNotificationController().getAllUserNotification(loggedInUser.getUserId());
//        
//        // Loop through each notification and display details
//    for (Notification notification : notificationList2) {
//        System.out.println("ID: " + notification.getId());
//        System.out.println("Title: " + notification.getTitle());
//        System.out.println("Message: " + notification.getMessage());
//        System.out.println("Timestamp: " + notification.getCreatedAt());
//        System.out.println("----------------------------");
//    }


    }
}
