package features.auth.repository;

import features.auth.model.User;

public interface UserRepository {
    public boolean registerUser(User user);
    public User loginUser(String email, String password);
    public void updateUserPoints(int points, int userId);
    public User getUserDetails(int userId);
}
