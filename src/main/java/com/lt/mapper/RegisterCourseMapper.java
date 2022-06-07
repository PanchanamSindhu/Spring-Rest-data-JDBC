package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.lt.dto.RegisteredCourse;

public class RegisterCourseMapper implements RowMapper<RegisteredCourse> {

	@Override
	public RegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		RegisteredCourse registeredCourse = new RegisteredCourse();
		registeredCourse.setCourseCode(rs.getString("courseCode"));
		registeredCourse.setStudentId(rs.getInt("studentId"));
		registeredCourse.setMarks(rs.getInt("marks"));
		registeredCourse.setSemster(rs.getInt("semster"));
		return registeredCourse;
	}
}
