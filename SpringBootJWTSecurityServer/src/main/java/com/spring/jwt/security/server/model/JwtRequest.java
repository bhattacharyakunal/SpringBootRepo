package com.spring.jwt.security.server.model;

import java.io.Serializable;

/**
 * 
 * @author Kunal
 *
 */
public class JwtRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2084075078740068942L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
