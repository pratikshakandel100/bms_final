package features.auth.repository;

import features.auth.model.User;
import java.util.List;

public interface UserRepository {
    public boolean registerUser(User user);
    public User loginUser(String email, String password);
    public void updateUserPoints(int points, int userId);
    public User getUserDetails(int userId);
    public List<User> getAllUser();
    public boolean updateUserDetail(User user);
}
