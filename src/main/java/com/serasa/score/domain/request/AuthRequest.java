package com.serasa.score.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(value = "AuthRequest", description = "Modelo de objeto de autenticação")
public class AuthRequest {

    @ApiModelProperty(value = "email para autenticação", required = true)
    @NotBlank
    private String email;
}
