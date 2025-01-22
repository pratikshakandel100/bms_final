
package features.kyc.utils;

import core.CustomDateFormatter;
import core.CustomFormatter;
import java.sql.Date;
import java.util.Map;

public class KYCQueryManager {
    static String kyc_table = "bms_kyc_details";

    // ------------------- 1. Get KYC Details By User ID ------------------- //
    public static String getKYCDetailsQuery(String userId) {
        String template = "SELECT * FROM {kyc_table} WHERE userId = '{userId}'";
        Map<String, String> values = Map.of(
                "kyc_table", kyc_table,
                "userId", userId);
        return CustomFormatter.format(template, values);
    }

    // ------------------- 2. Submit KYC Details ------------------- //
    public static String submitKYCDetailQuery(int userId, String identityType, String identityNumber, Date identityIssueDate) {
        String template = "INSERT INTO {kyc_table} (userId, identityType, identityNumber,identityIssueDate) " +
                "VALUES ('{userId}', '{identityType}', '{identityNumber}', '{identityIssueDate}') " +
                
                "ON DUPLICATE KEY UPDATE identityType = '{identityType}', identityNumber = '{identityNumber}', identityIssueDate='{identityIssueDate}'";
        Map<String, String> values = Map.of(
                "kyc_table", kyc_table,
                "userId", Integer.toString(userId),
                "identityType", identityType,
                "identityNumber", identityNumber,
                "identityIssueDate",CustomDateFormatter.convertJAVADateToFormatted(identityIssueDate)
                );
        return CustomFormatter.format(template, values);
    }

    // ------------------- 3. Approve KYC Details ------------------- //
    public static String approveKYCDetailQuery(String userId) {
        String template = "UPDATE {kyc_table} SET isVerified = TRUE WHERE userId = '{userId}'";
        Map<String, String> values = Map.of(
                "kyc_table", kyc_table,
                "userId", userId);
        return CustomFormatter.format(template, values);
    }
    
    public static String getALLKYCDetailQuery(){
        String template = "select * from {kyc_table}";
        Map<String,String> values = Map.of("kyc_table", kyc_table);
        return CustomFormatter.format(template, values);
    }
    
    public static String updateKYCDetailByIdQuery(String kycId, String userId, String identityType, boolean isVerified){
        String template = "update {kyc_table} set isVerified = {isVerified},identityType='{identityType}' WHERE kycId = '{kycId}' and userId = '{userId}'";
        Map<String,String> values = Map.of(
                "kyc_table", kyc_table,
                "isVerified",isVerified==true?"TRUE":"FALSE",
                "identityType",identityType,
                "kycId", kycId,
                "userId",userId
        );
        return CustomFormatter.format(template, values);
    }
}
