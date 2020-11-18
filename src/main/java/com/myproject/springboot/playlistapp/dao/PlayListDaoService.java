package com.myproject.springboot.playlistapp.dao;

import java.util.List;

import com.myproject.springboot.playlistapp.model.PlayListSongEntity;
import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistSongResultEntity;
import com.myproject.springboot.playlistapp.model.SongEntity;

public interface PlayListDaoService {
	
	public List<PlaylistEntity> getAllPlaylist();
	public List<SongEntity> getAllSong();
	public List<SongEntity> getSongListByPlaylistId(Long id);
	public List<PlaylistSongResultEntity> getAllPlaylistSong();
	List<PlayListSongEntity> getAllPlaylistSongDefault();
	
}
