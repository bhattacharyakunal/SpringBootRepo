package com.spring.jwt.security.server.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.jwt.security.server.entity.UserEntity;
import com.spring.jwt.security.server.repository.UserRepository;

@Service
public class JwtUserDetailService implements UserDetailsService {
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userRepository.findByUsername(username);
		UserDetails userDetails = (UserDetails)new User(userEntity.getUsername(),passwordEncoder.encode(userEntity.getPasskey()), new ArrayList<>());
		return userDetails;
	}
}
