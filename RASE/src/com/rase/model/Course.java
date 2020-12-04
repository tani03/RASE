package com.rase.model;

public class Course {
	String courseId;
	String courseName;
	int courseDurationYears;
	public String getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCourseDurationYears() {
		return courseDurationYears;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseDurationYears(int courseDurationYears) {
		this.courseDurationYears = courseDurationYears;
	}
}
