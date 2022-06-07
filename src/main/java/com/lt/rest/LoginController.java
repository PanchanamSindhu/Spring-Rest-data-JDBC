package com.lt.rest;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.AdminDaoImpl;
import com.lt.dao.LoginDaoImpl;
import com.lt.dto.Login;

@RestController
@CrossOrigin
public class LoginController {
	

	@Autowired
	private LoginDaoImpl loginDaoImpl;
	
	private static final Logger logger=LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/login")
	@ResponseBody
	public ResponseEntity<String> addCourse(@RequestBody Login login) {
		logger.info("Inside Login method ");

		loginDaoImpl.loginUser(login);
		return new ResponseEntity<String>("LoggedIn succesfully",HttpStatus.OK);

	}

}
