package core;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomMapper {

    public static <T> T mapResultSetToObject(ResultSet resultSet, Class<T> klass) throws SQLException {
        try {
            // Create an instance of the target class
            T object = klass.getDeclaredConstructor().newInstance();

            // Loop through all declared fields in the class
            for (Field field : klass.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields

                // Map field names (case-insensitive) to column names in ResultSet
                try {
                    Object value = resultSet.getObject(field.getName());
                    if (value != null) {
                        field.set(object, value); // Set field value
                    }
                } catch (SQLException e) {
                    // Ignore fields that don't match any column in ResultSet
                }
            }
            return object
        } catch (Exception e) {
            throw new RuntimeException("Error mapping ResultSet to object: " + e.getMessage(), e);
        }
    }
}

