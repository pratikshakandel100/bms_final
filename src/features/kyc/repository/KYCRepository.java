package features.kyc.repository;

import features.kyc.model.KYCDetails;
import java.util.List;

public interface KYCRepository {
    public KYCDetails getKYCDetailsFromUserId(String userId);

    public boolean submitKYCDetail(KYCDetails kycDetails);

    public boolean approveKYCDetail(String userId);
    
    public List<KYCDetails> getAllKYCDetail();
    
    public boolean updateKYCDetailById(String kycId, String userId, String identityType, boolean isVerified);
    
}
