package features.transaction.utils;

import java.util.Map;

import core.CustomFormatter;

public class TransactionQueryManager {
    static String transaction_table =  TranscationStringManager.TRANSACTION_TABLE_NAME;
    public static String createAndSaveTransactionQuery(String fromAccountId, String toAccountId, double amount, String transactionType, String description, String reference){
        String template;
        Map<String, String> values;
        String amountStr = String.valueOf(amount);
        System.out.println(amountStr);
        if(reference == null){
            template = "insert into {transaction_table}(fromAccountId,toAccountId,amount,transactionType,description) values ({fromAccountId},{toAccountId},{amount},'{transactionType}','{description}')";
            values = Map.of("transaction_table", transaction_table,"fromAccountId", fromAccountId, "toAccountId", toAccountId, "amount", String.valueOf(amountStr), "transactionType", transactionType, "description", description);
        } else {
            template = "insert into {transaction_table}(fromAccountId,toAccountId,amount,transactionType,description,reference) values ({fromAccountId},{toAccountId},{amount},'{transactionType}','{description}','{reference}')";
            values = Map.of("transaction_table", transaction_table,"fromAccountId", fromAccountId, "toAccountId", String.valueOf(toAccountId), "amount", String.valueOf(amount), "transactionType", transactionType, "description", description, "reference", String.valueOf(reference));
        }
        String t = template;
        System.out.println(t);
        return CustomFormatter.format(template, values);

    }

    // ---------------------------- 1. DEPOSIT QUERY ---------------------------- //
    public static String insertDepositQuery(int fromAccountId, double amount, String transactionType, int userId, String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for deposit query
            String template = "INSERT INTO {transaction_table}(fromAccountId, amount, transactionType, description, reference, userId) "
                            +
                            "VALUES ({fromAccountId}, {amount}, '{transactionType}', '{description}', '{reference}', {userId})";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "reference", referenceValue,
                            "userId", String.valueOf(userId));

            return CustomFormatter.format(template, values);
    }

    // ---------------------------- 2. WITHDRAW QUERY ----------------------------
    // //
    public static String insertWithdrawQuery(int fromAccountId, double amount, String transactionType,
                    int userId, String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for withdraw query
            String template = "INSERT INTO {transaction_table}(fromAccountId, amount, transactionType, description, reference, userId) "
                            +
                            "VALUES ({fromAccountId}, {amount}, '{transactionType}', '{description}','{reference}', {userId})";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", 
                            transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "reference", referenceValue,
                            "userId", String.valueOf(userId));

            return CustomFormatter.format(template, values);
    }

    // ---------------------------- 3. TRANSFER QUERY ----------------------------
    // //
    public static String insertTransferQuery(int fromAccountId, int toAccountId, double amount, String transactionType,
                 int userId, String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for transfer query
            String template = "INSERT INTO {transaction_table}(fromAccountId, toAccountId, amount, transactionType,  description, reference, userId) "
                            +
                            "VALUES ({fromAccountId}, {toAccountId}, {amount}, '{transactionType}', '{description}', '{reference}' , {userId})";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "toAccountId", String.valueOf(toAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "references", referenceValue,
                            "userId", String.valueOf(userId));

            return CustomFormatter.format(template, values);
    }

    public static String getAllUserTransaction(int userId, int fromAccountId) {
        String template = "select * from {transaction_table} where userId = {userId} and fromAccountId = {fromAccountId}";
        Map<String, String> values = Map.of(
            "transaction_table", transaction_table,
            "userId", Integer.toString(userId),
            "fromAccountId", Integer.toString(fromAccountId)
        );
        return CustomFormatter.format(template, values);
    }
    


}

