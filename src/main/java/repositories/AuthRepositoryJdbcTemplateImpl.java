package repositories;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import repositories.interfaces.AuthRepository;


import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryJdbcTemplateImpl implements AuthRepository {
    //language=SQL
    final String SQL_CREATE = "INSERT INTO cookie (uuid) VALUE (?)";

    //language=SQL
    final String SQL_FIND = "SELECT * FROM cookie WHERE uuid = ?";

    private JdbcTemplate jdbcTemplate;

    public AuthRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public RowMapper<Cookie> cookieRowMapper = (row, i) ->
            new Cookie("UUID", row.getString("uuid"));

    @Override
    public void create(Cookie cookie) {
        jdbcTemplate.update(SQL_CREATE, cookie.getValue());
    }

    @Override
    public boolean find(Cookie cookie) {
        List<Cookie> cookies = jdbcTemplate.query(SQL_FIND, cookieRowMapper, cookie.getValue());
        return !cookies.isEmpty();
    }
}
