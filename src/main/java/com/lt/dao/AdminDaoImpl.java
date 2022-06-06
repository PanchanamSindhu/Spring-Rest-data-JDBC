package com.lt.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lt.configuration.JDBCConfiguration;
import com.lt.dto.Student;
import com.lt.mapper.StudentMapper;

@Repository
public class AdminDaoImpl implements AdminDaoInterface {

	// create the reference of looger here

	Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub

		String SQL = "select * from student where studentId = ?";
		Student student = jdbcConfiguration.jdbcTemplate().queryForObject(SQL, new Object[] { id },
				new StudentMapper());
		logger.debug("value",
				jdbcConfiguration.jdbcTemplate().queryForObject(SQL, new Object[] { id }, new StudentMapper()));

		logger.debug("value of student-->" + student.toString());
		return student;
	}

}
