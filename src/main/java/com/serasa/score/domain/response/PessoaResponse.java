package com.serasa.score.domain.response;

import com.serasa.score.domain.enums.UnidadeFederacao;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Set;

@Getter
@Setter
@ApiIgnore
public class PessoaResponse {

    private String nome;
    private String scoreDescricao;
    private Set<UnidadeFederacao> estados;

}
