package features.transaction.usecase;

import java.util.List;

import features.transaction.model.Transaction;
import features.transaction.repository.TransactionRepository;

public class TransactionUsecase {
    private TransactionRepository transactionRepository;

    public TransactionUsecase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public boolean paySomeone(String fromAccountNumber, String toAccountNumber, double amount, String description, String references) {
        return transactionRepository.paySomeone(fromAccountNumber,toAccountNumber,amount, description, references);
    }
    
    public String atmDeposit(String accountNumber, double amount, String description, String references) {
        return transactionRepository.atmDeposit(accountNumber, amount,description, references);
    }

    public String atmWithdraw(String accountNumber, double amount,String description, String references){
        return transactionRepository.atmWithdraw(accountNumber, amount, description, references);   
    }

    public boolean transferBetweenAccount(String fromAccountNumber, String toAccountNumber, double amount, String description, String references) {
        return transactionRepository.transferBetweenAccount(fromAccountNumber, toAccountNumber, amount, description, references);
    }

    public List<Transaction> getAllUserTransaction(int accountId) {
        return transactionRepository.getAllUserTransaction(accountId);
    }
    
}
