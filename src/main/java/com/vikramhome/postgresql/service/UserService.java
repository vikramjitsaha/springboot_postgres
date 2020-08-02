/**
 * 
 */
package com.vikramhome.postgresql.service;

/**
 * @author Vikram
 *
 */
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vikramhome.postgresql.dto.UserRegistrationDto;
import com.vikramhome.postgresql.model.UserDetail;


public interface UserService extends UserDetailsService {

    UserDetail findByEmail(String email);

    UserDetail save(UserRegistrationDto registration);
}