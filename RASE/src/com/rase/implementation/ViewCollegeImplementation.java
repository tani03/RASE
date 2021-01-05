package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rase.dao.DbConnection;
import com.rase.model.College;
import com.rase.model.Course;

import com.rase.services.ViewCollegeServices;

public class ViewCollegeImplementation implements ViewCollegeServices {
	
	private static Connection connection= DbConnection.getConnection();

	
	@Override
	public ArrayList<College> sendCollege() {
		ArrayList<College> list = new ArrayList<College>();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select cg.college_id,name,cr.course_id,course_name,c_duration from college cg,course cr,courses_in_college crg where cg.college_id=crg.college_id and cr.course_id=crg.course_id order by college_id");
			
		
			ResultSet resultSet=prepStatement.executeQuery();
		
			while(resultSet.next()) {
				College college=new College();
				college.setCollegeId(resultSet.getInt(1));
			
				college.setCollegeName(resultSet.getString(2));
				Course course=new Course();
				course.setCourseId(resultSet.getString(3));
				course.setCourseName(resultSet.getString(4));
				course.setCourseDurationYears(resultSet.getInt(5));
				
				list.add(college);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<College> sendCollegeList(){
		ArrayList<College> list = new ArrayList<College>();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select college_id,name,college_address from college  order by name");
			
		
			ResultSet resultSet=prepStatement.executeQuery();
			
			while(resultSet.next()) {
				College college=new College();
				college.setCollegeId(resultSet.getInt(1));
			
				college.setCollegeName(resultSet.getString(2));
				college.setCollegeAddress(resultSet.getString(3));
				
				list.add(college);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public ArrayList<Course> sendCourseListOfCollege(int collegeId){
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("Select course_name from course cr,courses_in_college cg where cg.course_id=cr.course_id and cg.course_id=cr.course_id and college_id=(?)");
			
		
			ResultSet resultSet=prepStatement.executeQuery();
			
			while(resultSet.next()) {
				Course course=new Course();
				course.setCourseId(resultSet.getString(3));
				course.setCourseName(resultSet.getString(4));
				course.setCourseDurationYears(resultSet.getInt(5));
				list.add(course);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	
	

}
