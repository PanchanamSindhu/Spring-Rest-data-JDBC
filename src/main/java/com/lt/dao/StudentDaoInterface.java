package com.lt.dao;

import java.util.List;
import java.util.Map;

/**
 * Interface class that has the following methods.
 * 
 * @author Group5
 * @since 05-31-2022
 */
public interface StudentDaoInterface {

	public void registerStudent(Integer studentId,String studentName);

	public void registerCourse(String courseCode, Integer semster, Integer studentId, int marks);

	public List<String> viewRegisterCourse(int studentId);

	public void removeCourse(String courseCode);

	public Map<String, String> viewCatalog();

	

}
