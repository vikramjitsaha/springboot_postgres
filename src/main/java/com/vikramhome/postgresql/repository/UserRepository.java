/**
 * 
 */
package com.vikramhome.postgresql.repository;

/**
 * @author Vikram
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikramhome.postgresql.model.UserDetail;


@Repository
public interface UserRepository extends JpaRepository < UserDetail, Long > {
	
    UserDetail findByEmail(String email);
}
