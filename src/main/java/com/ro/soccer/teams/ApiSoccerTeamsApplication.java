package com.ro.soccer.teams;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ro.soccer.teams.dao.TeamDao;
import com.ro.soccer.teams.model.Player;
import com.ro.soccer.teams.model.Team;

@SpringBootApplication
public class ApiSoccerTeamsApplication extends SpringBootServletInitializer{

	@Autowired
	TeamDao teamDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiSoccerTeamsApplication.class, args);
	}
	
	/**
	 * Use the below + changing the packaging in pom.xml to generate a war and run it in a web conatainer.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(ApiSoccerTeamsApplication.class);
	}
	
	@PostConstruct
	public void init(){
		Set<Player> playersSteaua = new HashSet<Player>();
		
		playersSteaua.add(new Player("Hagi", "Mid field"));
		playersSteaua.add(new Player("Popescu", "Defender"));
		
		Team team = new Team("Bucharest", "Steaua", playersSteaua);
		team.setMascotte("The Army Team");
		teamDao.save(team);
		
		Set<Player> playersDinamo = new HashSet<Player>();
		playersDinamo.add(new Player("Mutu", "Atacker"));
		
		Team teamDinamo = new Team("Bucharest", "Dinamo", playersDinamo);
		teamDinamo.setMascotte("Red Dogs");
		teamDao.save(teamDinamo);
	}
}
