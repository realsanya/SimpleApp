package servlets;

import models.User;
import services.interfaces.UserService;
import utils.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        System.out.println(userService);
        String inputFirstName = req.getParameter("inputFirstName");
        String inputLastName = req.getParameter("inputLastName");
        String inputAge = req.getParameter("inputAge");
        String inputEmail = req.getParameter("inputEmail");
        String inputPassword = req.getParameter("inputPassword");

        String hash = HashPassword.getHash(inputPassword);

//        if (usersService.getUserByEmail(inputEmail).isPresent()) {
//            resp.sendRedirect("/login");
//        } else {
        User user = User.builder()
                .firstName(inputFirstName)
                .lastName(inputLastName)
                .age(inputAge)
                .email(inputEmail)
                .password(hash).build();

        System.out.println(user.getFirstName());
        userService.addUser(user);


        resp.sendRedirect("/main");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.ftl").forward(request, response);
    }
}