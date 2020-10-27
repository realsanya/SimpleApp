package services.interfaces;

import models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getUserById(Integer id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    List<User> getUsersByAge(Integer age);
}
