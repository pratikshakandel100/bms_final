package features.auth.utils;

import core.CustomDateFormatter;
import core.CustomFormatter;
import features.auth.model.User;
import java.util.Map;



// Users Queries
public class UserQueryManager {
    static String user_table = "bms_users";
    static String account_table = "bms_accounts";

// Register Query
public static String registerQuery(User user) {
    String template = "insert into {user_table}(name,email,password,phone,dob) values('{name}','{email}','{password}','{phone}','{dob}')";
    String hashedPassword = PasswordManager.hashPassword(user.getPassword());
    Map<String, String> values = Map.of("user_table", user_table, "name",user.getName(),"email",user.getEmail(),"password",hashedPassword,"phone",user.getPhone(),"dob",CustomDateFormatter.convertJAVADateToFormatted(user.getDOB()));
    return CustomFormatter.format(template, values);
}
    

// Login Query
public static String loginQuery(String email, String password) {
    String template = "select * from {user_table} where email = '{email}' and password = '{password}'";
    String hashedPassword = PasswordManager.hashPassword(password);
    Map<String, String> values = Map.of("user_table", user_table, "email",email,"password",hashedPassword);
    return CustomFormatter.format(template, values);
}

public static String viewAllUser() {
String template = "SELECT * FROM {user_table}";
Map<String, String> values = Map.of("user_table", "bms_users");
return CustomFormatter.format(template, values);
}

public static String getUserById(String userId) {
    String template = "SELECT * FROM {user_table} WHERE userId = {userId}";
    Map<String, String> values = Map.of("user_table", "bms_users", "userId", userId);
    return CustomFormatter.format(template, values);
}

public static String deleteUserById(String userId) {
    String template = "DELETE FROM {user_table} WHERE userId = {userId}";
    Map<String, String> values = Map.of("user_table", "bms_users", "userId", userId);
    return CustomFormatter.format(template, values);
}

public static String deleteAllUsers() {
    String template = "DELETE FROM {user_table}";
    Map<String, String> values = Map.of("user_table", "bms_users");
    return CustomFormatter.format(template, values);
}

public static String insertUser() {
    String template = "INSERT INTO {user_table} (name, email, password, phone, address, points) VALUES ('{name}', '{email}', '{password}', '{phone}', '{address}', {points})";
    Map<String, String> values = Map.of("user_table", "bms_users", "name", "{name}", "email", "{email}", "password", "{password}", "phone", "{phone}", "address", "{address}", "points", "{points}");
    return CustomFormatter.format(template, values);
} 

public static String updateUserPointsQuery(int userId, int points) {
    String template = "update {user_table} set points = points+{points} where userId = {userId}";
    Map<String, String> values = Map.of("user_table", user_table, "points", Integer.toString(points), "userId",
            Integer.toString(userId));
    return CustomFormatter.format(template, values);
}


    

}
