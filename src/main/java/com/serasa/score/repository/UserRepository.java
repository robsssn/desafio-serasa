package com.serasa.score.repository;

import com.serasa.score.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("FROM Score WHERE :scoreValue >= valorInicial AND :scoreValue <= valorFinal")
    Optional<User> buscarScoreEntreValorInicialEFinal(Integer scoreValue);

}
