package com.example.ewaserver.service;

import lombok.Getter;

public class Login {
    @Getter
    private final Token accesToken;
    @Getter
    private final Token refreshToken;

    public Login(Token accesToken, Token refreshToken) {
        this.accesToken = accesToken;
        this.refreshToken = refreshToken;
    }

    public static Login of(int userId, String accesSecret, String refreshSecret ) {
        return new Login(
                Token.of(userId, 1L, accesSecret),
                Token.of(userId, 1440L, refreshSecret)
        );
    }
}
