package com.spring.jwt.security.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "USER_ID_GEN")
	private Long userId;
	@Column(name="USER_NAME",unique = true)
	private String username;
	@Column(name="USER_PASSKEY")
	private String passkey;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPasskey() {
		return passkey;
	}
	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
