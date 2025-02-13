package com.gmail.seminyden.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String errorMessage;
    private Map<String, String> details;
    private String errorCode;
}