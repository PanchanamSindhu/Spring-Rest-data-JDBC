package com.lt.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.dto.Login;
import com.lt.exception.UserNameAndPasswordNotValid;
import com.lt.mapper.LoginMapper;

@Repository
public class LoginDaoImpl implements LoginDaoInterface {

	Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Transactional
	@Override
	public List<Login> viewLoginList() {
		String SQL = "select * from login";
		List<Login> loginList = jdbcConfiguration.jdbcTemplate().query(SQL, new LoginMapper());
		logger.debug("value of login-->" + loginList.toString());
		return loginList;

	}

	/**
	 * 
	 * This method allows user login application . 
	 * return List
	 */
	@Transactional
	@Override
	public String loginUser(Login login) {
		List<Login> loginType = viewLoginList();

		List<Login> lg = loginType.stream().filter(n -> ((n.getId() == login.getId())
				&& (n.getUserName().equals(login.getUserName())) && (n.getPassword().equals(login.getPassword()))))
				.collect(Collectors.toList());
		if (lg.size() != 0) {
			logger.info("Logging in :" + login.getUserName());
			return "Login Succesfull";

		} else {
			logger.error("Error in logginng in :" + login.getUserName());
			throw new UserNameAndPasswordNotValid("Please Enter valid UserName/Passwor");

		}
		
	}

}
