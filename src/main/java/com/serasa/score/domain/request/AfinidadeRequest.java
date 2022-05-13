package com.serasa.score.domain.request;

import com.serasa.score.domain.enums.UnidadeFederacao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@ApiModel(value = "AfinidadeRequest", description = "Modelo de objeto para cadastrar uma afinidade")
public class AfinidadeRequest {

    @NotBlank(message = "regiao é um campo obrigatorio")
    @ApiModelProperty(value = "Regiao da afinidade", required = true)
    private String regiao;

    @NotEmpty(message = "Estados é um campo obrigatorio")
    @ApiModelProperty(value = "Lista de estados da afinidade", required = true)
    private Set<UnidadeFederacao> estados;

}
