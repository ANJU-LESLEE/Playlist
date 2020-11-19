package com.myproject.springboot.playlistapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class PlaylistModel {
	private Long playlistId;
	private String playlistName;
	private List<SongEntity> songList;
	
	public PlaylistModel() {
		this.songList = new ArrayList<SongEntity>();
	}
	public String getPlaylistName() {
		return playlistName;
	}
	public Long getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public List<SongEntity> getSongList() {
		return songList;
	}
	public void setSongList(List<SongEntity> songList) {
		this.songList = songList;
	}
	

}
