package com.ro.soccer.teams.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ro.soccer.teams.filters.GenericApiHeadersResponseFilter;
import com.ro.soccer.teams.filters.GenericApiLoggingFilter;

@Configuration
public class FiltersConfiguration {

	@Bean
	public FilterRegistrationBean genericResponseHeadersFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new GenericApiHeadersResponseFilter());
		//frb.addUrlPatterns("/api");
		//frb.ad
		return frb;
	}
	
	@Bean
	public FilterRegistrationBean genericApiLoggingFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new GenericApiLoggingFilter());
		
		return frb;
	}
}
