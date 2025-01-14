package features.account.usecase;

import features.account.model.Account;
import features.account.repository.AccountRepository;
import java.util.List;

public class AccountUsecase {
    AccountRepository accountRepository;

    public AccountUsecase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    };

    public void updateAccountBalance(String accountNumber, double newBalance) {
        accountRepository.updateAccountBalance(accountNumber,newBalance);
    }

    public Account getActiveAccountFromId(int accountId) {
        return accountRepository.getUserActiveAccountFromId(accountId);
    }

    public Account getActiveAccountFromAccountNumber(String accountNumber) {
        return accountRepository.getUserActiveAccountFromAccountNumber(accountNumber);
    }

    public boolean openBankAccount(int userId) {
        return accountRepository.openBankAccount(userId);
    }

    public boolean openLoanAccount(int userId, double amount) {
        return accountRepository.openLoanAccount(userId, amount);
    }

    public List<Account> getAllActiveUserAccount(int userId){
        return accountRepository.getAllActiveUserAccount(userId);
    }

    public List<Account> getAllInactiveUserAccount(int userId){
        return accountRepository.getAllInactiveUserAccount(userId);
    }  

    public boolean approveAccountOpeningRequest(int userId) {
        return accountRepository.approveAccountOpeningRequest(userId);
    }

    public boolean approveLoanAccountOpeningRequest(int userId) {
        return accountRepository.approveLoanAccountOpeningRequest(userId);
    }
    
    public List<Account> getAllUserAccountByStatus(int userId, String accountStatus) {
        return accountRepository.getAllUserAccountByStatus(userId, accountStatus);
    }
    
    public List<Account> getAllUserAccount(int userId) {
        return accountRepository.getAllUserAccount(userId);
    }
    


}
