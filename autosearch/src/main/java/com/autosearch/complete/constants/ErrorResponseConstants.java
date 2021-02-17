package com.autosearch.complete.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorResponseConstants {

    INVALID_DATA_EXCEPTION("failed","invalid_data_Error","please search with valid input");

    private String status;
    private String errorCode;
    private String message;

}
