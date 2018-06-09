package com.ro.soccer.teams.api;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ro.soccer.teams.model.Team;
import com.ro.soccer.teams.model.Player;


@RestController
@RequestMapping(path="/api")
public class TeamsController {

	private Team team;
	
	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<Player>();
		
		players.add(new Player("Hagi", "Mid field"));
		players.add(new Player("Popescu", "Defender"));
		players.add(new Player("Mutu", "Atacker"));
		
		team = new Team("Bucharest", "Steaua", players);
	}
	
	@RequestMapping(path="/team")
	public Team getTeam(){
		return team;
	}
	
}
