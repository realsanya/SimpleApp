package services;

import repositories.interfaces.AuthRepository;
import services.interfaces.AuthService;

import javax.servlet.http.Cookie;

public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void addCookie(Cookie cookie) {
        authRepository.create(cookie);
    }

    @Override
    public boolean findCookie(Cookie cookie) {
        return authRepository.find(cookie);
    }
}
