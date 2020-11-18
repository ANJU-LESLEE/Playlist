package com.myproject.springboot.playlistapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.myproject.springboot.playlistapp.model.PlayListSongEntity;
import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistSongResultEntity;
import com.myproject.springboot.playlistapp.model.SongEntity;

@Service
public class PlayListDaoServiceImpl implements PlayListDaoService {

	@Autowired
	private PlaylistRepository playlistRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	final private String QUERY="SELECT psd.id, pl.playlist_id,psd.song_id, pl.playlist_name ,sg.song_name, sg.singer_name  FROM playlist_song_def psd JOIN songs sg ON sg.song_id=psd.song_id JOIN playlist pl ON pl.playlist_id= psd.playlist_id";

	final private String QUERYBYID="SELECT  sg.song_id, sg.song_name, sg.singer_name  FROM songs sg JOIN playlist_song_def psd ON sg.song_id=psd.song_id where psd.playlist_id= ?";

	@Override
	public List<PlaylistEntity> getAllPlaylist() {
		final List<PlaylistEntity> playlistEntityList = new ArrayList<>();
		playlistRepository.findAll().forEach(playlistEntityList::add);
		return playlistEntityList;
	}

	@Override
	public List<SongEntity> getAllSong() {
		return null;
	}

	@Override
	public List<SongEntity> getSongListByPlaylistId(Long id) {

		List<SongEntity> songEntityList = null;
		songEntityList = jdbcTemplate.query(QUERYBYID,new Object[]{id} ,new RowMapper<SongEntity>() {

			@Override
			public SongEntity mapRow(ResultSet rs, int rownum) throws SQLException {
				SongEntity songEntity = new SongEntity(
						rs.getInt("song_id"),
						rs.getString("song_name"),
						rs.getString("singer_name"));
				return songEntity;
			}
		});
		if(!songEntityList.isEmpty())
			return songEntityList;
		return null;
	}

	@Override
	public List<PlaylistSongResultEntity> getAllPlaylistSong() {
		List<PlaylistSongResultEntity> playlistSongResultEntityList = jdbcTemplate.query(QUERY, new RowMapper<PlaylistSongResultEntity>() {

			@Override
			public PlaylistSongResultEntity mapRow(ResultSet rs, int rownum) throws SQLException {
				PlaylistSongResultEntity playlistSongResultEntity = new PlaylistSongResultEntity(
						rs.getLong("id"),
						rs.getLong("playlist_id"),
						rs.getLong("song_id"),
						rs.getString("playlist_name"),
						rs.getString("song_name"),
						rs.getString("Singer_name"));
				return playlistSongResultEntity;
			}
		});
		return playlistSongResultEntityList;
	}

	@Override
	public List<PlayListSongEntity> getAllPlaylistSongDefault() {
		// TODO Auto-generated method stub
		return null;
	}

}
