package repositories.interfaces;


import javax.servlet.http.Cookie;

public interface AuthRepository {
    void create(Cookie cookie);

    boolean find(Cookie cookie);
}
