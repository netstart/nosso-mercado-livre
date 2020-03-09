package com.github.nossomercadolivre;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
    private Long id;

    @NotNull
    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 200)
    private String password;

    @Deprecated
    /**
     * For frameworks, don't use it
     */
    protected UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
