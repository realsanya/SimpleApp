package servlets;

import models.User;
import services.interfaces.AuthService;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean find = true;

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        String email = request.getParameter("email");
        request.getSession().setAttribute("user", userService.getUserByEmail(email));

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie")) {
                    find = false;
                }
            }
        }

        if (find) {
            AuthService authService = (AuthService) request.getServletContext().getAttribute("authService");
            Cookie cookie = new Cookie("cookie", UUID.randomUUID().toString());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            authService.addCookie(cookie);
            response.addCookie(cookie);
        } else {
            response.sendRedirect("/profile");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.ftl").forward(request, response);
    }
}