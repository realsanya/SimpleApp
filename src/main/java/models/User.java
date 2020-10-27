package models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class User {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
}
