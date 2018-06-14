package com.ro.soccer.teams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ro.soccer.teams.dao.TeamDao;
import com.ro.soccer.teams.model.Team;

@Service
public class TeamsService {

	@Autowired
	TeamDao teamDao;
	
	public Team getTeamByName(String name){
		return teamDao.findByName(name);
	}
	
	public List<Team> getAll(){
		return teamDao.findAll();
	}
	
	public void saveTeam(Team t){
		teamDao.save(t);
		//return ;
	}
	
}
