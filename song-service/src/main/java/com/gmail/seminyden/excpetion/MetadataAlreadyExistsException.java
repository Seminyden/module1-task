package com.gmail.seminyden.excpetion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetadataAlreadyExistsException extends RuntimeException {

    public MetadataAlreadyExistsException(String message) {
        super(message);
    }
}