package com.javi.common.exception.controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import com.javi.common.exception.BackEndException;
import com.javi.common.exception.BackEndListException;
import com.javi.common.exception.InternalErrorException;
import com.javi.common.response.RestResponseError;

@RestControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(value = BackEndException.class)
    public ResponseEntity<RestResponseError> backEndException(BackEndException backEndException) {
        return response(backEndException); 
    }

    @ExceptionHandler(value = BackEndListException.class)
    public ResponseEntity<RestResponseError> backEndListException(BackEndListException backEndListException) {
        return response(backEndListException); 
    }

    @ExceptionHandler(value = { SQLException.class, SQLGrammarException.class, HttpServerErrorException.class })
    public ResponseEntity<RestResponseError> sqlException(Exception exception) {
        exception.printStackTrace();
        return response(new InternalErrorException()); 
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponseError> validationException(MethodArgumentNotValidException ex) {
        List<RestResponseError.Error> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .map(err -> new RestResponseError.Error(HttpStatus.BAD_REQUEST, "BAD_REQUEST", err))
                .toList();
        
        var restResponseError = new RestResponseError(errors);
        return new ResponseEntity<RestResponseError>(restResponseError, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<RestResponseError> response(BackEndException backEndException) {
        var error = backEndException.getError();
        var restResponseError = new RestResponseError(List.of(error));
        return new ResponseEntity<RestResponseError>(restResponseError, error.httpStatus());
    }

    private ResponseEntity<RestResponseError> response(BackEndListException backEndListException) {
        var restResponseError = new RestResponseError(backEndListException.getErrors());
        return new ResponseEntity<RestResponseError>(restResponseError, backEndListException.getHttpStatus());
    }
}


