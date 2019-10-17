package com.trainning.api;

import jp.xet.sparwings.spring.web.httpexceptions.HttpBadRequestException;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Catch all exception
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * Handler for {@link HttpNotFoundException}
     * @param ex HttpNotFoundException
     */
    @ExceptionHandler({HttpNotFoundException.class})
    public ResponseEntity notFoundException(HttpNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handler for {@link HttpBadRequestException}
     * @param ex HttpBadRequestException
     */
    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity badRequesException(HttpBadRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
