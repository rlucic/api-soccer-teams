package com.ro.soccer.teams.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class GenericApiHeadersResponseFilter extends GenericFilterBean {

	
//	@Value("${app.major.minor.version}")
	private String version;
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.addHeader("version", version);
		
		chain.doFilter(request, response);
		
		System.out.println("Inside the special filter on the response path");

	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}

}
