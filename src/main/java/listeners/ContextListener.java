package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.AuthRepositoryJdbcTemplateImpl;
import repositories.UserRepositoryJdbcTemplateImpl;
import repositories.interfaces.AuthRepository;
import repositories.interfaces.UserRepository;
import services.AuthServiceImpl;
import services.UserServiceImpl;
import services.interfaces.AuthService;
import services.interfaces.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Properties properties = new Properties();
        try {
            properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);

        UserRepository userRepository = new UserRepositoryJdbcTemplateImpl(dataSource);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

        AuthRepository authRepository = new AuthRepositoryJdbcTemplateImpl(dataSource);
        AuthService authService = new AuthServiceImpl(authRepository);
        servletContextEvent.getServletContext().setAttribute("authService", authService);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        servletContextEvent.getServletContext().setAttribute("passwordEncoder", passwordEncoder);
    }
}
