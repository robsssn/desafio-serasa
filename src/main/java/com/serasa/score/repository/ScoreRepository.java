package com.serasa.score.repository;

import com.serasa.score.domain.entity.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScoreRepository extends CrudRepository<Score, Long> {

    @Query("FROM Score WHERE valorInicial >=:scoreValue AND valorFinal <=:scoreValue")
    Optional<Score> buscarScoreEntreValorInicialEFinal(Integer scoreValue);

}
