package services.interfaces;

import javax.servlet.http.Cookie;

public interface AuthService {
    void addCookie(Cookie cookie);

    boolean findCookie(Cookie cookie);
}
