package com.ro.soccer.teams.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ro.soccer.teams.model.Team;

public interface TeamDao extends CrudRepository<Team, Long>{

	List<Team> findAll();
	
	Team findByName(String name);
}
