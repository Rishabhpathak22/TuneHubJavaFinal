package com.example.TuneHubApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp.entities.Songs;
import com.example.TuneHubApp.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongService{
    @Autowired
	SongsRepository songrepo;
	@Override
	public String addSongs(Songs song) {
		songrepo.save(song);
		return "SOng is added";
	}
	@Override
	public boolean songExists(String name) {
		Songs song=songrepo.findByName(name);
		if(song==null) {
			return false;
			
		}
		else {
			return true;
		}
	}
	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> songlist=songrepo.findAll();
	     return songlist;
	}
	@Override
	public void updateSong(Songs song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
		
	}

}
