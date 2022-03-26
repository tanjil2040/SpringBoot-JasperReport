/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.controller;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import studentmanagement.entity.Student;
import studentmanagement.repository.StudentRepository;
import studentmanagement.service.ReportService;

/**
 *
 * @author fatem
 */
@RestController
public class CheckApi {
   @Autowired
    private StudentRepository sr;
   @Autowired
   private ReportService service;
	
   @GetMapping("/getstudents")
public List<Student> getStudents(){
return sr.findAll();
}
   @GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	return service.exportReport(format);	
	}
}
