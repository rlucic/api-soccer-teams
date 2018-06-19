package com.ro.soccer.teams.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingEndpoint {
	
	@Value("${server.port}")
	String serverPort;
	
	@Value("${app.major.minor.version}")
	private String version;
	
	@RequestMapping(value="/ping")
	public ResponseEntity<String> ping(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Version", version);
		headers.add("PING_RESPONSE_HEADER", "P_R_H_VALUE");
		
		final LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Server port: " + serverPort);
		System.out.println("app.major.minor.version : " + version);		
		
		ResponseEntity<String> resp = new ResponseEntity<String>("pong @" + ldt + ", version: " + version, headers, HttpStatus.OK);
				//new ResponseEntity<String>("Pong", HttpStatus.OK);
		return resp;
	}
}
