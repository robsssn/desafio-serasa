package com.serasa.score.service;

import com.serasa.score.domain.entity.Afinidade;
import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.enums.UnidadeFederacao;
import com.serasa.score.domain.request.AfinidadeRequest;
import com.serasa.score.repository.AfinidadeRepository;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class AfinidadeServiceTest {

    @InjectMocks
    private AfinidadeService afinidadeService;
    @Mock
    private AfinidadeRepository afinidadeRepository;

    private AfinidadeRequest afinidadeRequest;
    private Afinidade afinidade;
    private Set<UnidadeFederacao> estados;

    @BeforeEach
    void setup() {
        estados = new HashSet<>();
        estados.add(UnidadeFederacao.SP);
        estados.add(UnidadeFederacao.RJ);
        estados.add(UnidadeFederacao.MG);
        estados.add(UnidadeFederacao.ES);

        afinidadeRequest = new AfinidadeRequest();
        afinidadeRequest.setRegiao("sudeste");
        afinidadeRequest.setEstados(estados);

        afinidade = new Afinidade();
        afinidade.setId(1L);
        afinidade.setEstados(estados);
    }

    @Test
    void cadastrarAfinidadeCreatedTest() {
        ResponseEntity response = afinidadeService.cadastrarAfinidade(afinidadeRequest);
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

    @Test
    void cadastrarAfinidadeUnprocessableEntityTest() {
        Mockito.when(afinidadeRepository.save(Mockito.any(Afinidade.class))).thenThrow(NullPointerException.class);
        ResponseEntity response = afinidadeService.cadastrarAfinidade(afinidadeRequest);
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }

    @Test
    void buscarEstadosAfinidadePorRegiaoTest() {
        Mockito.when(afinidadeRepository.buscarAfinidadePorRegiao(Mockito.any(Regiao.class))).thenReturn(Optional.of(afinidade));
        Set<UnidadeFederacao> estadosSet = afinidadeService.buscarEstadosAfinidadePorRegiao(Regiao.SUL);
        Assertions.assertEquals(estados, estadosSet);
    }

    @Test
    void buscarEstadosAfinidadePorRegiaoEmptyTest() {
        Mockito.when(afinidadeRepository.buscarAfinidadePorRegiao(Mockito.any(Regiao.class))).thenReturn(Optional.empty());
        Set<UnidadeFederacao> estadosSet = afinidadeService.buscarEstadosAfinidadePorRegiao(Regiao.SUL);
        Assertions.assertTrue(estadosSet.isEmpty());
    }

    @Test
    void buscarEstadosAfinidadePorRegiaoExcpetionTest() {
        Mockito.when(afinidadeRepository.buscarAfinidadePorRegiao(Mockito.any(Regiao.class))).thenThrow(NullPointerException.class);
        Set<UnidadeFederacao> estadosSet = afinidadeService.buscarEstadosAfinidadePorRegiao(Regiao.SUL);
        Assertions.assertTrue(estadosSet.isEmpty());
    }

}
