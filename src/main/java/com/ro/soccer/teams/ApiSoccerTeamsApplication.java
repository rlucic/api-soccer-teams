package com.ro.soccer.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiSoccerTeamsApplication extends SpringBootServletInitializer{

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
}
