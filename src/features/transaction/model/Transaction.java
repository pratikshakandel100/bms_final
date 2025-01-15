package features.transaction.model;

public class Transaction {

    // Fields corresponding to the columns in the bms_transactions table
    private int transactionId;
    private int fromAccountId;
    private Integer toAccountId;  // Use Integer to allow null values
    private double amount;
    private String transactionType;
    private String description;
    private String reference;
    private java.sql.Timestamp transactionDateTime;

    // No-argument constructor
    public Transaction() {}

    // Parameterized constructor
    public Transaction(int transactionId, int fromAccountId, Integer toAccountId, double amount, String transactionType,
                          String transactionStatus, String description, String reference, java.sql.Timestamp transactionDateTime) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.reference = reference;
        this.transactionDateTime = transactionDateTime;
    }

    // Getter and Setter methods

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public java.sql.Timestamp getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(java.sql.Timestamp transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    // Optional: toString method for easy debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", description='" + description + '\'' +
                ", reference='" + reference + '\'' +
                ", transactionDateTime=" + transactionDateTime +
                '}';
    }
}

