package com.fb.model;

import java.util.Date;

import com.fb.constants.Constants;

public class UserMo {
	
	private String fullName;
	private int userId;
	private String email;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	private String password;
	private String mobileNumber;
	private Date dob;
	private String aadharNumber;
	private String gender;
	private String role;
	public String getGender() {
		return gender;
	}
	public String getRole() {
		return role;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setRole(String role) {
		this.role =role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public UserMo(String fullName,String email, String password, String mobileNumber, Date dob, String aadharNumber,String gender) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.aadharNumber = aadharNumber;
		this.gender = gender;
	}
	
	public UserMo()
	{
		//this.role="Customer";
		setRole("Customer");
	}
	public UserMo(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}
	public UserMo(String fullname,String email,int userId)
	{
		this.fullName=fullname;
		this.email=email;
		this.userId = userId;
	}
	
	public UserMo(String fullname,String email,String mobilenumber,String role)
	{
		this.fullName=fullname;
		this.email=email;
		this.mobileNumber=mobilenumber;
		this.role=role;
	}
	
	
	

}
