package com.gmail.seminyden.service;

import com.gmail.seminyden.mapper.SongMetadataMapper;
import com.gmail.seminyden.model.EntityIdDTO;
import com.gmail.seminyden.model.EntityIdsDTO;
import com.gmail.seminyden.model.SongMetadataDTO;
import com.gmail.seminyden.service.client.SongMetadataClient;
import jakarta.annotation.Resource;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class SongMetadataService {

    @Resource
    private SongMetadataClient songMetadataClient;
    @Resource
    private SongMetadataMapper songMetadataMapper;

    public EntityIdDTO createSongMetadata(String resourceId, byte[] resource) {
        SongMetadataDTO songMetadataDTO = songMetadataMapper.toSongMetadataDTO(
                resourceId, getMetadata(resource)
        );
        return songMetadataClient.create(songMetadataDTO);
    }

    public EntityIdsDTO deleteSongsMetadata(List<Integer> songIds) {
        return songMetadataClient.delete(songIds);
    }

    private Metadata getMetadata(byte[] resource) {
        try(InputStream inputStream = new ByteArrayInputStream(resource)) {
            Metadata metadata = new Metadata();
            new AutoDetectParser().parse(inputStream, new BodyContentHandler(), metadata, new ParseContext());
            return metadata;

        } catch (IOException | TikaException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}