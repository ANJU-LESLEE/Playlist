package com.myproject.springboot.playlistapp.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.springboot.playlistapp.model.PlayListSongEntity;

@Repository
public interface PlayListSongRepository extends CrudRepository<PlayListSongEntity, Long> {

}
