package com.rase.model;

import java.sql.Date;

public class Student{
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private int rollNumber;
	private Date courseStartDate;
	private Date courseEndDate;
	protected Course course;
	protected College college;//either college object or just college id
	
	public int getRollNumber() {
		return rollNumber;
	}
	public Date getCourseStartDate() {
		return courseStartDate;
	}
	public Date getCourseEndDate() {
		return courseEndDate;
	}
	public College getCollege() {
		return college;
	}
	public Course getCourse() {
		return course;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}
