package com.gmail.seminyden.service.client;

import com.gmail.seminyden.model.EntityIdDTO;
import com.gmail.seminyden.model.EntityIdsDTO;
import com.gmail.seminyden.model.SongMetadataDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SongMetadataClient {

    @Value("${app.songs.metadata.base.url}")
    private String baseUrl;

    @Value("${app.songs.metadata.songs.endpoint}")
    private String songsEndpoint;

    public EntityIdDTO create(SongMetadataDTO songMetadataDTO) {
        System.out.println(baseUrl + songsEndpoint);
        return new RestTemplate().postForObject(
                baseUrl + songsEndpoint,
                new HttpEntity<>(songMetadataDTO),
                EntityIdDTO.class
        );
    }

    public EntityIdsDTO delete(List<Integer> ids) {
        System.out.println(baseUrl + songsEndpoint + "?id=" + ids);
        return new RestTemplate().exchange(
                baseUrl + songsEndpoint + "?id=" + ids,
                HttpMethod.POST,
                new HttpEntity<>(null),
                EntityIdsDTO.class
        ).getBody();
    }
}