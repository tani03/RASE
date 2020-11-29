package model;

import java.time.LocalDate;

public class Student extends User{
	private int rollNumber;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	
	protected College college;//either college object or just college name
	
	public int getRollNumber() {
		return rollNumber;
	}
	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}
	public LocalDate getCourseEndDate() {
		return courseEndDate;
	}
	public College getCollege() {
		return college;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public void setCourseEndDate(LocalDate courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}
