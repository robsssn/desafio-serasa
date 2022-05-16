package com.serasa.score.runner;

import com.serasa.score.domain.entity.User;
import com.serasa.score.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserSeeder implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    public void run(ApplicationArguments args) {
        try {
            User user = new User();
            user.setEmail("robson@experian.com.br");

            userRepository.save(user);

            log.info("Usuario padrao inserido para possibilitar a geração do token JWT");
        } catch (Exception e) {
            log.info("Não foi possivel inserir usuario padrao", e);
        }

    }
}
