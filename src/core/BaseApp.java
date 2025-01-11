package core;

import features.kyc.controller.KYCController;
import features.kyc.repository.KYCRepository;
import features.kyc.repository.KYCRepositoryImpl;
import features.kyc.usecase.KYCUsecase;
import features.notification.controller.NotificationController;
import features.notification.repository.NotificationRepository;
import features.notification.repository.NotificationRepositoryImpl;
import features.notification.usecase.NotificationUsecase;

//import features.account.controller.AccountController;
//import features.account.repository.AccountRepository;
//import features.account.repository.AccountRepositoryImpl;
//import features.account.usecase.AccountUsecase;

public class BaseApp {
    // For Notification
   private static NotificationRepository notificationRepository = new NotificationRepositoryImpl();
   private static NotificationUsecase notificationUsecase = new NotificationUsecase(notificationRepository);
   private static NotificationController notificationController = new NotificationController(notificationUsecase);

   public static NotificationController getNotificationController(){
       return notificationController;
   }
   
    private static KYCRepository kycRepository = new KYCRepositoryImpl();
   private static KYCUsecase kycUsecase = new KYCUsecase(kycRepository);
   private static KYCController kycController = new KYCController(kycUsecase);
   
   public static KYCController getKycController(){
       return kycController;
   }


    // For Account
//    private static AccountRepository accountRepository = new AccountRepositoryImpl();
//    private static AccountUsecase accountUsecase = new AccountUsecase(accountRepository);
//    private static AccountController accountController = new AccountController(accountUsecase);
//
//    public static AccountController getAccountController(){
//        return accountController;
//    }

}
