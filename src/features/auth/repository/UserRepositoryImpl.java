package features.auth.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DbConnection;
import features.auth.model.User;
import features.auth.utils.UserQueryManager;
import core.CustomMapper;
import core.Session;

public class UserRepositoryImpl implements UserRepository{
    private DbConnection dbConnection = Session.getSession().getDbConnection();
    
    @Override
    public void updateUserPoints(int points, int userId) {
        String query = UserQueryManager.updateUserPointsQuery(userId, points);
        dbConnection.executeOnly(query);
    }

    @Override
    public User getUserDetails(int userId) {
        String query = UserQueryManager.getUserById(String.valueOf(userId)); 
        ResultSet result = dbConnection.executeWithResult(query);
        try {
            if(result.next()){
                User user = CustomMapper.mapResultSetToObject(result, User.class);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }    
    
    @Override
    public boolean registerUser(User user) {
        // dbConnection = new DbConnection();
        String registerQuery = UserQueryManager.registerQuery(user);
        int result = dbConnection.executeOnly(registerQuery);
        return result > 0;
    }

    @Override
    public User loginUser(String email, String password) {
        // dbConnection = new DbConnection();
        try {
            String loginQuery = UserQueryManager.loginQuery(email, password);
            ResultSet result = dbConnection.executeWithResult(loginQuery);
            if (result.next()) {
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

}
