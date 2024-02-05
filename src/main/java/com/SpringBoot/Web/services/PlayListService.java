package com.SpringBoot.Web.services;

import java.util.List;


import com.SpringBoot.Web.entities.playlist;

public interface PlayListService {
	public void addPlayList(playlist playList);

	public List<playlist> fetchAllPlayLists();

	

}
