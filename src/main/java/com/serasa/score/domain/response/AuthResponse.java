package com.serasa.score.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@ApiModel(value = "PessoaResponse", description = "Modelo de resposta ao auutenticar com sucesso")
public class AuthResponse {

    @ApiModelProperty(value = "Token utilado nas requisições de rotas protegidas", required = true)
    private String token;
}

