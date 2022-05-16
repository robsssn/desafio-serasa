package com.serasa.score.controller;

import com.serasa.score.consts.ResponseCodesConsts;
import com.serasa.score.domain.response.AuthResponse;
import com.serasa.score.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(tags = "Auth Controller")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "Autentica e gera o token JWT (um usuário padrão é inserido na inicialização da aplicação)", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = ResponseCodesConsts.OK_CODE, message = ResponseCodesConsts.OK_MESSAGE, response = AuthResponse.class),
            @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE),
            @ApiResponse(code = ResponseCodesConsts.NO_CONTENT_CODE, message = ResponseCodesConsts.NO_CONTENT_MESSAGE)
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> authenticate() {
        return authService.authenticate();
    }
}
