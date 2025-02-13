package com.gmail.seminyden.service;

import com.gmail.seminyden.entity.ResourceEntity;
import com.gmail.seminyden.exception.ResourceNotFoundException;
import com.gmail.seminyden.mapper.ResourceMapper;
import com.gmail.seminyden.model.EntityIdDTO;
import com.gmail.seminyden.model.EntityIdsDTO;
import com.gmail.seminyden.repository.ResourceRepository;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Resource
    private SongMetadataService songMetadataService;
    @Resource
    private ResourceRepository resourceRepository;
    @Resource
    private ResourceMapper resourceMapper;

    public EntityIdDTO createResource(byte[] resource) {
        ResourceEntity resourceEntity = resourceRepository.save(
                resourceMapper.toResourceEntity(resource)
        );
        songMetadataService.createSongMetadata(
                resourceMapper.toString(resourceEntity.getId()), resource
        );
        return resourceMapper.toEntityIdDTO(resourceEntity);
    }

    public byte[] getResource(String id) {
        return resourceRepository.findById(resourceMapper.toInt(id))
                .map(ResourceEntity::getResource)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource with the specified ID does not exist.")
                );
    }

    public EntityIdsDTO deleteResources(String ids) {
        List<Integer> deletedResourceIds = new ArrayList<>();
        resourceRepository.findAllById(resourceMapper.toIntList(ids))
                .forEach(resourceEntity -> {
                    deletedResourceIds.add(resourceEntity.getId());
                    resourceRepository.delete(resourceEntity);
                });
        songMetadataService.deleteSongsMetadata(ids);
        return resourceMapper.toEntityIdsDTO(deletedResourceIds);
    }
}