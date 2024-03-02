package com.example.TuneHubApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp.entities.Playlist;

public interface PlayListRepository extends JpaRepository<Playlist, Integer>
{

}
