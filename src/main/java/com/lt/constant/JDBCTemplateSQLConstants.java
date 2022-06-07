package com.lt.constant;

public class JDBCTemplateSQLConstants {

	public static final String GET_STUDNET_SQL = "select * from student where studentId = ?";
	public static final String ADD_COURSE_SQL = "insert into course (courseCode, courseName, isOffered, instructor) values (?,?,?,?)";
	public static final String GET_COURSE_SQL = "select * from course";
	public static final String DELETE_COURSE_SQL = "delete from course where courseCode = ?";
	public static final String ADD_PROFESSOR_SQL = "insert into professor (profId, profName, department, designation) values (?,?,?,?)";

	public static final String GET_REGISTERD_COURSE = "SELECT * " + "FROM RegisteredCourse "
			+ "INNER JOIN student ON (student.studentId=RegisteredCourse.studentId) " + "WHERE student.studentId = ? ";

	public static final String DELETE_REG_COURSE_SQL = "delete from RegisteredCourse where courseCode = ?";
	public static final String STUDENT_INSERT_SQL = "insert into student (studentId, studentName) values (?,?)";
	public static final String STUDENT_REGISTER_COURSE = "insert into RegisteredCourse (courseCode, semster, studentId, marks) values (?,?,?,?)";
}
