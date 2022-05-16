package com.serasa.score.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel(value = "ScoreRequest", description = "Modelo de objeto para cadastrar um score")
public class ScoreRequest {

    @ApiModelProperty(value = "Descrição do score", required = true)
    @NotBlank
    private String scoreDescricao;

    @ApiModelProperty(value = "Valor inicial do score", required = true)
    @Min(value = 0)
    @NotNull
    private Integer valorInicial;

    @ApiModelProperty(value = "Valor final do score", required = true)
    @Max(value = 1000)
    @NotNull
    private Integer valorFinal;

}
