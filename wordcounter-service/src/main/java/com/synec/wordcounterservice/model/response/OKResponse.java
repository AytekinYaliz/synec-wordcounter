package com.synec.wordcounterservice.model.response;


import static org.springframework.http.HttpStatus.OK;

public class OKResponse<T> extends SynecResponse<T> {

    public OKResponse(T data) {
        super(data, null, OK);
    }

    public OKResponse() {
        super(null, null, OK);
    }
}
