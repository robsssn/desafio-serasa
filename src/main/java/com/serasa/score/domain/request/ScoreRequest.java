package com.serasa.score.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(value = "ScoreRequest", description = "Modelo de objeto para cadastrar um score")
public class ScoreRequest {

    @ApiModelProperty(value = "Descrição do score", required = true)
    @NotBlank
    private String scoreDescricao;

    @ApiModelProperty(value = "Valor inical do score", required = true)
    @Min(value = 0)
    private Integer valorInicial;

    @ApiModelProperty(value = "Valor final do score", required = true)
    @Min(value = 1000)
    private Integer valorFinal;

}
