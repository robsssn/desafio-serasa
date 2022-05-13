package com.serasa.score.controller;

import com.serasa.score.consts.ResponseCodesConsts;
import com.serasa.score.domain.request.AuthRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Api("Auth Controller")
public class AuthController {

    @ApiOperation(value = "Autenticar usuario", consumes = APPLICATION_JSON_VALUE)
    @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE)
    @PostMapping(value = "/auth", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity authenticate(@RequestBody AuthRequest authRequest) {

        return ok().body("token"
        );
    }
}
