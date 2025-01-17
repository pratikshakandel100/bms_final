package features.transaction.repository;

import core.CustomMapper;
import core.CustomOtpGenerator;
import core.Session;
import database.DbConnection;
import features.account.model.Account;
import features.account.repository.AccountRepository;
import features.account.repository.AccountRepositoryImpl;
import features.auth.repository.UserRepositoryImpl;
import features.notification.repository.NotificationRepository;
import features.notification.repository.NotificationRepositoryImpl;
import features.notification.utils.NotificationStringManager;
import features.transaction.model.Transaction;
import features.transaction.model.TransactionType;
import features.transaction.utils.TransactionQueryManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private DbConnection dbConnection = Session.getSession().getDbConnection();
    AccountRepository accountRepository = new AccountRepositoryImpl();
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    NotificationRepository notificationRepository = new NotificationRepositoryImpl();

  

    @Override
    public boolean paySomeone(String fromAccountNumber, String toAccountNumber, double amount, String description, String references) {
                try {
            // Fetch sender receiverAccount details
            Account fromAccount = accountRepository.getUserActiveAccountFromAccountNumber(fromAccountNumber);
            if (fromAccount == null || fromAccount.getBalance() < amount) {
                System.out.println("Transfer failed: Insufficient funds or inactive sender account.");
                return false;
            }

            // Fetch receiver receiverAccount details
            Account toAccount = accountRepository.getUserActiveAccountFromAccountNumber(toAccountNumber);
            if (toAccount == null) {
                System.out.println("Transfer failed: Receiver account not found or inactive.");
                return false;
            }

            // Update balances
            accountRepository.updateAccountBalance(fromAccountNumber, -amount);
            accountRepository.updateAccountBalance(toAccountNumber, amount);

            // Insert transaction record
            String query = TransactionQueryManager.insertTransferQuery(
                    fromAccount.getAccountId(), toAccount.getAccountId(), amount, TransactionType.PAYMENT.name(),
                    description, references);
            dbConnection.executeOnly(query);

            // Reward points for OTHER transactions
            if (fromAccount.getUserId() != toAccount.getUserId()) {
                int pointsToAdd = (int) (amount * 0.1); // 10% reward points
                userRepository.updateUserPoints(fromAccount.getUserId(), pointsToAdd);
            }

            // Create notifications for both sender and receiver
            notificationRepository.createNotification(fromAccount.getUserId(),
                    NotificationStringManager.PAYMENT_SENT_TITLE,
                    String.format(NotificationStringManager.PAYMENT_SENT_MESSAGE, amount,
                            userRepository.getUserDetails(toAccount.getUserId()).getName(), toAccountNumber));

            notificationRepository.createNotification(toAccount.getUserId(),
                    NotificationStringManager.PAYMENT_RECEIVED_TITLE,
                    String.format(NotificationStringManager.PAYMENT_RECEIVED_MESSAGE, amount,
                            userRepository.getUserDetails(fromAccount.getUserId()).getName(), fromAccountNumber));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public String atmDeposit(String accountNumber, double amount, String description, String references) {
        String otp="";
        try {
            // Fetch receiverAccount details
            Account account = accountRepository.getUserActiveAccountFromAccountNumber(accountNumber);
            if (account == null) {
                System.out.println("Deposit failed: Account not found or inactive.");
                return null;
            }

            // Update balance
            accountRepository.updateAccountBalance(accountNumber, amount);
            otp = CustomOtpGenerator.generateOTP();
            

            // Insert transaction record
            String query = TransactionQueryManager.insertDepositQuery(
                    account.getAccountId(), amount, TransactionType.ATM_DEPOSIT.name(), description,
                    references);
            dbConnection.executeOnly(query);

            // Create notification
            notificationRepository.createNotification(account.getUserId(),
                    NotificationStringManager.PAYMENT_RECEIVED_TITLE,
                    String.format(NotificationStringManager.PAYMENT_RECEIVED_MESSAGE, amount,
                            userRepository.getUserDetails(account.getUserId()).getName(), accountNumber));
            
            notificationRepository.createNotification(account.getUserId(),
                    NotificationStringManager.ATM_DEPOSIT_TITLE,
                    String.format(NotificationStringManager.ATM_DEPOSIT_MESSAGE, otp));
            return otp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }

    @Override
    public String atmWithdraw(String accountNumber, double amount, String description, String references) {
        String otp="";
        try {
            // Fetch receiverAccount details
            Account account = accountRepository.getUserActiveAccountFromAccountNumber(accountNumber);
            if (account == null || account.getBalance() < amount) {
                System.out.println("Withdraw failed: Account not found, inactive, or insufficient balance.");
                return null;
            }

            // Update balance
            accountRepository.updateAccountBalance(accountNumber, -amount);
            otp = CustomOtpGenerator.generateOTP();

            // Insert transaction record
            String query = TransactionQueryManager.insertWithdrawQuery(
                    account.getAccountId(), amount, TransactionType.ATM_WITHDRAW.name(), description,
                    references);
            dbConnection.executeOnly(query);

            // Create notification
            notificationRepository.createNotification(account.getUserId(),
                    NotificationStringManager.AMOUNT_WITHDRAW_TITLE,
                    String.format(NotificationStringManager.AMOUNT_WITHDRAW_MESSAGE, amount, description));
            
            notificationRepository.createNotification(account.getUserId(),
                    NotificationStringManager.ATM_WITHDRAW_TITLE,
                    String.format(NotificationStringManager.ATM_WITHDRAW_MESSAGE, otp));
            return otp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }

    @Override
    public boolean transferBetweenAccount(String fromAccountNumber, String toAccountNumber, double amount,
            String description, String references) {
        try {
            // Fetch sender receiverAccount details
            Account fromAccount = accountRepository.getUserActiveAccountFromAccountNumber(fromAccountNumber);
            if (fromAccount == null || fromAccount.getBalance() < amount) {
                System.out.println("Transfer failed: Insufficient funds or inactive sender account.");
                return false;
            }

            // Fetch receiver receiverAccount details
            Account toAccount = accountRepository.getUserActiveAccountFromAccountNumber(toAccountNumber);
            if (toAccount == null) {
                System.out.println("Transfer failed: Receiver account not found or inactive.");
                return false;
            }

            // Update balances
            accountRepository.updateAccountBalance(fromAccountNumber, -amount);
            accountRepository.updateAccountBalance(toAccountNumber, amount);

            // Insert transaction record
            String query = TransactionQueryManager.insertTransferQuery(
                    fromAccount.getAccountId(), toAccount.getAccountId(), amount, TransactionType.TRANSFER.name(),
                    description, references);
            dbConnection.executeOnly(query);

            // Reward points for OTHER transactions
            if (fromAccount.getUserId() != toAccount.getUserId()) {
                int pointsToAdd = (int) (amount * 0.1); // 10% reward points
                userRepository.updateUserPoints(fromAccount.getUserId(), pointsToAdd);
            }

            // Create notifications for both sender and receiver
            notificationRepository.createNotification(fromAccount.getUserId(),
                    NotificationStringManager.PAYMENT_SENT_TITLE,
                    String.format(NotificationStringManager.PAYMENT_SENT_MESSAGE, amount,
                            userRepository.getUserDetails(toAccount.getUserId()).getName(), toAccountNumber));

            notificationRepository.createNotification(toAccount.getUserId(),
                    NotificationStringManager.PAYMENT_RECEIVED_TITLE,
                    String.format(NotificationStringManager.PAYMENT_RECEIVED_MESSAGE, amount,
                            userRepository.getUserDetails(fromAccount.getUserId()).getName(), fromAccountNumber));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Transaction> getAllUserTransaction(int accountId) {
        List<Transaction> transactionList = new ArrayList<>(); // Initialize the variable
        try {
            String query = TransactionQueryManager.getAllUserTransaction(accountId);
            ResultSet result = dbConnection.executeWithResult(query);
            while (result.next()) { // Use if instead of while, as we expect only one result
                Transaction transaction = CustomMapper.mapResultSetToObject(result, Transaction.class);
                transactionList.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionList; // Return null if no result is found or exception occurs
    }

}
