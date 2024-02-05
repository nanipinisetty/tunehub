package com.SpringBoot.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Web.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);

}
