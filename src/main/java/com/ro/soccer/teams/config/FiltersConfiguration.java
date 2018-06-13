package com.ro.soccer.teams.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ro.soccer.teams.filters.GenericApiResponseFilter;

@Configuration
public class FiltersConfiguration {

	@Bean
	public FilterRegistrationBean genericResponseFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new GenericApiResponseFilter());
		//frb.addUrlPatterns("/api");
		return frb;
	}
}
