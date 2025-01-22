package features.kyc.repository;

import core.BaseApp;
import core.CustomMapper;
import core.Session;
import database.DbConnection;
import features.kyc.model.KYCDetails;
import features.kyc.utils.KYCQueryManager;
import features.notification.utils.NotificationStringManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KYCRepositoryImpl implements KYCRepository{
        DbConnection dbConnection = Session.getSession().getDbConnection();

    @Override
    public KYCDetails getKYCDetailsFromUserId(String userId) {
        KYCDetails kycDetails = null;
        try {
        String query = KYCQueryManager.getKYCDetailsQuery(userId);
        ResultSet resultSet = dbConnection.executeWithResult(query);
        if (resultSet.next()) {
            kycDetails = CustomMapper.mapResultSetToObject(resultSet, KYCDetails.class);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kycDetails;
    }

    @Override
    public boolean submitKYCDetail(KYCDetails kycDetails) {
        try {
        String query = KYCQueryManager.submitKYCDetailQuery(
            kycDetails.getUserId(),
            kycDetails.getIdentityType(),
            kycDetails.getIdentityNumber(),
            kycDetails.getIdentityIssueDate()
        );
        int result = dbConnection.executeOnly(query);
        return result>0;
    } catch (Exception e) {
        e.printStackTrace();
    }
        return false;
    }

    @Override
    public boolean approveKYCDetail(String userId) {
        try {
            String query = KYCQueryManager.approveKYCDetailQuery(userId);
            int result = dbConnection.executeOnly(query);
            if (result > 0) {
            // Create Notification 
            boolean notificationResult = BaseApp.getNotificationController().createNotification(
                    Integer.parseInt(userId),
                    NotificationStringManager.KYC_APPROVED_TITLE,
//                    String.format(NotificationStringManager.KYC_APPROVED_MESSAGE,Session.getSession().getLoggedInUser().getName())
                    "Pratiksha"
            );
            return notificationResult; // Return notification result
        }
        return false; // Approval failed
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<KYCDetails> getAllKYCDetail() {
        List<KYCDetails> kycList = new ArrayList<>();
        try {
            String query = KYCQueryManager.getALLKYCDetailQuery();
            ResultSet result = dbConnection.executeWithResult(query);
            while(result.next()){
                KYCDetails kYCDetails = CustomMapper.mapResultSetToObject(result, KYCDetails.class);
                kycList.add(kYCDetails);
            }
        } catch (Exception e) {
        e.printStackTrace();
        
        }
        return kycList;
    }

    @Override
    public boolean updateKYCDetailById(String kycId, String userId, String identityType, boolean isVerified) {
        String query = KYCQueryManager.updateKYCDetailByIdQuery(kycId,userId,identityType, isVerified);
        boolean result =  dbConnection.executeOnly(query) > 0;
        if(result == true && isVerified == true){
            String fullName = BaseApp.getUserController().getUserDetails(Integer.parseInt(userId)).getName();
            boolean notificationResult = BaseApp.getNotificationController().createNotification(
                        Integer.parseInt(userId),
                        NotificationStringManager.KYC_APPROVED_TITLE,
                        String.format(NotificationStringManager.KYC_APPROVED_MESSAGE,fullName)
                );
                return notificationResult; 
        }
        return true;
    }
}
