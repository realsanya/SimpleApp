package repositories;

import models.User;
import repositories.interfaces.RowMapper;
import repositories.interfaces.UserRepository;

import javax.sql.DataSource;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }

    //language=SQL
    private final String SQL_INSERT_USERS = "INSERT INTO user" + "( name, surname," +
            "age, password, email) VALUES" + "(?, ? , ? , ? , ? );";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_AGE = "SELECT * FROM user WHERE age = ?";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email= ?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .name(row.getString("name"))
            .surname(row.getString("surname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    @Override
    public User findByEmail(String email) {
        List<User> users = template.query(SQL_SELECT_BY_EMAIL, userRowMapper, email);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public List<User> findByAge(Integer age) {
        return template.query(SQL_SELECT_BY_AGE, userRowMapper, age);
    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public User findById(Long id) {
        List<User> users = template.query(SQL_SELECT_BY_ID, userRowMapper, id);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public void save(User user) {
        template.queryInsert(SQL_INSERT_USERS,
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getAge());
    }
}
