package com.myproject.springboot.playlistapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.springboot.playlistapp.model.SongEntity;

@Repository
public interface SongRepository extends CrudRepository<SongEntity, Long> {
}
