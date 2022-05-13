package com.serasa.score.service;

import com.serasa.score.domain.entity.Pessoa;
import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.enums.UnidadeFederacao;
import com.serasa.score.domain.request.PessoaRequest;
import com.serasa.score.domain.response.PessoaResponse;
import com.serasa.score.repository.PessoaRepository;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;
    @Mock
    private ScoreService scoreService;
    @Mock
    private AfinidadeService afinidadeService;
    @Mock
    private PessoaRepository pessoaRepository;

    private Logger log;
    private Pessoa pessoa;
    private PessoaRequest pessoaRequest;
    private List<Pessoa> pessoaList;

    @BeforeEach
    public void setup() {
        log = Logger.getLogger(getClass().getName());
        pessoaRequest = new PessoaRequest();
        pessoaRequest.setEstado(UnidadeFederacao.AC);
        pessoaRequest.setCidade("Brasilia");
        pessoaRequest.setIdade(25);
        pessoaRequest.setNome("Robson Santos");
        pessoaRequest.setTelefone("61 98474-2620");
        pessoaRequest.setScore(780);
        pessoaRequest.setRegiao("sudeste");

        pessoaList = new ArrayList<>();
        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setScore(780);
        pessoa.setCidade("Brasilia");
        pessoa.setNome("Robson");
        pessoa.setRegiao(Regiao.NORTE);
        pessoa.setEstado(UnidadeFederacao.AC);
        pessoa.setIdade(25);
        pessoa.setTelefone("61984742620");
        pessoaList.add(pessoa);
    }

    @Test
    public void cadastrarPessoaStatusCreatedTest() {
        ResponseEntity<PessoaResponse> response = pessoaService.cadastrarPessoa(pessoaRequest);
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

    @Test
    public void cadastrarPessoaUnprocessableEntityTest() {
        pessoaRequest.setRegiao(null);
        ResponseEntity<PessoaResponse> response = pessoaService.cadastrarPessoa(pessoaRequest);
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoasOkTest() {
        Mockito.when(pessoaRepository.findAll()).thenReturn(pessoaList);
        ResponseEntity<List<PessoaResponse>> response = pessoaService.getPessoas();
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoasNoContentTest() {
        Mockito.when(pessoaRepository.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<PessoaResponse>> response = pessoaService.getPessoas();
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoasUnprocessableEntityTest() {
        Mockito.when(pessoaRepository.findAll()).thenThrow(NullPointerException.class);
        ResponseEntity<List<PessoaResponse>> response = pessoaService.getPessoas();
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoaPorIdOkTest() {
        Mockito.when(pessoaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pessoa));
        ResponseEntity<PessoaResponse> response = pessoaService.getPessoaById(1L);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoaPorIdNoContentTest() {
        Mockito.when(pessoaRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        ResponseEntity<PessoaResponse> response = pessoaService.getPessoaById(1L);
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCodeValue());
    }

    @Test
    public void listarPessoaPorIdUnprocessableEntityTest() {
        Mockito.when(pessoaRepository.findById(Mockito.anyLong())).thenThrow(NullPointerException.class);
        ResponseEntity<PessoaResponse> response = pessoaService.getPessoaById(1L);
        Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), response.getStatusCodeValue());
    }

}
