package features.account.view;

import core.BaseApp;
import core.Session;
import features.account.controller.AccountController;
import features.account.model.Account;
import java.util.List;

public class AccountView {
    public static void main(String[] args) {
        Session.getSession().startDbConnection();
        AccountController ac = BaseApp.getAccountController();
        List<Account> result = ac.getAllActiveUserAccount(1);
        System.out.println(String.valueOf(result.getLast().getBalance()));
    }
}
