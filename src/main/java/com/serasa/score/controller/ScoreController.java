package com.serasa.score.controller;

import com.serasa.score.consts.ResponseCodesConsts;
import com.serasa.score.domain.request.ScoreRequest;
import com.serasa.score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api("Score Controller")
public class ScoreController {

    private static final String API_VERSION = "/v1";
    private static final String API_ENDPOINT = API_VERSION + "/scores";

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "Cadastra Score", consumes = APPLICATION_JSON_VALUE)
    @ApiResponse(code = ResponseCodesConsts.UNPROCESSABLE_ENTITY_CODE, message = ResponseCodesConsts.UNPROCESSABLE_ENTITY_MESSAGE)
    @PostMapping(value = API_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity postScore(@RequestBody ScoreRequest scoreRequest) {

        return scoreService.createScore(scoreRequest);
    }
}
