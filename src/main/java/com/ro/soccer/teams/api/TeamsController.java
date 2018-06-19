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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(path="/api")
@Api()
public class TeamsController {

	
	@Autowired
	private TeamsService service;
	
	@ApiOperation(value="Used retrieve a team by name", response=Team.class)
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=404, message="Team not found")
		}
	)
	@RequestMapping(path="/teams/{name}", method=RequestMethod.GET)
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
	
	@ApiOperation(value="Used retrieve all teams", response=Team.class)
	@ApiResponses(value={
		@ApiResponse(code=200, message="Success"),
		@ApiResponse(code=400, message="Bad request")
		}
	)
	@RequestMapping(path="/teams", method=RequestMethod.GET)
	public ResponseEntity<List<Team>> getAll(){
		
		List<Team> teamList = service.getAll();
		ResponseEntity<List<Team>> resp = new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
		
		return resp;
	}
	
	@ApiOperation(value="Used add a new soccer team")
	@ApiResponses(value={
		@ApiResponse(code=201, message="Created"),
		@ApiResponse(code=400, message="Bad request submitted")
		}
	)
	@RequestMapping(path="/teams", 
			method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
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
 