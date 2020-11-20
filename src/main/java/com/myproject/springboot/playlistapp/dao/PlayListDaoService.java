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
	public PlaylistEntity getPlaylistByID(Long playlistId);
	public PlayListSongEntity getSongByPlaylistId(Long playlistId, Long SongId);
	public PlaylistEntity getPlaylistByName(String playlistName);
	public int insert(PlaylistEntity thePlaylist);
	public void deletePlaylist(Long playlistId);
	public void deleteSong(Long id);
	public int getSongIdByName(String songName, String singerName);
	public int insertSong(PlayListSongEntity playListSongEntity);
	
}
