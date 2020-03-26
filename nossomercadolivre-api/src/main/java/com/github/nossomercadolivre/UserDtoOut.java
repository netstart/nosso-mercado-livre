package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class UserDtoOut {

    public String email;

    public UserDtoOut(final User user) {
        this.email = user.getEmail();
    }
}
