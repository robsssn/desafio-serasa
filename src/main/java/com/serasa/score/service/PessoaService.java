package com.serasa.score.service;

import com.serasa.score.domain.entity.Pessoa;
import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.request.PessoaRequest;
import com.serasa.score.domain.response.PessoaGetAllResponse;
import com.serasa.score.domain.response.PessoaGetByIdResponse;
import com.serasa.score.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AfinidadeService afinidadeService;

    @Autowired
    private ScoreService scoreService;

    public ResponseEntity<List<PessoaGetAllResponse>> getPessoas() {

        try {
            List<Pessoa> pessoaList = pessoaRepository.findAll();

            if (pessoaList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            final List<PessoaGetAllResponse> pessoaResponseList = pessoaList.stream()
                    .map(p -> convertEntityToPessoaGetAllResponse(p))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(pessoaResponseList);

        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    public ResponseEntity<PessoaGetByIdResponse> getPessoaById(Long id) {

        try {
            Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

            if (!pessoaOptional.isPresent()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(convertEntityToPessoaGetByIdResponse(pessoaOptional.get()));

        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    public ResponseEntity cadastrarPessoa(PessoaRequest pessoaRequest) {
        try {
            pessoaRepository.save(convertRequestToEntity(pessoaRequest));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        }
    }

    private Pessoa convertRequestToEntity(PessoaRequest pessoaRequest) throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setCidade(pessoaRequest.getCidade());
        pessoa.setEstado(pessoaRequest.getEstado());
        pessoa.setIdade(pessoaRequest.getIdade());
        pessoa.setRegiao(Regiao.fromNomeRegiao(pessoaRequest.getRegiao()));
        pessoa.setTelefone(pessoaRequest.getTelefone());
        pessoa.setDataInclusao(LocalDate.now());
        pessoa.setScore(pessoaRequest.getScore());

        return pessoa;
    }

    private PessoaGetAllResponse convertEntityToPessoaGetAllResponse(Pessoa pessoa) {
        PessoaGetAllResponse pessoaGetAllResponse = new PessoaGetAllResponse();
        pessoaGetAllResponse.setNome(pessoa.getNome());
        pessoaGetAllResponse.setCidade(pessoa.getCidade());
        pessoaGetAllResponse.setEstado(pessoa.getEstado());
        pessoaGetAllResponse.setScoreDescricao(scoreService.getDescricaoScore(pessoa.getScore()));
        pessoaGetAllResponse.setEstados(afinidadeService.buscarEstadosAfinidadePorRegiao(pessoa.getRegiao()));

        return pessoaGetAllResponse;
    }

    private PessoaGetByIdResponse convertEntityToPessoaGetByIdResponse(Pessoa pessoa) {
        PessoaGetByIdResponse pessoaGetByIdResponse = new PessoaGetByIdResponse();
        pessoaGetByIdResponse.setNome(pessoa.getNome());
        pessoaGetByIdResponse.setTelefone(pessoa.getTelefone());
        pessoaGetByIdResponse.setIdade(pessoa.getIdade());
        pessoaGetByIdResponse.setScoreDescricao(scoreService.getDescricaoScore(pessoa.getScore()));
        pessoaGetByIdResponse.setEstados(afinidadeService.buscarEstadosAfinidadePorRegiao(pessoa.getRegiao()));

        return pessoaGetByIdResponse;
    }
}
