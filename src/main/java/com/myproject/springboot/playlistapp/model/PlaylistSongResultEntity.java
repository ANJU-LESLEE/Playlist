package com.myproject.springboot.playlistapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlaylistSongResultEntity {
	@Id
	private Long id;
	private Long playlistId;
	private Long songId;
	private String playlistName;
	private String songName;
	private String singerName;
	
	public PlaylistSongResultEntity() {}
	
	
	public PlaylistSongResultEntity(Long id, Long playlistId, Long songId, String playlistName, String songName,
			String singerName) {
		super();
		this.id = id;
		this.playlistId = playlistId;
		this.songId = songId;
		this.playlistName = playlistName;
		this.songName = songName;
		this.singerName = singerName;
	}


	public Long getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public String getPlaylistName() {
		return playlistName;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}
	
	

}
