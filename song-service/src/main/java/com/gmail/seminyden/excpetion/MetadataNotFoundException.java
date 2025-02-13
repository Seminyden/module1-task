package com.gmail.seminyden.excpetion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetadataNotFoundException extends RuntimeException{

    public MetadataNotFoundException(String message) {
        super(message);
    }
}