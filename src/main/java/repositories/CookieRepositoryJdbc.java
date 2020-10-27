package repositories;

import repositories.interfaces.CookieRepository;
import repositories.interfaces.RowMapper;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.util.List;

public class CookieRepositoryJdbc implements CookieRepository {
    private DataSource dataSource;
    private final SimpleJdbcTemplate template;

    //language=SQL
    final String SQL_CREATE = "INSERT INTO cookie (uuid) VALUES ?";

    //language=SQL
    final String SQL_FIND = "SELECT * FROM cookie WHERE uuid = ?";

    public CookieRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new SimpleJdbcTemplate(dataSource);
    }

    public RowMapper<Cookie> cookieRowMapper = row -> new Cookie("cookie", row.getString("uuid"));

    @Override
    public void create(Cookie cookie) {
        template.queryInsert(SQL_CREATE, cookie.getValue());
    }

    @Override
    public boolean find(Cookie cookie) {
        List<Cookie> cookies = template.query(SQL_FIND, cookieRowMapper, cookie.getValue());
        return cookies != null;
    }
}
