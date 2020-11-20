package com.myproject.springboot.playlistapp.services;

import java.util.LinkedHashMap;
import java.util.List;

import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistModel;
import com.myproject.springboot.playlistapp.model.SongEntity;

public interface PlaylistService {
	
	public List<PlaylistModel> getAllPlaylistSong();

	public int insertPlaylist(PlaylistEntity thePlaylist);

	public String deletePlaylist(String playlistId);

	public String deleteSongById(Long playlistId, Long songId);

	public List<String>  getAllSong();

	public int insertSong(String playlistId, String songDetails);

}
