package com.gmail.seminyden.repository;

import com.gmail.seminyden.entity.SongMetadataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongMetadataRepository extends CrudRepository<SongMetadataEntity, String> {
}