package features.account.view;

import core.BaseApp;
import core.Session;
import features.account.controller.AccountController;
import features.account.model.Account;

public class AccountView {
    public static void main(String[] args) {
        Session.getSession().startDbConnection();
        AccountController ac = BaseApp.getAccountController();
        Account result = ac.getActiveAccountFromAccountNumber("040087460071324N");
        System.out.println(result.getAccountType());
    }
}
