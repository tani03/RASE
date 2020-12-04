package com.rase.model;

import java.util.ArrayList;

public class College {
	protected String collegeId;
	protected String collegeName;
	protected String address;
	protected ArrayList<Course> courses;//either arraylist of courses or courseid?
	
	public String getCollegeId() {
		return collegeId;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
}
