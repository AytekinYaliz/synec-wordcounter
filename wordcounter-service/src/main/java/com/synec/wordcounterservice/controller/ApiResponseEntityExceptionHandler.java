package com.synec.wordcounterservice.controller;


import com.synec.wordcounterlib.exception.InvalidWordException;
import com.synec.wordcounterlib.exception.NotARealWordException;
import com.synec.wordcounterservice.model.response.BadRequestResponse;
import com.synec.wordcounterservice.model.response.InternalServerErrorResponse;
import com.synec.wordcounterservice.model.response.NotFoundResponse;
import com.synec.wordcounterservice.model.response.SynecResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public SynecResponse handleServerException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new InternalServerErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(InvalidWordException.class)
    public SynecResponse handleInvalidWordException(InvalidWordException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new BadRequestResponse(ex.getMessage());
    }

    @ExceptionHandler(NotARealWordException.class)
    public SynecResponse handleNotARealWordException(NotARealWordException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new NotFoundResponse(ex.getMessage());
    }

}
