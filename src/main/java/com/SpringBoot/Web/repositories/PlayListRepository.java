package com.SpringBoot.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Web.entities.playlist;

public interface PlayListRepository extends JpaRepository<playlist, Integer> {

}
