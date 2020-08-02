/**
 * 
 */
package com.vikramhome.postgresql.service;

/**
 * @author Vikram
 *
 */
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vikramhome.postgresql.dto.UserRegistrationDto;
import com.vikramhome.postgresql.model.UserDetail;
import com.vikramhome.postgresql.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetail findByEmail(String email) {
    	UserDetail user = null;
    	try {
			user = userRepository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return user;
    }

    public UserDetail save(UserRegistrationDto registration) {
        UserDetail user = new UserDetail();
        try {
			user.setFirstName(registration.getFirstName());
			user.setLastName(registration.getLastName());
			user.setEmail(registration.getEmail());
			user.setPassword(passwordEncoder.encode(registration.getPassword()));
			user.setRole("ROLE_USER");
			user = userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetail user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRole()));
    }

    private Collection <? extends GrantedAuthority> mapRolesToAuthorities(String roleVal) {
        return Stream.of(roleVal)
            .map(role -> new SimpleGrantedAuthority(role))
            .collect(Collectors.toList());
    }
}
