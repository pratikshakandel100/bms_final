package core;
import database.DbConnection;
import features.auth.model.User;

public class Session {
    private static Session session;
    private User loggedInUser;
    private DbConnection dbConnection;

    public DbConnection getDbConnection() {
        return this.dbConnection;
    }

    public void startDbConnection() {
        if(dbConnection==null){
            dbConnection = DbConnection.getInstance();
        }
    }

    public void stopDbConnection(){
        if(dbConnection != null){
            dbConnection.closeConnection();
        }
        dbConnection = null;
    }

    private Session(){

    }

    public static synchronized Session getSession(){
        if(session == null){
            session = new Session();
        }
        return session;
    }

    public void setUserToSession(User user){
        this.loggedInUser = user;
    }

    public void clearUserSession(){
        this.loggedInUser = null;
    }
    public User getLoggedInUser(){
        return this.loggedInUser;
    }
}
