/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentmanagement.entity.Student;

/**
 *
 * @author fatem
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
