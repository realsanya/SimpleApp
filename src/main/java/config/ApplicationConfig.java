package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:../resources/db.properties")
@ComponentScan(basePackages = "java")
public class ApplicationConfig {

    private final Environment environment;

    public ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

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
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
        hikariConfig.setDriverClassName(environment.getProperty("db.driver"));
        hikariConfig.setPassword(environment.getProperty("db.password"));
        hikariConfig.setUsername(environment.getProperty("db.username"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool")));
        return hikariConfig;
    }
}
