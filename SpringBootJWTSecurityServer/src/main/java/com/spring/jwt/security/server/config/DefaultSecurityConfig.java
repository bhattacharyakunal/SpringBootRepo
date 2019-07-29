package com.spring.jwt.security.server.config;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.jwt.security.server.entity.UserEntity;
import com.spring.jwt.security.server.repository.UserRepository;

@Component
public class DefaultSecurityConfig implements CommandLineRunner {
	Logger log=LoggerFactory.getLogger(DefaultSecurityConfig.class);
	@Autowired UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Persisting Default Admin User Data to Database");
		CompletableFuture.runAsync(()->{
			UserEntity userEntity=new UserEntity();
			userEntity.setUsername("javainuse");
			userEntity.setPasskey("password");
			try {
			userRepository.save(userEntity);
			}catch(Exception ex) {
				log.error("[Exception Occurred while persisting user data :::::: {} ]",ex.getMessage(),ex);
			}
		});
		log.info("[Default User data persisting has been completed ]");
	}

}
