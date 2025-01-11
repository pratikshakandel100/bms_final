package features.account.utils;

import core.CustomFormatter;
import java.util.Map;



// Account Queries
public class AccountQueryManager {
    static String account_table = AccountStringManager.ACCOUNT_TABLE_NAME;

// Create Account Query
public static String createAccountQuery(int userId, String accountNumber, String accountType, double balance) {
    String template = "insert into {account_table}(userId,accountNumber,accountType,balance) values('{userId}','{number}','{type}',{balance})";
    Map<String, String> values = Map.of("account_table", account_table, "userId", Integer.toString(userId),
            "number", accountNumber, "type", accountType, "balance",
            Double.toString(balance));
    return CustomFormatter.format(template, values);
}
public static String updateAccountBalanceQuery(String accountNumber, double balance) {
    String template = "update {account_table} set balance = balance+{balance} where accountNumber = '{accountNumber}'";
    Map<String, String> values = Map.of("account_table", account_table, "balance", Double.toString(balance),
            "accountNumber", accountNumber);
    return CustomFormatter.format(template, values);
}

public static String getAccountQuery(String accountId, String accountNumber, String status) {
    String template;
    Map<String,String> values;
    if(accountNumber != null){
        template = "select * from {account_table} where accountNumber = '{accountNumber}' and status = '{status}'";
        values = Map.of("account_table", account_table, "accountNumber",accountNumber,"status",status);
    } else {
        template = "select * from {account_table} where accountId = {accountId} and status = '{status}'";
        values = Map.of("account_table", account_table, "accountId",accountId,"status",status);
    }
    return CustomFormatter.format(template, values);
}

public static String getAllUserAccountQuery(int userId, String status) {
    String template = "select * from {account_table} where userId = {userId} and status = '{status}'";
    Map<String, String> values = Map.of("account_table", account_table, "userId",Integer.toString(userId),"status",status);
    return CustomFormatter.format(template, values);
}

public static String acceptAccountOpeningRequestQuery(int userId){
    String template = "update {account_table} set status = '{status}' where userId = {userId} and (accountType = '{normalAccount}' or accountType = '{saverAccount}')";
    Map<String, String> values = Map.of("account_table", account_table,"status",AccountStringManager.ACCOUNT_STATUS_ACTIVE, "userId", Integer.toString(userId), "normalAccount",AccountStringManager.ACCOUNT_TYPE_NORMAL,"saverAccount",AccountStringManager.ACCOUNT_TYPE_SAVER);
    return CustomFormatter.format(template, values);
}

public static String acceptLoanAccountOpeningRequestQuery(int userId){
    String template = "update {account_table} set status = '{status}' where userId = {userId} and accountType = '{accountType}'";
    Map<String, String> values = Map.of("account_table", account_table,"status",AccountStringManager.ACCOUNT_STATUS_ACTIVE, "userId", Integer.toString(userId),"accountType",AccountStringManager.ACCOUNT_TYPE_LOAN);
    return CustomFormatter.format(template, values);
}

}
