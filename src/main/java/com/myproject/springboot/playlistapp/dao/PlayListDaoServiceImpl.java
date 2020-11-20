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
	private PlayListSongRepository playListSongRepository;
	@Autowired
	private SongRepository songRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	final private String QUERYBYID="SELECT  sg.song_id, sg.song_name, sg.singer_name  FROM songs sg JOIN playlist_song_def psd ON sg.song_id=psd.song_id where psd.playlist_id= ?";

	final private String INSERTPLAYLIST="INSERT INTO playlist (playlist_name) VALUES(?)";
	
	final private String SONGIDQUERY="SELECT * FROM playlist_song_def where playlist_id=? and song_id=? ";
	
	final private String SONGIDBYNAME="SELECT song_id FROM songs where song_name=\"?\" and singer_name=\"?\" ";
	
	final private String INSERTSONG="INSERT INTO playlist_song_def (playlist_id,song_id) VALUES(?,?)";
	@Override
	public List<PlaylistEntity> getAllPlaylist() {
		final List<PlaylistEntity> playlistEntityList = new ArrayList<>();
		playlistRepository.findAll().forEach(playlistEntityList::add);
		return playlistEntityList;
	}

	@Override
	public List<SongEntity> getAllSong() {
		return (List<SongEntity>)songRepository.findAll();
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
	public PlaylistEntity getPlaylistByID(Long playlistId) {
		return playlistRepository.findById(playlistId).stream().findFirst().orElse(null);
	}
	
	@Override
	public PlaylistEntity getPlaylistByName(String playlistName) {
		return playlistRepository.findByPlaylistName(playlistName);
	}

	@Override
	public int insert(PlaylistEntity thePlaylist) {
		return jdbcTemplate.update(INSERTPLAYLIST, thePlaylist.getPlaylistName());
	}
	
	@Override
	public void deletePlaylist(Long playlistId) {
		 playlistRepository.deleteById(playlistId);
	}
	
	@Override
	public PlayListSongEntity getSongByPlaylistId(Long playlistId,Long SongId) {
		List<PlayListSongEntity> resultEntity = jdbcTemplate.query(SONGIDQUERY,new Object[]{playlistId,SongId},new RowMapper<PlayListSongEntity>() {

			@Override
			public PlayListSongEntity mapRow(ResultSet rs, int rownum) throws SQLException {
				PlayListSongEntity playListSongEntity = new PlayListSongEntity(
						rs.getLong("id"),
						rs.getLong("playlist_id"),
						rs.getLong("song_id"));
				return playListSongEntity;
			}
		});
		if(!resultEntity.isEmpty())
			return resultEntity.stream().findFirst().orElse(null);
		return null;
	}

	@Override
	public void deleteSong(Long id) {
		 playListSongRepository.deleteById(id);
	}
	
	@Override
	public int getSongIdByName(String songName,String singerName) {
		List<Integer> resultEntity = jdbcTemplate.query(SONGIDBYNAME, new Object[]{songName,singerName},  new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rownum) throws SQLException {
						return rs.getInt("song_id");
			}
		});
		if(!resultEntity.isEmpty())
			return resultEntity.stream().findFirst().orElse(null);
		return 0;
		
	}
	
	@Override
	public int insertSong(PlayListSongEntity playListSongEntity) {
		return jdbcTemplate.update(INSERTSONG, playListSongEntity.getPlaylistId(),playListSongEntity.getSongId());
	}

}
