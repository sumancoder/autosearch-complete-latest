package com.autosearch.complete.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {

    private final String status;
    private final String statusCode;
    private final String message;

}
