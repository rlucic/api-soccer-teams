package com.ro.soccer.teams.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ro.soccer.teams.model.Team;
import com.ro.soccer.teams.service.TeamsService;
import com.ro.soccer.teams.dao.TeamDao;


@RestController
@RequestMapping(path="/api")
public class TeamsController {

	
	@Autowired
	private TeamsService service;
	
	@RequestMapping(path="/teams/{name}")
	public ResponseEntity<Team> getTeam(@PathVariable String name){
		ResponseEntity<Team> resp;
		Team t = service.getTeamByName(name);
		if(t != null)
			resp = new ResponseEntity<Team>(t, HttpStatus.OK);
		else{
			resp = new ResponseEntity<Team>(t, HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	@RequestMapping(path="/teams")
	public ResponseEntity<List<Team>> getAll(){
		
		List<Team> teamList = service.getAll();
		ResponseEntity<List<Team>> resp = new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(path="/teams", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> addTeam(@RequestBody Team t){
		System.out.println("into the addTeam endpoint.....");
		ResponseEntity<Team> resp;
		if (t == null){
			resp = new ResponseEntity<Team>(HttpStatus.BAD_REQUEST);
		}
		service.saveTeam(t);
		resp = new ResponseEntity<Team> (HttpStatus.CREATED);
		return resp;
	}
	
}
 