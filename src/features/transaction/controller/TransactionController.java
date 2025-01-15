package features.transaction.controller;

import java.util.List;

import features.transaction.model.Transaction;
import features.transaction.usecase.TransactionUsecase;

public class TransactionController {
    private TransactionUsecase transactionUsecase;

    public TransactionController(TransactionUsecase transactionUsecase) {
        this.transactionUsecase = transactionUsecase;
    }

    public boolean deposit(String accountNumber, double amount, int userId, String description, String references) {
        return transactionUsecase.deposit(accountNumber, amount, userId, description, references);
    }

    public boolean withdraw(String accountNumber, double amount, int userId, String description, String references){
        return transactionUsecase.withdraw(accountNumber, amount, userId, description, references);   
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount, int userId, String description, String references) {
        return transactionUsecase.transfer(fromAccountNumber, toAccountNumber, amount, userId, description, references);
    }

    public List<Transaction> getAllUserTransaction(int userId,int accountId) {
        return transactionUsecase.getAllUserTransaction(userId, accountId);
    }
    
}
