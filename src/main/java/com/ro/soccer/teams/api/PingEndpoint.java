package com.ro.soccer.teams.api;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingEndpoint {
	
	@RequestMapping(value="/ping")
	public ResponseEntity<String> ping(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Version", "1.0");
		headers.add("PING_RESPONSE_HEADER", "P_R_H_VALUE");
		
		final LocalDateTime ldt = LocalDateTime.now();
		
		ResponseEntity<String> resp = new ResponseEntity<String>("pong @" + ldt, headers, HttpStatus.OK);
				//new ResponseEntity<String>("Pong", HttpStatus.OK);
		return resp;
	}
}
