package features.transaction.view;

import features.account.controller.AccountController;
import features.account.model.Account;
import features.transaction.controller.TransactionController;

import core.BaseApp;

public class TransactionView {
    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount, String description,String reference, int userId) throws Exception{
        AccountController accountController = BaseApp.getAccountController();
        TransactionController transactionController = BaseApp.getTransactionController();
        Account fromAccount = accountController.getActiveAccountFromAccountNumber(fromAccountNumber);
        // Account toAccount = accountController.getActiveAccountFromAccountNumber(toAccountNumber);
        if(fromAccount.getBalance() > amount){
            transactionController.transfer(fromAccountNumber, toAccountNumber, amount, userId, description, reference);
        } else {
            throw new Exception("Insufficent Balance");
        }
    }

    public void depositMoney(String toAccountNumber, double amount, String description, String reference, int userId){
        // AccountController accountController = BaseApp.getAccountController();
        TransactionController transactionController = BaseApp.getTransactionController();
        // Account fromAccount = accountController.getActiveAccountFromAccountNumber(toAccountNumber);
        // Account toAccount = accountController.getActiveAccountFromAccountNumber(toAccountNumber);
        transactionController.deposit(toAccountNumber, amount, userId, description, reference);
    }

    public void withdrawMoney(String fromAccountNumber, double amount, String description,String reference, int userId) throws Exception{
        AccountController accountController = BaseApp.getAccountController();
        TransactionController transactionController = BaseApp.getTransactionController();
        Account fromAccount = accountController.getActiveAccountFromAccountNumber(fromAccountNumber);
        if(fromAccount.getBalance() > amount){
            transactionController.withdraw(fromAccountNumber, amount, userId, description, reference);
        } else {
            throw new Exception("Insufficent Balance");
        }
    }
}


