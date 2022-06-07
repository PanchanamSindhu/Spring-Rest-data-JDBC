package com.lt.constant;

public class JDBCTemplateSQLConstants {

	public static final String GET_STUDNET_SQL = "select * from student where studentId = ?";
	public static final String ADD_COURSE_SQL = "insert into course (courseCode, courseName, isOffered, instructor) values (?,?,?,?)";
	public static final String GET_COURSE_SQL = "select * from course";
	public static final String DELETE_COURSE_SQL = "delete from course where courseCode = ?";
	public static final String ADD_PROFESSOR_SQL = "insert into professor (profId, profName, department, designation) values (?,?,?,?)";

}
