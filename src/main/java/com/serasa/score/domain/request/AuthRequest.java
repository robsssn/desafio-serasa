package com.serasa.score.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "AuthRequest", description = "Modelo de objeto de autenticação")
public class AuthRequest {

    @ApiModelProperty(value = "id do usuário pré cadastrado autenticação", required = true)
    @NotNull(message = "id do usuario é obrigatorio")
    private Long id;
}
