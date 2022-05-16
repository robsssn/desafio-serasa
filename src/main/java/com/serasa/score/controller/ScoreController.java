package com.serasa.score.controller;

import com.serasa.score.consts.ResponseCodesConsts;
import com.serasa.score.domain.request.ScoreRequest;
import com.serasa.score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(tags = "Score Controller")
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "Cadastra Score", consumes = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = ResponseCodesConsts.CREATED_CODE, message = ResponseCodesConsts.CREATED_MESSAGE),
            @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE),
            @ApiResponse(code = ResponseCodesConsts.FORBIDDEN_CODE, message = ResponseCodesConsts.FORBIDDEN_MESSAGE)
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity postScore(@RequestBody @Valid ScoreRequest scoreRequest) {
        return scoreService.createScore(scoreRequest);
    }
}
