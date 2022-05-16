package com.serasa.score.domain.enums;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
public enum UnidadeFederacao {
    AM, AL, AC, AP,
    BA, PR, PA, MT,
    MG, MS, SE, DF,
    GO, MA, RS, TO,
    PI, SP, RO, RR,
    CE, PE, SC, PB,
    RN, ES, RJ;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
