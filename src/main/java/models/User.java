package models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String password;
}
