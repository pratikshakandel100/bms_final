package features.auth.usecase;

import features.auth.model.User;
import features.auth.repository.UserRepository;
import java.util.List;

public class UserUsecase {
    private UserRepository userRepository;

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user){
        return userRepository.registerUser(user);
    }

    public User loginUser(String email, String password){
        return userRepository.loginUser(email, password);
    }

    public User getUserDetails(int userId){
        return userRepository.getUserDetails(userId);
    }

    public void updateUserPoints(int points, int userId){
        userRepository.updateUserPoints(points, userId);
    }
    
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
    
    public boolean updateUserDetail(User user) {
        return userRepository.updateUserDetail(user);
    }
    
}
