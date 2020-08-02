/**
 * 
 */
package com.vikramhome.postgresql.repository;

/**
 * @author Vikram
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikramhome.postgresql.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByName(String name);
    
}
