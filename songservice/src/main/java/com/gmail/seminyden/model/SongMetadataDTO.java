package com.gmail.seminyden.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongMetadataDTO {

    @Pattern(regexp = "^\\d+$", message = "Id should be numeric string")
    private String id;

    @Size(min = 1, max = 100, message = "Name should be from 1 to 100 characters")
    private String name;

    @Size(min = 1, max = 100, message = "Artist should be from 1 to 100 characters")
    private String artist;

    @Size(min = 1, max = 100, message = "Album should be from 1 to 100 characters")
    private String album;

    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Duration should be in mm:ss format")
    private String duration;

    @Pattern(regexp = "^\\d{4}$", message = "Year should be YYYY format")
    //TODO between 1900-2099
    private String year;
}