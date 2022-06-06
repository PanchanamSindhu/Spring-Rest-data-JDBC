package com.lt.dao;

import java.util.List;

import com.lt.dto.Course;
import com.lt.dto.Professor;
import com.lt.dto.Report;
import com.lt.dto.Student;


/**
 * Interface class that has the following methods.
 * 
 * @author Group5
 * @since 05-31-2022
 */
public interface AdminDaoInterface {

	public Student getStudent(Integer id);

	
}
