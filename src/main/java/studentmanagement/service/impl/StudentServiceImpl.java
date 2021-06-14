/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import studentmanagement.entity.Student;
import studentmanagement.repository.StudentRepository;
import studentmanagement.service.StudentService;

/**
 *
 * @author fatem
 */
@Service
public class StudentServiceImpl implements StudentService{
private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentById(int id) {
       return studentRepository.findById(id).get();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student updateStudent(Student student) {
    return studentRepository.save(student);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStudentById(int id) {
    studentRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
