package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.lt.dto.Student;

public class StudentMapper  implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Student student = new Student();
		student.setStudentId(rs.getInt("studentId"));
		student.setStudentName(rs.getString("studentName"));
		return student;

	}

}
