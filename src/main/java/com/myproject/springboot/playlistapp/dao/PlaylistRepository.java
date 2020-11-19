package com.myproject.springboot.playlistapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.springboot.playlistapp.model.PlaylistEntity;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistEntity, Long> {
	public PlaylistEntity findByPlaylistName(String playlistName);
}
