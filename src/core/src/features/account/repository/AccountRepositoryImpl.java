package features.account.repository;

import core.BaseApp;
import core.CustomMapper;
import core.Session;
import database.DbConnection;
import features.account.model.Account;
import features.account.model.AccountType;
import features.account.utils.AccountQueryManager;
import features.notification.utils.NotificationStringManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{

   private DbConnection dbConnection = Session.getSession().getDbConnection();

   @Override
    public boolean openBankAccount(int userId) {
        return openBankAccount(userId, 0.0);
    }

    @Override
    public boolean openBankAccount(int userId, double amount) {
        String generatedAccountNumber = generateAccountNumber();
        boolean isNormalAccountCreated = createBankAccount(userId, generatedAccountNumber, AccountType.NORMAL, amount);
        boolean isSaverAccountCreated = createBankAccount(userId, generatedAccountNumber, AccountType.SAVER, amount);
        return isNormalAccountCreated && isSaverAccountCreated;
    }

    @Override
    public boolean openLoanAccount(int userId, double amount) {
        String generatedAccountNumber = generateAccountNumber();
        boolean isLoanAccountCreated = createBankAccount(userId, generatedAccountNumber,AccountType.LOAN, -amount);
        return isLoanAccountCreated;
    }

    private boolean createBankAccount(int userId, String accountNumber, AccountType accountType, double amount) {
        // User loggedInUser = Session.getSession().getLoggedInUser();
        if (accountType == AccountType.NORMAL) {
            accountNumber = accountNumber + "N";
        } else if (accountType == AccountType.SAVER) {
            accountNumber = accountNumber + "S";
        } else {
            accountNumber = accountNumber + "L";
        }
        String accountQuery = AccountQueryManager.createAccountQuery(userId, accountNumber, accountType.name(), amount);
        int result = dbConnection.executeOnly(accountQuery);
        return (result > 0) ? true : false;
    }
    
    private String generateAccountNumber() {
        // Step 1: Generate a 15-digit random number
        String generatedRandomNumber = String.format("%015d", (int) (Math.random() * 100_000_000_000_0000L));

        // Step 2: Shuffle the digits
        String[] shuffleNumberList = generatedRandomNumber.split("");
        Collections.shuffle(Arrays.asList(shuffleNumberList));

        // Step 3: Join shuffled digits into a string
        return String.join("", shuffleNumberList);
    }

    @Override
    public void updateAccountBalance(String accountNumber, double newBalance) {
        String query = AccountQueryManager.updateAccountBalanceQuery(accountNumber, newBalance);
        dbConnection.executeOnly(query);
    }

    private Account getAccount(String accountId, String accountNumber, String accountStatus) {
        Account account = null; // Initialize the variable
        try {
            String query = AccountQueryManager.getAccountQuery(accountId,accountNumber,accountStatus);
            ResultSet result = dbConnection.executeWithResult(query);
            if (result.next()) { // Use if instead of while, as we expect only one result
                account = CustomMapper.mapResultSetToObject(result, Account.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account; // Return null if no result is found or exception occurs
    }
    public Account getUserActiveAccountFromId(int accountId){
        return getAccount(Integer.toString(accountId), null, "Active");
    }

    public Account getUserActiveAccountFromAccountNumber(String accountNumber) {
        return getAccount(null, accountNumber, "Active");
    }

    public List<Account> getAllUserAccountByStatus(int userId, String accountStatus) {
        List<Account> accounts = new ArrayList<>(); // Initialize the variable
        try {
            String query = AccountQueryManager.getAllUserAccountByStatusQuery(userId, accountStatus);
            ResultSet result = dbConnection.executeWithResult(query);
            while (result.next()) { // Use if instead of while, as we expect only one result
                Account account = CustomMapper.mapResultSetToObject(result, Account.class);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts; // Return null if no result is found or exception occurs
    }
    
    public List<Account> getAllUserAccount(int userId) {
        List<Account> accounts = new ArrayList<>(); // Initialize the variable
        try {
            String query = AccountQueryManager.getAllUserAccountQuery(userId);
            ResultSet result = dbConnection.executeWithResult(query);
            while (result.next()) { // Use if instead of while, as we expect only one result
                Account account = CustomMapper.mapResultSetToObject(result, Account.class);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts; // Return null if no result is found or exception occurs
    }

    public List<Account> getAllActiveUserAccount(int userId) {
//        System.out.println(getAllUserAccountByStatus(userId, "Active"));
        return getAllUserAccountByStatus(userId, "Active");
    }

    public List<Account> getAllInactiveUserAccount(int userId) {
        return getAllUserAccountByStatus(userId, "Inactive");
    }

    public List<Account> getAllClosedUserAccount(int userId) {
        return getAllUserAccountByStatus(userId, "Closed");
    }

    public boolean approveAccountOpeningRequest(int userId) {  
        String requestQuery = AccountQueryManager.acceptAccountOpeningRequestQuery(userId);
        int result = dbConnection.executeOnly(requestQuery);
        if (result > 0) {
            // Create Notification using NotificationUseCase
            boolean notificationResult = BaseApp.getNotificationController().createNotification(
                    userId,
                    NotificationStringManager.ACCOUNT_OPENED_TITLE,
                    NotificationStringManager.ACCOUNT_OPENED_MESSAGE);
            return notificationResult; // Return notification result
        }
        return false; // Approval failed
    }

    public boolean approveLoanAccountOpeningRequest(int userId) {
        String requestQuery = AccountQueryManager.acceptLoanAccountOpeningRequestQuery(userId);
        int result = dbConnection.executeOnly(requestQuery);
        if (result > 0) {
            // Create Notification using NotificationUseCase
            boolean notificationResult = BaseApp.getNotificationController().createNotification(
                    userId,
                    NotificationStringManager.LOAN_ACCOUNT_APPROVED_TITLE,
                    NotificationStringManager.LOAN_ACCOUNT_APPROVED_MESSAGE);
            return notificationResult; // Return notification result
        }
        return false; // Approval failed
    }
}
    

