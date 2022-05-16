package com.serasa.score.service;

import com.serasa.score.domain.entity.User;
import com.serasa.score.domain.response.AuthResponse;
import com.serasa.score.repository.UserRepository;
import com.serasa.score.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity authenticate() {
        try {
            Optional<User> userOptional = userRepository.findById(1L);
            if (!userOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário não encontrado");
            }

            return ResponseEntity.ok(new AuthResponse(tokenService.generateToken(1L)));
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

    }
}
