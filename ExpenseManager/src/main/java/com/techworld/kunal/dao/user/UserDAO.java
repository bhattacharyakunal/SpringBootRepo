/**
 * 
 */
package com.techworld.kunal.dao.user;

import org.springframework.data.repository.CrudRepository;

import com.techworld.kunal.model.user.LoginUser;

/**
 * @author Kunal
 *
 */
public interface UserDAO extends CrudRepository<LoginUser, Long> {

}
