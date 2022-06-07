package com.lt.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constant.JDBCTemplateSQLConstants;
import com.lt.dto.Course;
import com.lt.dto.Student;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.StudentMapper;

@Repository
public class AdminDaoImpl implements AdminDaoInterface {
	Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	@Transactional
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub

		Student student = jdbcConfiguration.jdbcTemplate().queryForObject(JDBCTemplateSQLConstants.GET_STUDNET_SQL,
				new Object[] { id }, new StudentMapper());
		logger.debug("value", jdbcConfiguration.jdbcTemplate().queryForObject(JDBCTemplateSQLConstants.GET_STUDNET_SQL,
				new Object[] { id }, new StudentMapper()));

		logger.debug("value of student-->" + student.toString());
		return student;
	}

	/**
	 * 
	 * This method allow to add Course .
	 * return nothing
	 */
	@Override
	@Transactional
	public void addCourse(String courseCode, String courseName, String isOffered, String instructor) {

		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.ADD_COURSE_SQL, courseCode, courseName,
				isOffered, instructor);

		System.out.println("Created Record CourseCode = " + courseCode + " CourseName = " + courseName
				+ " courseOffered = " + isOffered + "instructor= " + instructor);

	}

	/**
	 * 
	 * This method allows user get course details . 
	 * return List
	 */
	@Override
	@Transactional
	public List<Course> getCourses() {

		List<Course> course = jdbcConfiguration.jdbcTemplate().query(JDBCTemplateSQLConstants.GET_COURSE_SQL,
				new CourseMapper());
		logger.debug("value of student-->" + course.toString());
		return course;

	}

	/**
	 * 
	 * This method allows user to remove course . 
	 * return List
	 */
	@Override
	@Transactional
	public void removeCourse(String courseCode) {
		
		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.DELETE_COURSE_SQL, courseCode);
		System.out.println("Deleted Record with ID = " + courseCode);
	}

	/**
	 * 
	 * This method allows user to add professor . 
	 * return List
	 */
	@Override
	@Transactional
	public void addProfessor(int profId, String profName, String department, String designation) {

		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.ADD_PROFESSOR_SQL, profId, profName, department, designation);

		System.out.println("Created Record ProfessorID = " + profId + " ProfessorName = " + profName + " Department = "
				+ department + "Designation= " + designation);
		logger.info("Professor added succesfully ");

	}

}
