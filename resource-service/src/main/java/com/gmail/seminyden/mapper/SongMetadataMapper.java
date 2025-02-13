package com.gmail.seminyden.mapper;

import com.gmail.seminyden.model.SongMetadataDTO;
import com.gmail.seminyden.utils.TimeConverter;
import org.apache.tika.metadata.Metadata;
import org.springframework.stereotype.Component;

@Component
public class SongMetadataMapper {

    public SongMetadataDTO toSongMetadataDTO(String id, Metadata metadata) {
        for(String field : metadata.names()) {
            System.out.println(field + ": " + metadata.get(field));
        }
        return SongMetadataDTO.builder()
                .id(id)
                .name(metadata.get("dc:title"))
                .artist(metadata.get("xmpDM:artist"))
                .album(metadata.get("xmpDM:album"))
                .duration(TimeConverter.convert(metadata.get("xmpDM:duration")))
                .year(metadata.get("xmpDM:releaseDate"))
                .build();
    }
}