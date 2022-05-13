package com.serasa.score.service;

import com.serasa.score.domain.entity.Afinidade;
import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.enums.UnidadeFederacao;
import com.serasa.score.domain.request.AfinidadeRequest;
import com.serasa.score.repository.AfinidadeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AfinidadeService {

    @Autowired
    private AfinidadeRepository afinidadeRepository;

    public ResponseEntity cadastrarAfinidade(AfinidadeRequest afinidadeRequest) {

        try {
            afinidadeRepository.save(convertAfinidadeRequestToEntity(afinidadeRequest));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        }
    }

    public Set<UnidadeFederacao> buscarEstadosAfinidadePorRegiao(Regiao regiao) {
        try {
            Optional<Afinidade> afinidadeOptional = afinidadeRepository.buscarAfinidadePorRegiao(regiao);

            if (!afinidadeOptional.isPresent())
                return Collections.emptySet();

            return afinidadeOptional.get().getEstados();
        } catch (Exception e) {
            log.info(e.getMessage());
            return Collections.emptySet();
        }
    }

    private Afinidade convertAfinidadeRequestToEntity(AfinidadeRequest afinidadeRequest) throws Exception {
        Afinidade afinidade = new Afinidade();
        afinidade.setRegiao(Regiao.fromNomeRegiao(afinidadeRequest.getRegiao()));
        afinidade.setEstados(afinidadeRequest.getEstados());
        return afinidade;
    }
}
