package features.kyc.repository;

import features.kyc.model.KYCDetails;

public interface KYCRepository {
    public KYCDetails getKYCDetailsFromUserId(String userId);

    public boolean submitKYCDetail(KYCDetails kycDetails);

    public boolean approveKYCDetail(String userId);
}
