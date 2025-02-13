package com.gmail.seminyden.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongMetadataDTO {

    @NotBlank(message = "Id should not be blank")
    @Pattern(regexp = "^\\d+$", message = "Id should be numeric string")
    private String id;

    @NotBlank(message = "Name should not be blank")
    @Size(min = 1, max = 100, message = "Name should be from 1 to 100 characters")
    private String name;

    @NotBlank(message = "Artist should not be blank")
    @Size(min = 1, max = 100, message = "Artist should be from 1 to 100 characters")
    private String artist;

    @NotBlank(message = "Album should not be blank")
    @Size(min = 1, max = 100, message = "Album should be from 1 to 100 characters")
    private String album;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):([0-5]?[0-9])$", message = "Duration should be in mm:ss format")
    private String duration;

    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Year should be YYYY format between 1900-2099")
    private String year;
}