package features.transaction.repository;

import java.util.List;

import features.transaction.model.Transaction;

public interface TransactionRepository {
    public boolean paySomeone(String fromAccountNumber, String toAccountNumber, double amount, String description, String references);
    public String atmDeposit(String accountNumber, double amount, String description, String references);
    public String atmWithdraw(String accountNumber, double amount, String description, String references);
    public boolean transferBetweenAccount(String fromAccountNumber, String toAccountNumber, double amount, String description, String references);
    public List<Transaction> getAllUserTransaction(int accountId);
}
