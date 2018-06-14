 package com.ro.soccer.teams.api;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.ro.soccer.teams.AbstractControllerTest;
import com.ro.soccer.teams.service.TeamsService;

@Transactional
public class PingEndpointTest extends AbstractControllerTest{
	
	@Autowired
	private TeamsService service;
	
	@Before
	public void setUp(){
		super.setUp();
	}
	
	@Test
	public void testPingEndpoint() throws Exception{
		System.out.println("in testPingEndpoint... ");
		String uri = "/ping";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		
		Assert.assertEquals("expected HTTP 200, received: " + status, 200, status);
	}
}
