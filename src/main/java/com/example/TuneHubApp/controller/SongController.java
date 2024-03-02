package com.example.TuneHubApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TuneHubApp.entities.Songs;
import com.example.TuneHubApp.service.SongService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongController {
	@Autowired
	SongService songserv;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song) {
		String name=song.getName();
		boolean status=songserv.songExists(name);
		if(status==false) {
			songserv.addSongs(song);
			return "songaddsucess";	
		}
		else {
			return "songfail";
		}
	}
	@GetMapping("/viewsongs")
	public String viewSongs(Model model){
		//fetch the list from database
		List<Songs> songlist=songserv.fetchAllSongs();
		model.addAttribute("songlist",songlist);
		return "displaysongs1";
	}
	@GetMapping("/viewCustsongs")
	public String viewCustomerSongs(Model model) {
		boolean primeCustomerStatus = true;
		if(primeCustomerStatus==true) {
			List<Songs> songlist=songserv.fetchAllSongs();
			model.addAttribute("songlist",songlist);
			return "displaysongs";
		}
		else {
			return "makepayment";
		}
	}
	
}
