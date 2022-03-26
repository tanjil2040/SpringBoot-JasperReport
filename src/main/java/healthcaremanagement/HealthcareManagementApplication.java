package studentmanagement;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.sf.jasperreports.engine.JRException;
import studentmanagement.controller.CheckApi;
import studentmanagement.entity.Student;
import studentmanagement.repository.StudentRepository;
import studentmanagement.service.ReportService;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner{
	

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
        

    @Override
    public void run(String... args) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  Student student1 = new Student(2,"SSS","ttt","h@f.g");
//  studentRepository.save(student1);
    }

}
