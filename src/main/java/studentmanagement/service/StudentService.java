/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.service;

import java.util.List;
import studentmanagement.entity.Student;

/**
 *
 * @author fatem
 */
public interface StudentService {
 List<Student> getAllStudents(); 
 Student saveStudent(Student student);
 Student getStudentById(int id);
 Student updateStudent(Student student);
 void deleteStudentById(int id);
}
