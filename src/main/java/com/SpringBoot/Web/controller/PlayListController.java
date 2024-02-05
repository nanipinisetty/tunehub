package com.SpringBoot.Web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringBoot.Web.entities.Song;
import com.SpringBoot.Web.entities.playlist;
import com.SpringBoot.Web.services.PlayListService;
import com.SpringBoot.Web.services.SongService;

@Controller
public class PlayListController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playListService;
	
	@GetMapping("/createPlayList")
	public String createPlayList(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "createPlayList";
	}
	
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute playlist playList) {
		
		//updating playList table
		playListService.addPlayList(playList);
		
		//updating song table
		List<Song> songList = playList.getSongs();
		for(Song s : songList) {
			s.getPlaylists().add(playList);	
			//update song object in db
			songService.updateSong(s);
			}
		return "adminHome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<playlist> allPlaylists = playListService.fetchAllPlayLists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylists";
	}

}
