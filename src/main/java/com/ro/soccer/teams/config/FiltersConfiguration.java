package com.ro.soccer.teams.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ro.soccer.teams.filters.GenericApiHeadersResponseFilter;
import com.ro.soccer.teams.filters.GenericApiLoggingFilter;


@Configuration
public class FiltersConfiguration {

//	@Autowired
//	GenericApiLoggingFilter genericApiLoggingFilter;
	
	
	@Value("${app.major.minor.version}")
	private String version;
	
	@Bean
	public FilterRegistrationBean genericResponseHeadersFilter(){
		GenericApiHeadersResponseFilter gahrf = new GenericApiHeadersResponseFilter();
		gahrf.setVersion(version);
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(gahrf);
		//frb.addUrlPatterns("/api");
		//frb.ad
		
		System.out.println("The version string from FiltersConfiguration " + version);
		return frb;
	}
	
	@Bean
	public FilterRegistrationBean genericApiLoggingFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new GenericApiLoggingFilter());
		
		return frb;
	}
}
