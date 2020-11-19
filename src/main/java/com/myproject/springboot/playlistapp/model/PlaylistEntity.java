package com.myproject.springboot.playlistapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "playlist")
public class PlaylistEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playlistId;


	@NotNull(message="is Required")
	@Max(20)
	private String playlistName;

	public PlaylistEntity() {
	}

	public PlaylistEntity(Long playlistId, String playlistName) {
		this.playlistId = playlistId;
		this.playlistName = playlistName;
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

}
