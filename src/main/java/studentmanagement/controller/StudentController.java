/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import studentmanagement.entity.Student;
import studentmanagement.repository.StudentRepository;
import studentmanagement.service.StudentService;

/**
 *
 * @author fatem
 */
@Controller
public class StudentController {
private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
 @GetMapping("/students")   
public String listStudents(Model model){
 model.addAttribute("students", studentService.getAllStudents());
 return "students";
}

@GetMapping("/students/new")
public String createStudentForm(Model m){
Student student = new Student();
m.addAttribute("student",student);
return "createStudent";
}
@PostMapping("/students")
public  String saveStudent(@ModelAttribute("student")Student student){
 studentService.saveStudent(student);
 return "redirect:/students";
 
}
@GetMapping("students/update/{id}")
public String updateStudent(@PathVariable int id,Model model){
    model.addAttribute("student", studentService.getStudentById(id));
return "updatestudents";    
}
@PostMapping("/students/{id}")
public String updateComplete(@PathVariable int id,
@ModelAttribute("student") Student student,Model model){
Student existStudent = studentService.getStudentById(id);
existStudent.setId(id);
existStudent.setFirstName(student.getFirstName());
existStudent.setLastName(student.getLastName());
existStudent.setEmail(student.getEmail());
studentService.updateStudent(existStudent);
return "redirect:/students";
}
@GetMapping("/students/delete/{id}")
public String deleteStudent(@PathVariable int id){
    studentService.deleteStudentById(id);
return "redirect:/students";    
}
}
