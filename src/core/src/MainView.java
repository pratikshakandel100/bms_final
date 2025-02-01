
// UI Design

import core.Session;
import features.auth.view.LoginScreen;

public class MainView {
    public static void main(String[] args) {
        Session currentSession = Session.getSession();
        currentSession.startDbConnection();
        
        new LoginScreen().setVisible(true);
    }
}
