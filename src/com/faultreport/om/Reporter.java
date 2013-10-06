package com.faultreport.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="reporters")
public class Reporter {
	@Id
	private int userId;
	
	@Column (name="username")
	private String userName;
	
	@Column (name="password")
	private String password;
	
	@Column (name="role")
	private Role role;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	enum Role{
		reguler,
		admin
	}

}
