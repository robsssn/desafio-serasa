package com.serasa.score.service;

import com.serasa.score.security.service.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    private String invalidToken;

    @BeforeEach
    void setup() {
        invalidToken = "ciOiJIUzI1N.ciOiJIUzI1N.ciOiJIUzI1N";
    }

    @Test
    void isNotTokenValidTest() {
        Assertions.assertFalse(tokenService.isTokenValid(invalidToken));
    }

}
