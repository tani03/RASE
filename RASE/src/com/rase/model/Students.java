package com.rase.model;

import java.sql.Date;
import java.util.ArrayList;


public class Students {

	
	private String email;
	private String firstName;
	private String lastName;
	private int rollNumber;
	private Date courseStartDate;
	private Date courseEndDate;
	private String phone;
	private College college;
	private Course course;
	private String password;
	private ArrayList <Events> events;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public Date getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public Date getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Events> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Events> events) {
		this.events = events;
	}
	
	
	
	
	
	
	
}
