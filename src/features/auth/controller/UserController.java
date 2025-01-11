package features.auth.controller;

import core.CustomMapper;
import core.Session;
import database.DbConnection;
import features.auth.model.User;
import features.auth.utils.UserQueryManager;
import java.sql.ResultSet;


public class UserController {
    private DbConnection dbConnection = Session.getSession().getDbConnection();

    public boolean registerUser(User user) {
        // dbConnection = new DbConnection();
        String registerQuery = UserQueryManager.registerQuery(user);
        int result = dbConnection.executeOnly(registerQuery);
        return result > 0;
    }

    public User loginUser(String email, String password) {
        // dbConnection = new DbConnection();
        try {
            String loginQuery = UserQueryManager.loginQuery(email, password);
            ResultSet result = dbConnection.executeWithResult(loginQuery);
            if (result.next()) {
                System.out.println(result.getDate("dob"));
                // User user = new User();
                // user.setUserId(result.getInt("userId"));
                // user.setName(result.getString("name"));
                // user.setEmail(result.getString("email"));
                // user.setPhone(result.getString("phone"));
                // user.setAddress(result.getString("address"));
                // user.setPoints(result.getInt("points"));
                // System.out.println("-------------------\n"+user.getEmail());

                // System.out.println("##################################");

                User user = CustomMapper.mapResultSetToObject(result, User.class);
                // set currently loggedin user to active user
                Session.getSession().setUserToSession(user);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePoints(int userId, int points) {
        String query = UserQueryManager.updatePointsQuery(userId, points);
        dbConnection.executeOnly(query);
    }
}
