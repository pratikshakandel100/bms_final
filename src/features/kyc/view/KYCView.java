package features.kyc.view;

import core.BaseApp;
import core.Session;
import features.kyc.controller.KYCController;

public class KYCView {
    public static void main(String[] args) {
        Session.getSession().startDbConnection();
        KYCController kycController = BaseApp.getKycController();
        boolean result = kycController.approveKYCDetail(String.valueOf(1));
        if(result){
            System.out.println("KYC Approved\nCheck Notification");
        } else {
            System.out.println("KYC Failed to approved");
        }
    }
}
