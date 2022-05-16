package com.serasa.score.domain.response;

import com.serasa.score.domain.enums.UnidadeFederacao;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "PessoaGetAllResponse", description = "Modelo de resposta ao listar pessoa")
public class PessoaGetAllResponse extends PessoaResponse {

    private String cidade;
    private UnidadeFederacao estado;
}
