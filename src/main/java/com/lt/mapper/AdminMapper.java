package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Admin;


public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		
		return admin;
	}

}
