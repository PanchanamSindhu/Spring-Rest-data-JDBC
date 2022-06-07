package com.lt.dto;

import java.io.Serializable;

public class RegisteredCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseCode;
	private int semster;
	private int studentId;
	private int marks;

	
	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	
	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Integer getSemster() {
		return semster;
	}

	public void setSemster(Integer semster) {
		this.semster = semster;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}
