package com.example.TuneHubApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp.entities.Songs;
import com.example.TuneHubApp.entities.Users;

public interface SongsRepository  extends JpaRepository<Songs, Integer>{
	public Songs findByName(String name);
}
