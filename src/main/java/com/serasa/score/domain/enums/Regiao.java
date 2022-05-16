package com.serasa.score.domain.enums;

import lombok.Getter;

@Getter
public enum Regiao {
    NORTE("norte"),
    NORDESTE("nordeste"),
    SUL("sul"),
    SUDESTE("sudeste"),
    CENTRO_OESTE("centro oeste");

    private String nomeRegiao;

    Regiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public static Regiao fromNomeRegiao(String nomeRegiao) throws Exception {
        for (Regiao r : Regiao.values()) {
            if (r.nomeRegiao.equalsIgnoreCase(nomeRegiao)) {
                return r;
            }
        }
        throw new Exception("Nome da região inválida " + nomeRegiao);
    }
}
