package features.notification.model;

import java.sql.Timestamp;

public class Notification {
    private int notificationId;
    private int userId;
    private String title;
    private String message;
    private boolean isSeen;
    private Timestamp createdAt;

    // Default Constructor
    public Notification(){}

    // Public constructor
    public Notification(int notificationId, int userId, String title, String message, boolean isSeen, Timestamp createdAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.isSeen = isSeen;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getId() {
        return notificationId;
    }

    public void setId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

