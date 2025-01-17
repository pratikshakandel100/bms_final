package features.transaction.controller;

import java.util.List;

import features.transaction.model.Transaction;
import features.transaction.usecase.TransactionUsecase;

public class TransactionController {
    private TransactionUsecase transactionUsecase;

    public TransactionController(TransactionUsecase transactionUsecase) {
        this.transactionUsecase = transactionUsecase;
    }

    public boolean paySomeone(String fromAccountNumber, String toAccountNumber, double amount, String description, String references) {
        return transactionUsecase.paySomeone(fromAccountNumber,toAccountNumber,amount, description, references);
    }
    
    public String atmDeposit(String accountNumber, double amount, String description, String references) {
        return transactionUsecase.atmDeposit(accountNumber, amount,description, references);
    }

    public String atmWithdraw(String accountNumber, double amount, String description, String references){
        return transactionUsecase.atmWithdraw(accountNumber, amount, description, references);   
    }

    public boolean transferBetweenAccount(String fromAccountNumber, String toAccountNumber, double amount, String description, String references) {
        return transactionUsecase.transferBetweenAccount(fromAccountNumber, toAccountNumber, amount, description, references);
    }

    public List<Transaction> getAllUserTransaction(int accountId) {
        return transactionUsecase.getAllUserTransaction(accountId);
    }
    
}
