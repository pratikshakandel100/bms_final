package database;

import java.sql.*;

public class DbConnection {
    private static DbConnection instance;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    int value;

    private DbConnection(){
        connectDatabase();
    }

    // single instance for entire project life
    public static DbConnection getInstance(){
        if(instance == null){
            synchronized (DbConnection.class){
                if(instance == null){
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    // insert, update, delete
    public int executeOnly(String query){
        try {
            value= statement.executeUpdate(query);
        } catch(SQLException exception){
            System.out.println(exception);
        }
        return value;
    }

    // select command
    public ResultSet executeWithResult(String query){
        try {
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    private void connectDatabase(){
        try {
            String username = "root";
            String password = "root";
            String dbName = "bms";
            String db_url = String.format("jdbc:mysql://localhost:3306/%s", dbName);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(db_url, username, password);
            if(connection != null){
                System.out.println("\n"+dbName+" Database connected");
                statement = connection.createStatement();
            } else {
                System.out.println("Error connecting on database");
            }
        } catch (Exception e) {
            System.out.println("Error connecting on database");
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            if(connection != null){
                connection.close();;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
