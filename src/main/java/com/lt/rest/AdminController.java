package com.lt.rest;

import java.util.List;

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
import com.lt.dto.Course;
import com.lt.dto.Professor;
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
	private AdminDaoImpl adminDao;
	
	private static final Logger logger=LoggerFactory.getLogger(AdminDaoImpl.class);

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewStudents/{id}")
	@ResponseBody
	public ResponseEntity<Student> viewStudents(@PathVariable("id") int id) {

		adminDao.getStudent(id);
		return new ResponseEntity<Student>(adminDao.getStudent(id),HttpStatus.OK);

	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addCourse")
	@ResponseBody
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		logger.info("Inside add course method ");

		adminDao.addCourse(course.getCourseCode(),course.getCourseName(),course.getIsOffered(),course.getInstructor());
		return new ResponseEntity<String>("course added succesfully",HttpStatus.OK);

	}
	
	/**
	 * This method uses @Getmapping annotation it handles the 
	 * HTTP Post requests matched with given URI expression
	 * 
	 * @param args nothing.
	 * @return ResponseEntity<List<Course>>.
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/getCourses")
	@ResponseBody
	public ResponseEntity<List<Course>> getCourses() {
		logger.info("Inside get course details method ");

		adminDao.getCourses();
		return new ResponseEntity<List<Course>>(adminDao.getCourses(),HttpStatus.OK);

	}
	
	/**
	 * This method uses @Deletemapping annotation it handles the 
	 * HTTP Delete requests matched with given URI expression
	 * 
	 * @param args id, Coursecode.
	 * @return ResponseEntity<String>.
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/deleteCourse/{id}")
	@ResponseBody
	public ResponseEntity<String> removeCourse(@PathVariable("id") String courseCode) {
		logger.info("Inside Remove Course method ");

		adminDao.removeCourse(courseCode);
		return new ResponseEntity<String>("Course Removed Succesfully",HttpStatus.OK);

	}
	
	/**
	 * This method uses @PostMapping annotation it handles the 
	 * HTTP POST requests matched with given URI expression
	 * 
	 * @param args unused.
	 * @return ResponseEntity<List<Professor>>.
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addProf")
	@ResponseBody
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
		logger.info("Inside add Professor method ");

		adminDao.addProfessor(professor.getProfId(),professor.getProfName(),professor.getDepartment(),professor.getDesignation());
		return new ResponseEntity<String>("Professor added succesfully",HttpStatus.OK);

	}

}
