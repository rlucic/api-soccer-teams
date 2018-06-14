package com.ro.soccer.teams.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ro.soccer.teams.AbstractTestClass;
import com.ro.soccer.teams.model.Team;



@Transactional
public class TeamsServiceUnitTest extends AbstractTestClass{

	@Autowired
	private TeamsService teamsService;
	
	@Before
	public void setUp(){
		//logger.debug("Initializing the test....");
		System.out.println("Initializing the test....");
	}

	@After 
	public void tearDown(){
		System.out.println("Destroying the test....");
	}
	
	@Test
	public void testFindOneScenario(){
		System.out.println("in testFindOneScenario... ");
		Team t = teamsService.getTeamByName("Steaua");
		Assert.assertNotNull("Could not retrieve the team", t);
		
		//try to find a team that doesn't exist
		t = teamsService.getTeamByName("Rapid");
		Assert.assertTrue("Should not be able to find team Rapid", t == null);
		Assert.assertNull("Should not be able to find team Rapid", t);
	}

	
	
	
	@Test
	public void testFindAll(){
		System.out.println("in testFindAll... ");
		List<Team> teams = teamsService.getAll();
		
		Assert.assertNotNull("retrieved no teams", teams);
		Assert.assertEquals("wrong team members", 2, teams.size());
		
	}
}
