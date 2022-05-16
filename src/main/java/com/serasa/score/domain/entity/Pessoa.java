package com.serasa.score.domain.entity;

import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.enums.UnidadeFederacao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInclusao;
    private String nome;
    private String telefone;
    private Integer score;
    private Integer idade;
    private String cidade;
    @Enumerated
    private UnidadeFederacao estado;
    @Enumerated
    private Regiao regiao;

}
