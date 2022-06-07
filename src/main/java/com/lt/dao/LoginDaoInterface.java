package com.lt.dao;

import java.util.List;

import com.lt.dto.Login;

public interface LoginDaoInterface {
	
	public List<Login> viewLoginList();
	public String loginUser(Login login);

}
