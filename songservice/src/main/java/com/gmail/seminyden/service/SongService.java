package com.gmail.seminyden.service;

import com.gmail.seminyden.entity.SongMetadataEntity;
import com.gmail.seminyden.mapper.SongMetadataMapper;
import com.gmail.seminyden.model.SongIdDTO;
import com.gmail.seminyden.model.SongMetadataDTO;
import com.gmail.seminyden.repository.SongRepository;
import jakarta.annotation.Resource;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Resource
    private SongRepository songRepository;

    public SongIdDTO createSongMetadata(SongMetadataDTO songMetadata) {
        if (!songRepository.existsById(songMetadata.getId())) {
            SongMetadataEntity savedEntity = songRepository.save(
                    SongMetadataMapper.toSongMetadataEntity(songMetadata)
            );
            return SongMetadataMapper.toSongIdDTO(savedEntity);
        } else {
            throw new ValidationException("Metadata for this ID already exists.");
        }
    }

    public SongMetadataDTO getSongMetadata(String id) {
        return songRepository.findById(id)
                .map(SongMetadataMapper::toSongMetadataDTO)
                .orElse(null);
    }
}