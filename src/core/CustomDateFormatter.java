package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomDateFormatter {
    /**
     * Converts a date string from "E MMM dd HH:mm:ss z yyyy" format to a java.sql.Date
     * and a formatted string in "yyyy/MM/dd" format.
     *
     * @param dateStr The input date string (e.g., "Fri Jan 10 09:11:13 NPT 2025").
     * @throws ParseException If the input date string cannot be parsed.
     */
    public static String convertPickedToDateAndFormatted(String dateStr) {
        try {
            // Define the input and output formats
            SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            // Parse the input date string into a Date object
            Date parsedDate = inputFormat.parse(dateStr);
            // Format the Date object into the desired string format
            String formattedDate = outputFormat.format(parsedDate);
            // Return both results
            return formattedDate;
        } catch (ParseException ex) {
            Logger.getLogger(CustomDateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String convertJAVADateToFormatted(java.sql.Date date) {
        try {
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
            // Format the Date object into the desired string format
            String formattedDate = outputFormat.format(date);
            // Return both results
            return formattedDate;
        } catch (Exception ex) {
            Logger.getLogger(CustomDateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static java.sql.Date convertToDate(String dateStr) {
        try {
            // Define the input and output formats
            SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            // Parse the input date string into a Date object
            Date parsedDate = inputFormat.parse(dateStr);
            // Convert the Date object to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            // Return both results
            return sqlDate;
        } catch (ParseException ex) {
            Logger.getLogger(CustomDateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}