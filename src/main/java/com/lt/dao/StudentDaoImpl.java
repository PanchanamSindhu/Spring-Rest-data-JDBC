package com.lt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constant.JDBCTemplateSQLConstants;
import com.lt.dto.Course;
import com.lt.dto.RegisteredCourse;
import com.lt.mapper.RegisterCourseMapper;

@Repository
public class StudentDaoImpl implements StudentDaoInterface {

	// create the reference of looger here

	Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Autowired
	AdminDaoImpl adminDaoImpl;

	@Transactional
	@Override
	public void registerStudent(Integer studentId, String studentName) {

		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.STUDENT_INSERT_SQL, studentId, studentName);

		System.out.println("Created Record Name = " + studentName + " ID = " + studentId);

	}

	@Transactional
	@Override
	public void registerCourse(String courseCode, Integer semster, Integer studentId, int marks) {

		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.STUDENT_REGISTER_COURSE, courseCode, semster,
				studentId, marks);

		System.out.println("Created Record CourseCode = " + courseCode + " Semester = " + semster + " StudentID = "
				+ studentId + " MArks = " + marks);

	}

	@Transactional
	@Override
	public List<String> viewRegisterCourse(int studentId) {

		List<RegisteredCourse> course = jdbcConfiguration.jdbcTemplate().query(
				JDBCTemplateSQLConstants.GET_REGISTERD_COURSE, new Object[] { studentId }, new RegisterCourseMapper());
		List<String> st = new ArrayList<String>();
		for (RegisteredCourse cs : course) {
			st.add(cs.getCourseCode());
		}
		return st;
	}

	@Transactional
	@Override
	public void removeCourse(String courseCode) {

		jdbcConfiguration.jdbcTemplate().update(JDBCTemplateSQLConstants.DELETE_REG_COURSE_SQL, courseCode);
		System.out.println("Deleted Record with ID = " + courseCode);
	}

	@Transactional
	@Override
	public Map<String, String> viewCatalog() {
		List<Course> courses = adminDaoImpl.getCourses();
		Map<String, String> map = new HashMap<String, String>();
		for (Course c : courses) {
			map.put(c.getCourseCode(), c.getCourseName());
		}

		return map;
	}

}
