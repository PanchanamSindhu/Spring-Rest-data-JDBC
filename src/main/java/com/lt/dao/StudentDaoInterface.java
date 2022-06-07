package com.lt.dao;


/**
 * Interface class that has the following methods.
 * 
 * @author Group5
 * @since 05-31-2022
 */
public interface StudentDaoInterface {

	public void registerStudent(Integer studentId,String studentName);

	public void registerCourse(String courseCode, Integer semster, Integer studentId, int marks);

	

}
