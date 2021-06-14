package studentmanagement.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import studentmanagement.entity.Student;
import studentmanagement.repository.StudentRepository;

@Service
public class ReportService {
	@Autowired
	public StudentRepository sr;
public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	String path = "D:\\1257568\\Report";
List<Student> students = sr.findAll();
File file = ResourceUtils.getFile("classpath:Student.jrxml");
JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(students);
Map<String,Object> parameters = new HashMap<>();
parameters.put("createdBy", "Tanjil");
JasperPrint jsprint = JasperFillManager.fillReport(jasper, parameters, datasrc);
if(reportFormat.equalsIgnoreCase("html")) {
	JasperExportManager.exportReportToHtmlFile(jsprint, path+"\\Student.html");	
}
if(reportFormat.equalsIgnoreCase("pdf")) {
JasperExportManager.exportReportToHtmlFile(jsprint, path+"\\Student.pdf");	
}
return "report generated "+path;
}
}
