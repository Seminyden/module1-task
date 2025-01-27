package com.gmail.seminyden.mapper;

import com.gmail.seminyden.entity.SongMetadataEntity;
import com.gmail.seminyden.model.SongIdDTO;
import com.gmail.seminyden.model.SongMetadataDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SongMetadataMapper {

    public static SongMetadataEntity toSongMetadataEntity(SongMetadataDTO dto) {
        SongMetadataEntity entity = new SongMetadataEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setArtist(dto.getArtist());
        entity.setAlbum(dto.getAlbum());
        entity.setDuration(dto.getDuration());
        entity.setYear(dto.getYear());
        return entity;
    }

    public static SongMetadataDTO toSongMetadataDTO(SongMetadataEntity entity) {
        SongMetadataDTO dto = new SongMetadataDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setArtist(entity.getArtist());
        dto.setAlbum(entity.getAlbum());
        dto.setDuration(entity.getDuration());
        dto.setYear(entity.getYear());
        return dto;
    }

    public static SongIdDTO toSongIdDTO(SongMetadataEntity entity) {
        return SongIdDTO.builder()
                .id(entity.getId())
                .build();
    }
}