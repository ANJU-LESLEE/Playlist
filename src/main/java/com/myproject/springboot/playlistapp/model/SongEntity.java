package com.myproject.springboot.playlistapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "songs")
public class SongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String songName;
	private String singerName;

	public SongEntity() {}
	
	public SongEntity(int songId, String songName, String singerName) {
		this.songId = songId;
		this.songName = songName;
		this.singerName = singerName;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
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
}
