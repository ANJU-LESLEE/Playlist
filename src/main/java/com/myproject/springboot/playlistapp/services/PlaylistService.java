package com.myproject.springboot.playlistapp.services;

import java.util.List;

import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistModel;

public interface PlaylistService {
	
	public List<PlaylistModel> getAllPlaylistSong();

	public int insertPlaylist(PlaylistEntity thePlaylist);

	public String deletePlaylist(String playlistId);

	public String deleteSongById(Long playlistId, Long songId);

}
