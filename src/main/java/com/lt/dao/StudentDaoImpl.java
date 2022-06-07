package com.lt.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constant.JDBCTemplateSQLConstants;
import com.lt.dto.RegisteredCourse;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.RegisterCourseMapper;

@Repository
public class StudentDaoImpl implements StudentDaoInterface {

	// create the reference of looger here

	Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Transactional
	@Override
	public void registerStudent(Integer studentId,String studentName) {

		String SQL = "insert into student (studentId, studentName) values (?,?)";

		jdbcConfiguration.jdbcTemplate().update(SQL,studentId, studentName);

		System.out.println("Created Record Name = " + studentName + " ID = " + studentId );

	}

	@Transactional
	@Override
	public void registerCourse(String courseCode, Integer semster, Integer studentId, int marks) {
		String SQL = "insert into RegisteredCourse (courseCode, semster, studentId, marks) values (?,?,?,?)";

		jdbcConfiguration.jdbcTemplate().update(SQL, courseCode, semster, studentId, marks);

		System.out.println("Created Record CourseCode = " + courseCode + " Semester = " + semster + " StudentID = "
				+ studentId + " MArks = " + marks);

	}
	
	@Transactional
	@Override
	public List<String> viewRegisterCourse(int studentId) {

		List<RegisteredCourse> course=jdbcConfiguration.jdbcTemplate().query(JDBCTemplateSQLConstants.GET_REGISTERD_COURSE,new Object[] {studentId}, new RegisterCourseMapper());
		List<String> st=new ArrayList<String>();
		for(RegisteredCourse cs:course) {
			st.add(cs.getCourseCode());
		}
		return st;
	}

}
