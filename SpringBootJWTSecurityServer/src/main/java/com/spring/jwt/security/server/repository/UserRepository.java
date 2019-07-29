package com.spring.jwt.security.server.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.jwt.security.server.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	public UserEntity findByUsername(String username); 
}
