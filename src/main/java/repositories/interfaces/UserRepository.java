package repositories.interfaces;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    List<User> findAllByAge(String age);

    User findByEmail(String email);
}
