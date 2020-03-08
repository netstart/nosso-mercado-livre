package com.github.nossomercadolivre;

import javax.validation.constraints.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserDTO {
    private Long id;

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 5, max = 100)
    private String login;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 200)
    private String password;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public static UserDTO toDTO(User user) {
        return new UserDTO(user);
    }

    public static List<UserDTO> toDTO(List<User> users) {
        return users.stream()
                .map(UserDTO::new)
                .collect(toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
