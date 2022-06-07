package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Login login = new Login();
		login.setId(rs.getInt("id"));
		login.setType(rs.getString("role"));
		login.setUserName(rs.getString("userName"));
		login.setPassword(rs.getString("password"));
		return login;

	} 
}
