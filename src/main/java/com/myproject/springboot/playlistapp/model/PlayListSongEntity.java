package com.myproject.springboot.playlistapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playlist_song_def")
public class PlayListSongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long playlistId;
	private Long songId;

	public PlayListSongEntity() {
	}

	public PlayListSongEntity(Long id, Long playlistId, Long songId) {
		this.id = id;
		this.playlistId = playlistId;
		this.songId = songId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}

	@Override
	public String toString() {
		return "PlayListSongEntity [id=" + id + ", playlistId=" + playlistId + ", songId=" + songId + "]";
	}

}
