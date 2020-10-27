package services.interfaces;

import javax.servlet.http.Cookie;

public interface CookieService {
    void addCookie(Cookie cookie);

    boolean findCookie(Cookie cookie);
}
