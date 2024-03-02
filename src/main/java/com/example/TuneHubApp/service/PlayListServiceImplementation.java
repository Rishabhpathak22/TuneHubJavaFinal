package com.example.TuneHubApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TuneHubApp.entities.Playlist;
import com.example.TuneHubApp.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {
	@Autowired
	PlayListRepository plrepo;

	@Override
	public List<Playlist> fetchPlaylists() {
		// TODO Auto-generated method stub
		return plrepo.findAll();
	}

	@Override
	public void addPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		plrepo.save(playlist);

	}
}
