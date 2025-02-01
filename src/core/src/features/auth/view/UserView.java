package features.auth.view;

import core.BaseApp;
import features.auth.controller.UserController;

public class UserView {
    public static void main(String[] args) {
        // User user1 = new User();
        // user1.setName("Pratiksha Kandel");
        // user1.setEmail("pratikshakandel100@gmail.com");
        // user1.setPassword("Pratiksha@123");
        // user1.setPhone("9742362390");

        // UserController uc = new UserController();
        // User result = uc.loginUser(user1.getEmail(),user1.getPassword());
        // if(result != null){
        //     System.out.println("User Login Successfully");
        // } else {
        //     System.out.println("Failed to Login User");

        // }

        boolean result = approvedBankAccount(3);
        if(result){
            System.out.println("Account Approved");
        } else {
            System.out.println("Failed to Approved");
        }


    }

    // Admin
    public static boolean approvedBankAccount(int userId){
        UserController uc = BaseApp.getUserController();
        // return uc.approveBankOpeningRequest(userId);
        return true;
    }
}
