package com.myproject.springboot.playlistapp.services;

import java.util.List;

import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistModel;

public interface PlaylistService {
	
	public List<PlaylistModel> getAllPlaylistSong();

}
