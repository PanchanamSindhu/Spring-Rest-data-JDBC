package com.lt.dao;

import java.util.List;
import java.util.Map;

import com.lt.dto.Report;
import com.lt.dto.Student;

/**
 * Interface class that has the following methods.
 * 
 * @author Group5
 * @since 05-31-2022
 */
public interface StudentDaoInterface {

	
	public void create(String studentName, Integer studentId, 
			String password);



}
