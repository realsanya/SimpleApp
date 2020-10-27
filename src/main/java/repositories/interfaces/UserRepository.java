package repositories.interfaces;

import models.User;

import java.util.List;

public interface UserRepository extends OrmRepository<User> {
    User findByEmail(String email);

    List<User> findByAge(Integer age);
}
