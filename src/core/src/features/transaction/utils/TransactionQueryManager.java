package features.transaction.utils;

import java.util.Map;

import core.CustomFormatter;

public class TransactionQueryManager {
    static String transaction_table =  TranscationStringManager.TRANSACTION_TABLE_NAME;

    // ---------------------------- 1. DEPOSIT QUERY ---------------------------- //
    public static String insertDepositQuery(int fromAccountId, double amount, String transactionType,  String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for deposit query
            String template = "INSERT INTO {transaction_table}(fromAccountId, amount, transactionType, description, reference) "
                            +
                            "VALUES ({fromAccountId}, {amount}, '{transactionType}', '{description}', '{reference}')";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "reference", referenceValue);

            return CustomFormatter.format(template, values);
    }

    // ---------------------------- 2. WITHDRAW QUERY ----------------------------
    // //
    public static String insertWithdrawQuery(int fromAccountId, double amount, String transactionType,
                     String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for withdraw query
            String template = "INSERT INTO {transaction_table}(fromAccountId, amount, transactionType, description, reference) "
                            +
                            "VALUES ({fromAccountId}, {amount}, '{transactionType}', '{description}','{reference}')";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", 
                            transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "reference", referenceValue);

            return CustomFormatter.format(template, values);
    }

    // ---------------------------- 3. TRANSFER QUERY ----------------------------
    // //
    public static String insertTransferQuery(int fromAccountId, int toAccountId, double amount, String transactionType,
            String description, String reference) {
            // Allow references to be NULL
            String referenceValue = (reference == null || reference.isEmpty()) ? "NULL" : reference;

            // Template for transfer query
            String template = "INSERT INTO {transaction_table}(fromAccountId, toAccountId, amount, transactionType,  description, reference) "
                            +
                            "VALUES ({fromAccountId}, {toAccountId}, {amount}, '{transactionType}', '{description}', '{reference}')";

            // Map values
            Map<String, String> values = Map.of(
                            "transaction_table", transaction_table,
                            "fromAccountId", String.valueOf(fromAccountId),
                            "toAccountId", String.valueOf(toAccountId),
                            "amount", String.valueOf(amount),
                            "transactionType", transactionType,
                            "description", description,
                            "reference",reference);

            return CustomFormatter.format(template, values);
    }

    public static String getAllUserTransaction(int fromAccountId) {
        String template = "select * from {transaction_table} where fromAccountId = {fromAccountId}";
        Map<String, String> values = Map.of(
            "transaction_table", transaction_table,
            "fromAccountId", Integer.toString(fromAccountId)
        );
        return CustomFormatter.format(template, values);
    }
    


}

