package com.serasa.score.service;

import com.serasa.score.domain.entity.Score;
import com.serasa.score.domain.request.ScoreRequest;
import com.serasa.score.repository.ScoreRepository;
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
public class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;
    @Mock
    private ScoreRepository scoreRepository;

    private ScoreRequest scoreRequest;
    private Score score;

    @BeforeEach
    public void setup() {
        scoreRequest = new ScoreRequest();
        scoreRequest.setScoreDescricao("Insuficiente");
        scoreRequest.setValorInicial(0);
        scoreRequest.setValorFinal(200);

        score = new Score();
        score.setDescricao("Insuficiente");
        score.setValorInicial(0);
        score.setValorFinal(200);
    }

    @Test
    public void cadastrarScoreCreatedTest() {
        ResponseEntity response = scoreService.createScore(scoreRequest);
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

    @Test
    public void cadastrarScoreUnprocessableEntityTest() {
        Mockito.when(scoreRepository.save(Mockito.any(Score.class))).thenThrow(NullPointerException.class);
        ResponseEntity response = scoreService.createScore(scoreRequest);
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }

    @Test
    public void getDescricaoScoreTest() {
        Mockito.when(scoreRepository.buscarScoreEntreValorInicialEFinal(Mockito.anyInt()))
                .thenReturn(Optional.of(score));

        String descricao = scoreService.getDescricaoScore(120);
        Assertions.assertEquals(score.getDescricao(), descricao);
    }

    @Test
    public void getDescricaoScoreEmptyTest() {
        Mockito.when(scoreRepository.buscarScoreEntreValorInicialEFinal(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        String descricao = scoreService.getDescricaoScore(120);
        Assertions.assertEquals("", descricao);
    }

    @Test
    public void getDescricaoScoreExceptionTest() {

        Mockito.when(scoreRepository.buscarScoreEntreValorInicialEFinal(Mockito.anyInt()))
                .thenThrow(NullPointerException.class);

        String descricao = scoreService.getDescricaoScore(120);
        Assertions.assertEquals("", descricao);
    }

}
