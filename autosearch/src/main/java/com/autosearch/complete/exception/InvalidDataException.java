package com.autosearch.complete.exception;

import com.autosearch.complete.constants.ErrorResponseConstants;

public class InvalidDataException extends BaseException{
    public InvalidDataException(ErrorResponseConstants errorResponseConstants){
        super(errorResponseConstants.getStatus(),errorResponseConstants.getErrorCode(),errorResponseConstants.getMessage());
    }
}
