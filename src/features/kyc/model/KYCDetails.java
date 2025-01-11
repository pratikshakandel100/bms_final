package features.kyc.model;

import java.sql.Date;

public class KYCDetails {
    private int kycId;
    private int userId;
    private String identityType;
    private String identityNumber;
    private Date identityIssueDate;
    private boolean isVerified;


    public KYCDetails(){
        
    }

    public KYCDetails(int userId, String identityType, String identityNumber, Date identityIssueDate){
        this.userId = userId;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.identityIssueDate=identityIssueDate;
    }

    // Getters and Setters
    public int getKycId() {
        return kycId;
    }

    public void setKycId(int kycId) {
        this.kycId = kycId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    
        public Date getIdentityIssueDate() {
        return this.identityIssueDate;
    }

    public void setIdentityIssueDate(Date identityIssueDate) {
        this.identityIssueDate = identityIssueDate;
    }
}
