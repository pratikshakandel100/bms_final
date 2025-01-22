package features.kyc.controller;

import features.kyc.model.KYCDetails;
import features.kyc.usecase.KYCUsecase;
import java.util.List;

public class KYCController {
    KYCUsecase kycUsecase;
    public KYCController(KYCUsecase kycUsecase){
        this.kycUsecase = kycUsecase;
    }

    public KYCDetails getKYCDetailsFromUserId(String userId){
    return kycUsecase.getKYCDetailsFromUserId(userId);
    }

    public boolean submitKYCDetail(KYCDetails kycDetails){
        return kycUsecase.submitKYCDetail(kycDetails);
    }

    public boolean approveKYCDetail(String userId){
        return kycUsecase.approveKYCDetail(userId);
    }
    
    public List<KYCDetails> getAllKYCDetail() {
        return kycUsecase.getAllKYCDetail();
    }
    
    public boolean updateKYCDetailById(String kycId, String userId,String identityType, boolean isVerified) {
        return kycUsecase.updateKYCDetailById(kycId, userId, identityType, isVerified);
    }
}
