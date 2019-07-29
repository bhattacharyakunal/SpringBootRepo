package com.spring.jwt.security.server.model;

import java.io.Serializable;

public class JwtResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4407613923782947928L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getToken() {
		return this.jwttoken;
	}
}
