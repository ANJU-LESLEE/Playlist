package com.myproject.springboot.playlistapp.controller;


import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.springboot.playlistapp.model.PlaylistEntity;
import com.myproject.springboot.playlistapp.model.PlaylistModel;
import com.myproject.springboot.playlistapp.model.SongEntity;
import com.myproject.springboot.playlistapp.services.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	@RequestMapping("/list")
	public ModelAndView listPage() {
		ModelAndView modelAndView=new ModelAndView("playlist-list");
		modelAndView.addObject("playlistItem", new PlaylistEntity());
		modelAndView.addObject("playlistNameItem", new PlaylistModel());
		modelAndView.addObject("playlistNametList", playlistService.getAllPlaylistSong());
		return modelAndView;
	}

	@RequestMapping("/addplaylist")
	public ModelAndView addplaylist(@Valid @ModelAttribute("playlistItem") PlaylistEntity thePlaylist, BindingResult bindingResult) {
		ModelAndView modelAndView=new ModelAndView("redirect:list");
		int insertResult = playlistService.insertPlaylist(thePlaylist);
		if(insertResult==0) {
			modelAndView.addObject("ResultMsg", "Playlist with same name already Exists");	
		}else {
			modelAndView.addObject("ResultMsg", "Playlist Created Successfully");
		}
		modelAndView.addObject("playlistNametList", playlistService.getAllPlaylistSong());
		return modelAndView;
	}

	@RequestMapping(value="deletePlaylist/{playlistId}")
	public ModelAndView deletePlaylist(@PathVariable("playlistId") String thePlaylistId) {
		ModelAndView modelAndView=new ModelAndView("redirect:/playlist/list");
		String deleteResult= playlistService.deletePlaylist(thePlaylistId);
		if(Objects.nonNull(deleteResult)) {
			modelAndView.addObject("ResultMsg", "Playlist Deleted Successfully");	
		}
		return modelAndView;
	}
	
	@RequestMapping(value="deleteSong/{playlistId}/{songId}")
	public ModelAndView deleteSong(@PathVariable("playlistId") String thePlaylistId, @PathVariable("songId") String songId) {
		ModelAndView modelAndView=new ModelAndView("redirect:/playlist/list");
		String deleteResult= playlistService.deleteSongById(Long.valueOf(thePlaylistId), Long.valueOf(songId));
		if(Objects.nonNull(deleteResult)) {
			modelAndView.addObject("ResultMsg", "Playlist Deleted Successfully");	
		}
		return modelAndView;
	}
	
	@RequestMapping("/addSong/{playlistId}")
	public ModelAndView addplaylist(@PathVariable("playlistId") String thePlaylistId,@ModelAttribute("playlistNameItem") PlaylistModel playlistModel, BindingResult bindingResult) {
		ModelAndView modelAndView=new ModelAndView("redirect:/playlist/list");
		int insertResult = playlistService.insertSong(thePlaylistId,playlistModel.getSongItemResult().toString());
		if(insertResult==0) {
			modelAndView.addObject("ResultMsg", "Songs already exists");	
		}else {
			modelAndView.addObject("ResultMsg", "Song added Successfully");
		}
		modelAndView.addObject("playlistNametList", playlistService.getAllPlaylistSong());
		return modelAndView;
	}
}
