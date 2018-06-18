package com.myproject.shoppingcart.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name="user")
public class User {

	@Id
	@Email
	private String emailID;
	@NonNull
	private String password;

	private String mobile;
	@NonNull
	private String fullname;
	@NonNull
	private String role;
	@NonNull
	private Date registeredDate;
	private boolean enabled;
	
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date date) {
		this.registeredDate = date;
	}
	

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
