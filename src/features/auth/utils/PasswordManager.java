package features.auth.utils;

import java.security.MessageDigest;

public class PasswordManager {
    public static String hashPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b:hashedBytes){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();  
        } catch (Exception e) {
            throw new RuntimeException("Error in hashing password");
        }
    }

    public static void main(String[] args) {
        hashPassword("Pratiksha@123");
    }
}
