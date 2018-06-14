package com.ro.soccer.teams;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//creates a web app context instead of a app context
@WebAppConfiguration
public abstract class AbstractControllerTest extends AbstractTestClass {

	//needed for simulation of HTTP interactions;
	protected MockMvc mvc;
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	//makes the MockMvc aware of all our app components by building it with the web app context object
	protected void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	
	protected String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> claszz) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, claszz);
	}
}
