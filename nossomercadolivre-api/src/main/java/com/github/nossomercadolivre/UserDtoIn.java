package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.nossomercadolivre.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class UserDtoIn {

    @NotBlank
    @Email
    @Size(max = 100)
    @UniqueUserEmail
    public String email;

    @NotBlank
    @Size(min = 6, max = 200)
    public String password;


    /**
     * For frameworks, don't use it
     */
    @Deprecated
    private UserDtoIn() {
    }

    public User toModel() {
        return new User(this.email, this.password);
    }


}
