package features.transaction.usecase;

import java.util.List;

import features.transaction.model.Transaction;
import features.transaction.repository.TransactionRepository;

public class TransactionUsecase {
    private TransactionRepository transactionRepository;

    public TransactionUsecase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public boolean deposit(String accountNumber, double amount, int userId, String description, String references) {
        return transactionRepository.deposit(accountNumber, amount, userId, description, references);
    }

    public boolean withdraw(String accountNumber, double amount, int userId, String description, String references){
        return transactionRepository.withdraw(accountNumber, amount, userId, description, references);   
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount, int userId, String description, String references) {
        return transactionRepository.transfer(fromAccountNumber, toAccountNumber, amount, userId, description, references);
    }

    public List<Transaction> getAllUserTransaction(int userId,int accountId) {
        return transactionRepository.getAllUserTransaction(userId, accountId);
    }
    
}
