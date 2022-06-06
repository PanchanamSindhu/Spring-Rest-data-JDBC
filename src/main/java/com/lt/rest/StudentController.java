package com.lt.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.StudentDaoImpl;
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

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/student")
	@ResponseBody
	public void getStudentDetails(@RequestBody Student student) {

		studentDaoImpl.create(student.getStudentName(), student.getStudentId(), student.getPassword());

	}

	

}