package com.lt.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.AdminDaoImpl;
import com.lt.dto.Course;
import com.lt.dto.Professor;
import com.lt.dto.Report;
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
public class AdminController {

	@Autowired
	private AdminDaoImpl adminadminDao;

	List<Course> pl = new ArrayList<Course>();
	private static final Logger logger=LoggerFactory.getLogger(AdminDaoImpl.class);

	
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewStudents/{id}")
	@ResponseBody
	public ResponseEntity<Student> viewStudents(@PathVariable("id") int id) {

		adminadminDao.getStudent(id);
		return new ResponseEntity<Student>(adminadminDao.getStudent(id),HttpStatus.OK);

	}

}
