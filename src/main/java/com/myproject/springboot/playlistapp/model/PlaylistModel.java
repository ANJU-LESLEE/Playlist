package com.myproject.springboot.playlistapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PlaylistModel {
	private Long playlistId;
	private String playlistName;
	private List<SongEntity> songList;
	private List<String> songItemResult ;
	
	public PlaylistModel() {
		this.songList = new ArrayList<SongEntity>();
		this.songItemResult = new ArrayList<>();
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
	public List<String> getSongItemResult() {
		return this.songItemResult;
	}
	public void setSongItemResult(List<String> songItemResult) {
		this.songItemResult = songItemResult;
	}

}
