package com.serasa.score.domain.entity;

import com.serasa.score.domain.enums.Regiao;
import com.serasa.score.domain.enums.UnidadeFederacao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Afinidades")
public class Afinidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Regiao regiao;

    @ElementCollection(targetClass = UnidadeFederacao.class)
    private Set<UnidadeFederacao> estados = new HashSet<>();
}
