package com.serasa.score.domain.response;

import com.serasa.score.domain.enums.UnidadeFederacao;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@ApiModel(value = "PessoaResponse", description = "Modelo de resposta ao listar pessoa")
public class PessoaResponse {

    private String nome;
    private String telefone;
    private Integer idade;
    private String scoreDescricao;
    private String cidade;
    private UnidadeFederacao estado;
    private Set<UnidadeFederacao> estados;

}
