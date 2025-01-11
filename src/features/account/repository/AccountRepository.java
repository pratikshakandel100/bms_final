package features.account.repository;

import java.util.List;

import features.account.model.Account;

public interface AccountRepository{
    public boolean openBankAccount(int userId);
    public boolean openBankAccount(int userId, double amount);
    public boolean openLoanAccount(int userId, double amount);
    public void updateAccountBalance(String accountNumber, double newBalance);
    public Account getUserActiveAccountFromId(int accountId);
    public Account getUserActiveAccountFromAccountNumber(String accountNumber);
    public List<Account> getAllUserAccount(int userId, String accountStatus);
    public List<Account> getAllActiveUserAccount(int userId);
    public List<Account> getAllInactiveUserAccount(int userId);
    public List<Account> getAllClosedUserAccount(int userId);
    public boolean approveLoanAccountOpeningRequest(int userId);
    public boolean approveAccountOpeningRequest(int userId);
    
    

}
    
