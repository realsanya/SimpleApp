package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.AuthRepositoryJdbcTemplateImpl;
import repositories.UserRepositoryJdbcTemplateImpl;
import repositories.interfaces.AuthRepository;
import repositories.interfaces.UserRepository;
import services.AuthServiceImpl;
import services.UserServiceImpl;
import services.interfaces.AuthService;
import services.interfaces.UserService;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Autowired
    private HikariConfig hikariConfig;

    @Bean
    public AuthService authService() {
        return new AuthServiceImpl(authRepository());
    }

    @Bean
    public AuthRepository authRepository() {
        return new AuthRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
