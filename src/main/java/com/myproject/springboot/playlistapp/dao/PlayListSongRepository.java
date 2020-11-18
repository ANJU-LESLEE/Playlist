package com.myproject.springboot.playlistapp.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.springboot.playlistapp.model.PlayListSongEntity;

@Repository
public interface PlayListSongRepository extends CrudRepository<PlayListSongEntity, Long> {

//	@Query(value="SELECT psd.id, pl.playlist_id,psd.song_id, pl.playlist_name ,sg.song_name, sg.singer_name  FROM playlist_song_def psd JOIN songs sg ON sg.song_id=psd.song_id JOIN playlist pl ON pl.playlist_id= psd.playlist_id", nativeQuery = true)
//	ResultSet findAllPlaylistSong();

}
