package com.SpringBoot.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Web.entities.Song;
import com.SpringBoot.Web.entities.Users;

public interface SongRepository extends JpaRepository<Song, Integer>{

	public Song findByName(String name);


}
