package com.gmail.seminyden.mapper;

import com.gmail.seminyden.entity.ResourceEntity;
import com.gmail.seminyden.model.EntityIdDTO;
import com.gmail.seminyden.model.EntityIdsDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceMapper {

    public ResourceEntity toResourceEntity(byte[] resource) {
        ResourceEntity entity = new ResourceEntity();
        entity.setResource(resource);
        return entity;
    }

    public EntityIdDTO toEntityIdDTO(ResourceEntity entity) {
        return EntityIdDTO.builder()
                .id(entity.getId())
                .build();
    }

    public EntityIdsDTO toEntityIdsDTO(List<Integer> ids) {
        return EntityIdsDTO.builder()
                .ids(ids)
                .build();
    }

    public String toString(Integer value) {
        return String.valueOf(value);
    }

    public List<Integer> toIntList(String ids) {
        return Arrays.stream(ids.split(","))
                .map(this::toInt)
                .collect(Collectors.toList());
    }

    public Integer toInt(String value) {
        return Integer.valueOf(value);
    }
}