package com.serasa.score.consts;

import lombok.Getter;

@Getter
public class ResponseCodesConsts {

    public final static int UNPROCESSABLE_ENTITY_CODE = 422;
    public final static String UNPROCESSABLE_ENTITY_MESSAGE = "Violação de regra de negócio";
}
