package com.serasa.score.service;

import com.serasa.score.domain.entity.User;
import com.serasa.score.domain.response.AuthResponse;
import com.serasa.score.repository.UserRepository;
import com.serasa.score.security.service.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    private User user;
    private String token;

    @BeforeEach
    void setup() {
        token = "token-jwt-123";

        user = new User();
        user.setId(1L);
        user.setEmail("robson@experian.com.br");
    }

    @Test
    void authenticateOkTest() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(user));
        Mockito.when(tokenService.generateToken(Mockito.anyLong())).thenReturn(token);
        ResponseEntity<AuthResponse> response = authService.authenticate();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        Assertions.assertNotNull(response.getBody().getToken());
    }

    @Test
    void authenticateNoContentTest() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        ResponseEntity<AuthResponse> response = authService.authenticate();
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCodeValue());
    }

    @Test
    void authenticateUnprocessableEntityTest() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenThrow(NullPointerException.class);
        ResponseEntity<AuthResponse> response = authService.authenticate();
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }


}
