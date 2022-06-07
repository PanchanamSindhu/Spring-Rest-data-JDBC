package com.lt.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.StudentDaoImpl;
import com.lt.dto.RegisteredCourse;
import com.lt.dto.Student;

/**
 * This is the Controller uses @RestController annotation and 
 * allows the class to handle the requests made by the client.
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

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/registerStudent")
	@ResponseBody
	public ResponseEntity<String> registerStudent(@RequestBody Student student) {

		studentDaoImpl.registerStudent( student.getStudentId(),student.getStudentName());
		return new ResponseEntity<String>("Registration Succesfull",HttpStatus.OK);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/registerCourse")
	@ResponseBody
	public ResponseEntity<String> getStudentDetails(@RequestBody RegisteredCourse registeredCourse) {

		studentDaoImpl.registerCourse(registeredCourse.getCourseCode(), registeredCourse.getSemster(),
				registeredCourse.getStudentId(), registeredCourse.getMarks());
		return new ResponseEntity<String>("Course Registration Succesfull",HttpStatus.OK);

	}

}