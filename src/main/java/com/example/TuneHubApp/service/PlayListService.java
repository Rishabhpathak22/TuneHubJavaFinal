package com.example.TuneHubApp.service;

import java.util.List;

import com.example.TuneHubApp.entities.Playlist;

public interface PlayListService {

	public List<Playlist> fetchPlaylists();

	public void addPlaylist(Playlist playlist);

}
