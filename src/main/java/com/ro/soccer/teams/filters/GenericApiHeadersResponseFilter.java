package com.ro.soccer.teams.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class GenericApiHeadersResponseFilter extends GenericFilterBean {

	
	//@Value("${thread-pool}")
	@Value("${app.version}")
	private String version;
	
	private String v="1.0";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.addHeader("version", v);
		
		chain.doFilter(request, response);
		
		System.out.println("Version from application.properties: " + version);
		System.out.println("Inside the special filter on the response path");

	}

}
