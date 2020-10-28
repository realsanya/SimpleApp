package services.interfaces;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    Optional<User> getUserById(Integer id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    List<User> getUsersByAge(String age);
}
