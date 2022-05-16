package com.serasa.score.domain.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "PessoaGetByIdResponse", description = "Modelo de resposta ao listar uma pessoa")
public class PessoaGetByIdResponse extends PessoaResponse {

    private String telefone;
    private Integer idade;

}
