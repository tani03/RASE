package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rase.dao.DbConnection;
import com.rase.model.College;
import com.rase.model.Course;

public class ViewCourse {
	

	private static Connection connection= DbConnection.getConnection();
	public ArrayList<Course> sendCourseList(){
	ArrayList<Course> list = new ArrayList<Course>();
	try {
		PreparedStatement prepStatement = connection.prepareStatement("select * from course");
		
		
		ResultSet resultset = prepStatement.executeQuery();
		
		
		
		while(resultset.next() ) {
			Course course=new Course();
			course.setCourseId(resultset.getString("course_id"));
			course.setCourseName(resultset.getString("course_name"));
			course.setCourseDurationYears(resultset.getInt("c_duration"));
			
			list.add(course);
		}
			
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return list;

}
}
