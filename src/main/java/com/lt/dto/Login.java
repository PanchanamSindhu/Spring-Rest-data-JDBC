/**
 * 
 */
package com.lt.dto;

import java.io.Serializable;

/**
 * @author user209
 *
 */
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String role;
	private String userName;
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
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
	/**
	 * @return the type
	 */
	public String getType() {
		return role;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String role) {
		this.role = role;
	}
	
	
	
	
}
