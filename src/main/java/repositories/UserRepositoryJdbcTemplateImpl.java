package repositories;

import models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.interfaces.UserRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcTemplateImpl implements UserRepository {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_AGE = "SELECT * FROM user WHERE age = ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

    //language=SQL
    private final String SQL_INSERT = "INSERT INTO user ( first_name, last_name, age, email, password) VALUES ( ?, ? , ? , ? , ?);";

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .firstName(row.getString("first_name"))
            .lastName(row.getString("last_name"))
            .age(row.getString("age"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    public UserRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<User> findAllByAge(String age) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_AGE, userRowMapper, age);
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public User findByEmail(String email) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return user;
    }

    @Override
    public void save(User user) {
        System.out.println(user.getLastName());
        jdbcTemplate.update(SQL_INSERT, user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public void update(User entity) {
        throw new IllegalStateException();
    }

    @Override
    public void deleteById(Long id) {
        throw new IllegalStateException();
    }

    @Override
    public void delete(User entity) {
        throw new IllegalStateException();
    }
}
