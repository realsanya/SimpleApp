package services;

import repositories.interfaces.CookieRepository;
import services.interfaces.CookieService;

import javax.servlet.http.Cookie;

public class CookieServiceImpl implements CookieService {

    private CookieRepository cookieRepository;

    public CookieServiceImpl(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @Override
    public void addCookie(Cookie cookie) {
        cookieRepository.create(cookie);
    }

    @Override
    public boolean findCookie(Cookie cookie) {
        return cookieRepository.find(cookie);
    }
}
