package com.myproject.springboot.playlistapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.springboot.playlistapp.dao.PlayListDaoService;
import com.myproject.springboot.playlistapp.services.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;

	@RequestMapping("/list")
	public ModelAndView listPage() {
		ModelAndView modelAndView=new ModelAndView("playlist-list");
		modelAndView.addObject("playlistNametList", playlistService.getAllPlaylistSong());
		return modelAndView;
	}
	
	@RequestMapping("/addplaylist")
	public ModelAndView addplaylist() {
		ModelAndView modelAndView=new ModelAndView("playlist-list");
		modelAndView.addObject("playlistNametList", playlistService.getAllPlaylistSong());
		return modelAndView;
	}
}
