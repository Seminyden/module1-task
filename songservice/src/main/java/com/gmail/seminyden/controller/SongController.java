package com.gmail.seminyden.controller;

import com.gmail.seminyden.model.SongIdDTO;
import com.gmail.seminyden.model.SongMetadataDTO;
import com.gmail.seminyden.service.SongService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Resource
    private SongService songService;

    @PostMapping
    public ResponseEntity<SongIdDTO> createSongMetadata(@Valid @RequestBody SongMetadataDTO songMetadata) {
        SongIdDTO songIdDTO = songService.createSongMetadata(songMetadata);
        return ResponseEntity.ok(songIdDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongMetadataDTO> getSongMetadata(
            @PathVariable("id") @Pattern(regexp = "^\\d+$", message = "Id should be numeric string") String id
    ) {
        SongMetadataDTO songMetadataDTO = songService.getSongMetadata(id);
        return ResponseEntity.ok(songMetadataDTO);
    }
}