package com.autosearch.complete.exception.handler;

import com.autosearch.complete.exception.InvalidDataException;
import com.autosearch.complete.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * Exception Handler class
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException invalidDataException){
        ErrorResponse errorResponse = new ErrorResponse(invalidDataException.getStatus(),invalidDataException.getStatusCode(),invalidDataException.getMessage());
        log.error("Logging InvalidDataException ..");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
