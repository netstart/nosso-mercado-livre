package com.github.nossomercadolivre.security;

public class AuthenticationTokenDtoOut {

    private String tokenType;
    private String token;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationTokenDtoOut(String tokenType, String token) {
        super();
        this.tokenType = tokenType;
        this.token = token;
    }
}
