package com.lt.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.dto.Report;
import com.lt.dto.Student;
import com.lt.mapper.StudentMapper;

@Repository
public class StudentDaoImpl implements StudentDaoInterface {

	// create the reference of looger here

	Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Transactional
	@Override
	public void create(String studentName, Integer studentId, String password) {

		String SQL = "insert into student (studentName, studentId, password) values (?,?,?)";

		jdbcConfiguration.jdbcTemplate().update(SQL, studentName, studentId, password);

		System.out.println("Created Record Name = " + studentName + " ID = " + studentId + " password = " + password);

	}

}
