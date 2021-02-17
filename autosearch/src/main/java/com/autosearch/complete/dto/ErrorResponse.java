package com.autosearch.complete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {

    private String status;
    private String statusCode;
    private  String message;

}
