package core;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smike
 */
public class CustomOtpGenerator {

    private static final int OTP_LENGTH = 6;

    /**
     * Generates a random 6-digit OTP using basic Java utilities.
     * @return A 6-digit OTP as a String.
     */
    public static String generateOTP() {
        long timeSeed = System.currentTimeMillis(); // Current time in milliseconds
        double randomSeed = Math.random() * timeSeed; // Random value multiplied by the time seed
        String seedString = String.valueOf(randomSeed).replace(".", ""); // Remove decimal point
        
        // Take the first OTP_LENGTH digits from the seed string
        String otp = seedString.substring(0, OTP_LENGTH);
        return otp;
    }
}

