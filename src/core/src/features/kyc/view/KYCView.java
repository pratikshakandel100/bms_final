package features.kyc.view;

import core.BaseApp;
import core.Session;
import features.kyc.controller.KYCController;
import features.message.controller.MessageController;

public class KYCView {
    public static void main(String[] args) {
        Session.getSession().startDbConnection();
        new MessageController().deleteUserMessage();
        KYCController kycController = BaseApp.getKycController();
        boolean result = kycController.approveKYCDetail(String.valueOf(6));
        if(result){
            System.out.println("KYC Approved\nCheck Notification");
        } else {
            System.out.println("KYC Failed to approved");
        }
    }
}
