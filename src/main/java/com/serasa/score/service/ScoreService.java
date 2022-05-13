package com.serasa.score.service;

import com.serasa.score.domain.entity.Score;
import com.serasa.score.domain.request.ScoreRequest;
import com.serasa.score.repository.ScoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public ResponseEntity createScore(ScoreRequest scoreRequest) {
        try {
            scoreRepository.save(convertScoreRequestToEntity(scoreRequest));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

    }

    public String getDescricaoScore(Integer score) {
        try {
            Optional<Score> scoreOptional = scoreRepository.buscarScoreEntreValorInicialEFinal(score);

            if (scoreOptional.isPresent())
                return scoreOptional.get().getDescricao();

            return "";
        } catch (Exception e) {
            log.info(e.getMessage());
            return "";
        }
    }

    private Score convertScoreRequestToEntity(ScoreRequest scoreRequest) {
        Score score = new Score();
        score.setDescricao(scoreRequest.getScoreDescricao());
        score.setValorInicial(scoreRequest.getValorInicial());
        score.setValorFinal(scoreRequest.getValorFinal());
        return score;
    }
}
