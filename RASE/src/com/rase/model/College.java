package com.rase.model;

import java.util.ArrayList;

public class College {
	protected int collegeId;
	protected String collegeName;
	protected String address;
	//protected ArrayList<Course> courses;//either arraylist of courses or courseid?
	
	public int getCollegeId() {
		return collegeId;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	
	public void setCollegeId(int collegeId) {
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
	
}
