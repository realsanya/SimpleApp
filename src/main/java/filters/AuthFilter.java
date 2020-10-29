package filters;


import services.interfaces.AuthService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/profile")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        AuthService authService = (AuthService) request.getServletContext().getAttribute("authService");
//        Cookie[] cookies = request.getCookies();
//        boolean find = false;

        boolean user = request.getSession().getAttribute("user") != null;
        if (user) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        response.sendRedirect("/login");
    }

//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("cookie")) {
//                    find = authService.findCookie(cookie);
//                    break;
//                }
//            }
//        }
//
//        if (find) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            response.sendRedirect("/login");
//        }
}
