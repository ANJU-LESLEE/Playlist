package com.myproject.springboot.playlistapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.springboot.playlistapp.dao.PlayListDaoService;
import com.myproject.springboot.playlistapp.model.PlayListSongEntity;
import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistModel;
import com.myproject.springboot.playlistapp.model.SongEntity;
@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlayListDaoService playListDaoService;


	@Override
	public List<PlaylistModel> getAllPlaylistSong() {
		List<PlaylistModel> playlistModelList = new ArrayList<>();
		List<PlaylistEntity> playlistEntityList = playListDaoService.getAllPlaylist();
		playlistEntityList.stream().forEach(playlistEntity ->{
			PlaylistModel playlistModel=new PlaylistModel();
			List<SongEntity> songListlist=  null;
			playlistModel.setPlaylistId(playlistEntity.getPlaylistId());
			if(playlistEntity.getPlaylistName()!= null)
				playlistModel.setPlaylistName(playlistEntity.getPlaylistName());
			songListlist=playListDaoService.getSongListByPlaylistId(playlistEntity.getPlaylistId());
			if( Objects.isNull(songListlist))
				songListlist=Collections.emptyList();
			playlistModel.setSongList(songListlist);
			playlistModelList.add(playlistModel);
		});
		return playlistModelList;
	}
	
	@Override
	public int insertPlaylist(PlaylistEntity thePlaylist) {
		PlaylistEntity result = playListDaoService.getPlaylistByName(thePlaylist.getPlaylistName());
		if(Objects.isNull(result)) {
			int insertResult = playListDaoService.insert(thePlaylist);
			return insertResult;
		}
		return 0;
	}
	

	@Override
	public String deletePlaylist(String playlistId) {
		PlaylistEntity result = playListDaoService.getPlaylistByID(Long.valueOf(playlistId));
		if(Objects.nonNull(result)) {
			playListDaoService.deletePlaylist(Long.valueOf(playlistId));
			return "success";
		}
		return null;
	}

	@Override
	public String deleteSongById(Long playlistId,Long songId) {
		PlayListSongEntity result = playListDaoService.getSongByPlaylistId(playlistId, songId);
		if(Objects.nonNull(result)) {
			playListDaoService.deleteSong(result.getId());
			return "success";
		}
		return null;
	}

}
