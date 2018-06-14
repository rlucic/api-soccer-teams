package com.ro.soccer.teams.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ro.soccer.teams.AbstractControllerTest;
import com.ro.soccer.teams.model.Player;
import com.ro.soccer.teams.model.Team;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

@Transactional
public class TeamsControllerTest extends AbstractControllerTest {


	@Before
	public void setUp(){
		super.setUp();
	}
	
	@Test
	public void testGetAllEndpoint() throws Exception{
		System.out.println("in testGetAllEndpoint... ");
		String uri = "/api/teams";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertEquals("HTTP 200 status expected", 200, status);
		Assert.assertTrue("Content should not be null or empty", content.trim().length() >0	);	
	}
	
	@Test
	public void testGetTeamEndpointPasses() throws Exception{
		System.out.println("in testGetTeamEndpointPasses... ");
		String uri = "/api/teams/{name}" ;
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, "Steaua").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertEquals("HTTP 200 status expected", 200, status);
		Assert.assertTrue("Content should not be null or empty", content.trim().length() >0	);	
		
	}
	
	@Test
	public void testGetTeamEndpointFails() throws Exception{
		System.out.println("in testGetTeamEndpointFails... ");
		String uri = "/api/teams/{name}" ;
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, "Barcelona").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertEquals("HTTP 200 status expected", 404, status);
		Assert.assertTrue("Content should not be null or empty", content.trim().length() == 0	);	
		
	}
	
	@Test
	public void testAddTeamEndpoint() throws Exception{
		System.out.println("in testAddTeamEndpoint... ");
		String uri = "/api/teams" ;
		Team t = new Team("Focsani", "Unirea", null);
		Player unu = new Player("Iordache", "goalkeeper");
		Player doi = new Player("Manta", "mid field");
		Set<Player> players = new HashSet();
		players.add(unu);
		players.add(doi);
		t.setPlayers(players);
		t.setMascotte("fara mascota");
		
		String teamString = mapToJson(t);
		System.out.println("JSON content: " + teamString);
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(teamString)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		Assert.assertEquals("HTTP 201 status expected", 201, status);
		Assert.assertTrue("Content should not be null or empty", content.trim().length() == 0	);	
		
	}
	
}
