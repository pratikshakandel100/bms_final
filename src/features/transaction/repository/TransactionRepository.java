package features.transaction.repository;

import java.util.List;

import features.transaction.model.Transaction;

public interface TransactionRepository {
    public boolean deposit(String accountNumber, double amount, int userId, String description, String references);
    public boolean withdraw(String accountNumber, double amount, int userId, String description, String references);
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount, int userId, String description, String references);
    public List<Transaction> getAllUserTransaction(int userId,int accountId);
}
