package com.jo.common.exception.controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import com.jo.common.exception.BackEndException;
import com.jo.common.exception.BackEndListException;
import com.jo.common.exception.InternalErrorException;
import com.jo.common.response.RestResponseHeader;

@RestControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(value = BackEndException.class)
    public ResponseEntity<RestResponseHeader> backEndException(BackEndException backEndException) {
        return response(backEndException); 
    }

    @ExceptionHandler(value = BackEndListException.class)
    public ResponseEntity<RestResponseHeader> backEndListException(BackEndListException backEndListException) {
        return response(backEndListException); 
    }

    @ExceptionHandler(value = { SQLException.class, SQLGrammarException.class, HttpServerErrorException.class })
    public ResponseEntity<RestResponseHeader> sqlException(Exception exception) {
        exception.printStackTrace();
        return response(new InternalErrorException()); 
    }

    private ResponseEntity<RestResponseHeader> response(BackEndException backEndException) {
        var error = backEndException.getError();
        // TODO traza
        var restResponseHeader = new RestResponseHeader(null, List.of(error));
        return new ResponseEntity<RestResponseHeader>(restResponseHeader, error.httpStatus());
    }

    private ResponseEntity<RestResponseHeader> response(BackEndListException backEndListException) {
        // TODO traza
        var restResponseHeader = new RestResponseHeader(null, backEndListException.getErrors());
        return new ResponseEntity<RestResponseHeader>(restResponseHeader, backEndListException.getHttpStatus());
    }
}


