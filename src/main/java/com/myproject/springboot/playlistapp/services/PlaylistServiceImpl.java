package com.myproject.springboot.playlistapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.springboot.playlistapp.dao.PlayListDaoService;
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


}
