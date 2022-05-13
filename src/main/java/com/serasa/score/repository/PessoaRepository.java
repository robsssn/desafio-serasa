package com.serasa.score.repository;

import com.serasa.score.domain.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    @Override
    List<Pessoa> findAll();
}
