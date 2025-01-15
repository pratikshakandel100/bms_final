package features.auth.controller;


import features.auth.model.User;
import features.auth.usecase.UserUsecase;

public class UserController {
    private UserUsecase userUsecase;

    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    public boolean registerUser(User user){
        return userUsecase.registerUser(user);
    }

    public User loginUser(String email, String password){
        return userUsecase.loginUser(email, password);
    }

    public User getUserDetails(int userId){
        return userUsecase.getUserDetails(userId);
    }

    public void updateUserPoints(int points, int userId){
        userUsecase.updateUserPoints(points, userId);
    }
}