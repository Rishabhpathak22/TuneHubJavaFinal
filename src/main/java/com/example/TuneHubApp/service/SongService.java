package com.example.TuneHubApp.service;

import java.util.List;

import com.example.TuneHubApp.entities.Songs;

public interface SongService {
public String addSongs(Songs song);
public boolean songExists(String name);
public List<Songs> fetchAllSongs();
public void updateSong(Songs song);
}
