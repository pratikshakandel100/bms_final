package features.kyc.usecase;

import features.kyc.model.KYCDetails;
import features.kyc.repository.KYCRepository;
import java.util.List;

public class KYCUsecase{
   KYCRepository kycRepository;

    public KYCUsecase(KYCRepository kycRepository) {
        this.kycRepository = kycRepository;
    }
    public KYCDetails getKYCDetailsFromUserId(String userId){
        return kycRepository.getKYCDetailsFromUserId(userId);
    }
    public boolean submitKYCDetail(KYCDetails kycDetails){
        return kycRepository.submitKYCDetail(kycDetails);
    }
    public boolean approveKYCDetail(String userId){
        return kycRepository.approveKYCDetail(userId);
    }

    public List<KYCDetails> getAllKYCDetail() {
        return kycRepository.getAllKYCDetail();
    }
    
    public boolean updateKYCDetailById(String kycId, String userId,String identityType, boolean isVerified) {
        return kycRepository.updateKYCDetailById(kycId,userId, identityType, isVerified);
    }


}