package com.serasa.score.controller;

import com.serasa.score.consts.ResponseCodesConsts;
import com.serasa.score.domain.request.PessoaRequest;
import com.serasa.score.domain.response.PessoaResponse;
import com.serasa.score.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(tags = "Pessoa Controller")
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation(value = "Lista todas pessoas cadastradas")
    @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE)
    @GetMapping
    public ResponseEntity getPessoas() {
        return pessoaService.getPessoas();
    }

    @ApiOperation(value = "Lista uma pessoa por id")
    @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE)
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> getPessoa(@PathVariable Long id) {
        return pessoaService.getPessoaById(id);
    }

    @ApiOperation(value = "Cadastra pessoa", consumes = APPLICATION_JSON_VALUE)
    @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity createPessoa(@RequestBody @Valid PessoaRequest pessoaRequest) {

        return pessoaService.cadastrarPessoa(pessoaRequest);
    }
}
