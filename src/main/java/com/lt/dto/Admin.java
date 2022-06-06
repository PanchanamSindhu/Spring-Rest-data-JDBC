package com.lt.dto;

/** Represents an Admin.
 * @author group5
 
*/
public class Admin {

	private String department;
	private String designation;
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Gets the admin's department.
	 * @return A string representing the admin's department
	 *     name.
	*/
	public String getDepartment() {
		return department;
	}
	
	/** Sets the admin's department.
	 * @param department A String containing the admin's
	 *     department name.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}

	/** Gets the admin's designation.
	 * @return A string representing the admin's designation
	 *     name.
	*/
	public String getDesignation() {
		return designation;
	}

	/** Sets the admin's designation.
	 * @param department A String containing the admin's
	 *     designation name.
	*/
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
