package com.serasa.score.repository;

import com.serasa.score.domain.entity.Afinidade;
import com.serasa.score.domain.enums.Regiao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AfinidadeRepository extends CrudRepository<Afinidade, Long> {

    @Query(value = "FROM Afinidade WHERE regiao = ?1")
    Optional<Afinidade> buscarAfinidadePorRegiao(Regiao regiao);
}
