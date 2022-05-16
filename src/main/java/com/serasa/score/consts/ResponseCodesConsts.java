package com.serasa.score.consts;

import lombok.Getter;

@Getter
public class ResponseCodesConsts {

    public final static int OK_CODE = 200;
    public final static String OK_MESSAGE = "Ok";

    public final static int CREATED_CODE = 201;
    public final static String CREATED_MESSAGE = "Created";

    public final static int NO_CONTENT_CODE = 204;
    public final static String NO_CONTENT_MESSAGE = "No content";

    public final static int FORBIDDEN_CODE = 403;
    public final static String FORBIDDEN_MESSAGE = "Necessário autenticação";

    public final static int UNPROCESSABLE_ENTITY_CODE = 422;
    public final static String UNPROCESSABLE_ENTITY_MESSAGE = "Violação de regra de negócio";

}
