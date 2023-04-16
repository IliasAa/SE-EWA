package com.example.ewaserver.service;

import lombok.Getter;

public class Login {
    @Getter
    private final Token accesToken;
    @Getter
    private final Token refreshToken;

    private static final Long ACCESS_TOKEN_VALIDITY = 1L;
    private static final Long REFRESH_TOKEN_VALIDITY = 1440L;

    public Login(Token accesToken, Token refreshToken) {
        this.accesToken = accesToken;
        this.refreshToken = refreshToken;
    }

    public static Login of(int userId, String accesSecret, String refreshSecret ) {
        return new Login(
                Token.of(userId, ACCESS_TOKEN_VALIDITY, accesSecret),
                Token.of(userId, REFRESH_TOKEN_VALIDITY, refreshSecret)
        );
    }

    public static Login of(int userId, String accesSecret, Token refreshToken) {
        return new Login(
                Token.of(userId, ACCESS_TOKEN_VALIDITY, accesSecret),
                refreshToken
        );
    }
}
