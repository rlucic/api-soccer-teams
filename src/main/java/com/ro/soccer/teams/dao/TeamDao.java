package com.ro.soccer.teams.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ro.soccer.teams.model.Team;

@Repository
public interface TeamDao extends CrudRepository<Team, Long>{

	List<Team> findAll();
	
	Team findByName(String name);
}
