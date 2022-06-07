package com.lt.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.AdminDaoImpl;
import com.lt.dao.StudentDaoImpl;
import com.lt.dto.RegisteredCourse;
import com.lt.dto.Student;

/**
 * This is the Controller uses @RestController annotation and allows the class
 * to handle the requests made by the client.
 * 
 * @param args unused.
 * @return Nothing.
 * 
 */
@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/registerStudent")
	@ResponseBody
	public ResponseEntity<String> registerStudent(@RequestBody Student student) {

		studentDaoImpl.registerStudent(student.getStudentId(), student.getStudentName());
		return new ResponseEntity<String>("Registration Succesfull", HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/registerCourse")
	@ResponseBody
	public ResponseEntity<String> getStudentDetails(@RequestBody RegisteredCourse registeredCourse) {

		studentDaoImpl.registerCourse(registeredCourse.getCourseCode(), registeredCourse.getSemster(),
				registeredCourse.getStudentId(), registeredCourse.getMarks());
		return new ResponseEntity<String>("Course Registration Succesfull", HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/studentregistredCourse/{id}")
	@ResponseBody
	public ResponseEntity<List<String>> getStudentRegiCourse(@PathVariable("id") int studentId) {

		List<String> regList = studentDaoImpl.viewRegisterCourse(studentId);
		return new ResponseEntity<List<String>>(regList, HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/courseDelete/{id}")
	@ResponseBody
	public ResponseEntity<String> removeCourse(@PathVariable("id") String courseCode) {
		logger.info("Inside Remove Course method ");

		studentDaoImpl.removeCourse(courseCode);
		return new ResponseEntity<String>("Course Removed Succesfully", HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewCatalog")
	@ResponseBody
	public ResponseEntity<Map<String, String>> viewCatalog() {
		logger.info("Inside  Catalog viewing  method ");
		studentDaoImpl.viewCatalog();
		return new ResponseEntity<Map<String, String>>(studentDaoImpl.viewCatalog(), HttpStatus.OK);

	}

}