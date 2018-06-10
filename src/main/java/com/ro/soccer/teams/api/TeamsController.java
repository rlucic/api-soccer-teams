package com.ro.soccer.teams.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ro.soccer.teams.model.Team;
import com.ro.soccer.teams.dao.TeamDao;


@RestController
@RequestMapping(path="/api")
public class TeamsController {

	@Autowired
	private TeamDao teamDao;
	
	@RequestMapping(path="/teams/{name}")
	public Team getTeam(@PathVariable String name){
		return teamDao.findByName(name);
	}
	
	@RequestMapping(path="/teams")
	public List<Team> getAll(){
		return teamDao.findAll();
	}
	
	
}
