package features.notification.utils;

public class NotificationStringManager {

    // Account Notifications
    public static final String ACCOUNT_OPENED_TITLE = "Account Opened Successfully";
    public static final String ACCOUNT_OPENED_MESSAGE = "Congratulations! Your bank account has been opened.";

    // LOAN Account Notifications
    public static final String LOAN_ACCOUNT_APPROVED_TITLE = "Loan Account Opened Successfully";
    public static final String LOAN_ACCOUNT_APPROVED_MESSAGE = "Congratulations! Your loan account has been approved.";

    // Amount withdraw Notifications
    public static final String AMOUNT_WITHDRAW_TITLE = "Amount Withdraw";
    public static final String AMOUNT_WITHDRAW_MESSAGE = "You have withdraw Rs.%s for `%s`.";

    // Payment Notifications
    public static final String PAYMENT_SENT_TITLE = "Payment Sent";
    public static final String PAYMENT_SENT_MESSAGE = "You have sent Rs.%s to %s(Account Number: %s)";
    public static final String PAYMENT_RECEIVED_TITLE = "Payment Received";
    public static final String PAYMENT_RECEIVED_MESSAGE = "You have received Rs.%s from %s(Account Number: %s)";
    
    // Generic Notifications
    public static final String SUCCESS_MESSAGE = "Operation completed successfully!";
    public static final String FAILURE_MESSAGE = "Operation failed. Please try again!";

    // KYC Notification
    public static final String KYC_APPROVED_TITLE = "KYC Approved";
    public static final String KYC_APPROVED_MESSAGE = "Dear %s, Your KYC is now approved";
}
