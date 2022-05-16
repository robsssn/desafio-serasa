package com.serasa.score.domain.request;

import com.serasa.score.domain.enums.UnidadeFederacao;
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
@ApiModel(value = "PessoaRequest", description = "Modelo de objeto para cadastrar uma pessoa")
public class PessoaRequest {

    @NotBlank(message = "nome é um campo obrigatorio")
    @ApiModelProperty(value = "Nome da pessoa", required = true)
    private String nome;

    @NotBlank(message = "telefone é um campo obrigatorio")
    @ApiModelProperty(value = "Telefone da pessoa", required = true)
    private String telefone;

    @NotNull(message = "idade é um campo obrigatorio")
    @ApiModelProperty(value = "Idade da pessoa", required = true)
    private Integer idade;

    @NotBlank(message = "cidade é um campo obrigatorio")
    @ApiModelProperty(value = "Cidade da pessoa", required = true)
    private String cidade;

    @ApiModelProperty(value = "Unidade Federativa de residencia da pessoa", required = true)
    @NotNull(message = "estado é um campo obrigatorio")
    private UnidadeFederacao estado;

    @ApiModelProperty(value = "Região geográfica da pessoa", required = true)
    @NotBlank(message = "regiao é um campo obrigatorio")
    private String regiao;

    @ApiModelProperty(value = "Valor do score da pessoa", required = true)
    @NotNull(message = "score é um campo obrigatorio")
    @Max(value = 1000, message = "valor maximo 1000")
    @Min(value = 0, message = "valor minimo 0")
    private Integer score;

}
