package com.github.nossomercadolivre;

import com.github.nossomercadolivre.validation.UniqueUserEmail;

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
    @UniqueUserEmail
    public String email;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 200)
    public String password;



    /**
     * For frameworks, don't use it
     */
    @Deprecated
    private UserDTO() {
    }

    public UserDTO(final User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static UserDTO toDTO(final User user) {
        return new UserDTO(user);
    }

    public User toModel() {
        return new User(this.email, this.password);
    }


}
