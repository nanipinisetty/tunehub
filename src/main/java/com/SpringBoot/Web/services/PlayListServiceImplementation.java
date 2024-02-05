package com.SpringBoot.Web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Web.entities.playlist;
import com.SpringBoot.Web.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {

	
	@Autowired
	PlayListRepository repo;
	@Override
	public void addPlayList(playlist playList) {
     repo.save(playList);
     
		
	}
	@Override
	public List<playlist> fetchAllPlayLists() {
		
		return repo.findAll();
	}

}
