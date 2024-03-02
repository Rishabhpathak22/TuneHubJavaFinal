package com.example.TuneHubApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TuneHubApp.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer>
{
  public Users findByEmail(String email);
}
