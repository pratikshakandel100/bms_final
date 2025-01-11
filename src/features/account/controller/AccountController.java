package features.account.controller;

import java.util.List;

import features.account.model.Account;
import features.account.usecase.AccountUsecase;

public class AccountController {
    AccountUsecase accountUsecase;

    public AccountController(AccountUsecase accountUsecase) {
        this.accountUsecase = accountUsecase;
    };

    public void updateAccountBalance(String accountNumber, double newBalance) {
        accountUsecase.updateAccountBalance(accountNumber,newBalance);
    }

    public Account getActiveAccountFromId(int accountId) {
        return accountUsecase.getActiveAccountFromId(accountId);
    }

    public Account getActiveAccountFromAccountNumber(String accountNumber) {
        return accountUsecase.getActiveAccountFromAccountNumber(accountNumber);
    }

    public boolean openBankAccount(int userId) {
        return accountUsecase.openBankAccount(userId);
    }

    public boolean openLoanAccount(int userId, double amount) {
        return accountUsecase.openLoanAccount(userId, amount);
    }

    public List<Account> getAllActiveUserAccount(int userId){
        return accountUsecase.getAllActiveUserAccount(userId);
    }

    public List<Account> getAllInactiveUserAccount(int userId){
        return accountUsecase.getAllInactiveUserAccount(userId);
    }

    public boolean approveAccountOpeningRequest(int userId) {
        return accountUsecase.approveAccountOpeningRequest(userId);
    }

    public boolean approveLoanAccountOpeningRequest(int userId) {
        return accountUsecase.approveLoanAccountOpeningRequest(userId);
    }
    


}
