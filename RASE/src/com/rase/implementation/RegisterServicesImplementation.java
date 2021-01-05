package com.rase.implementation;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rase.dao.DbConnection;
import com.rase.model.Admin;
import com.rase.model.Course;
import com.rase.model.Students;
import com.rase.services.RegisterServices;

public class RegisterServicesImplementation  implements RegisterServices{

	
	
	private static Connection connection= DbConnection.getConnection();
	
	
	
	@Override
	public boolean checkEmailExist(String email) {
		
		boolean returnValue = false;
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select email_id from students where email_id = (?)");
			prepStatement.setString(1, email);
			ResultSet resultset = prepStatement.executeQuery();
			
			if(resultset.next() ) {	
				returnValue=true;
			}
			else {
				returnValue=false;
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	@Override
	public boolean checkDuration(Course course,Students st) {
		boolean retVal=false;
		String s1 = null;
		PreparedStatement prepStatement,prepStatement2;
		try {
			prepStatement = connection.prepareStatement("select c_duration from course where course_id=?");
			prepStatement.setString(1, course.getCourseId());
			
			
			prepStatement.executeUpdate();
		
			long diff =  st.getCourseEndDate().getTime() - st.getCourseStartDate().getTime();
	        int cday = (int) (diff / (1000 * 60 * 60 * 24));
	        int c1=Math.round((cday/365));
	        
			ResultSet resultSet = prepStatement.executeQuery();
			
			if(resultSet.next() )
			s1=resultSet.getString("c_duration");
			
			int c2=Integer.parseInt(s1);
				
			if(c1==c2) {
				retVal=true;
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return retVal;
	}
	
	@Override
	public boolean registerStudents(Students students) {
		
		
		boolean retValue =false;
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement("insert into students values (?,?,?,?,?,?,?,?,?,?)");
			prepStatement.setString(1, students.getEmail());
			prepStatement.setString(2, students.getFirstName());
			prepStatement.setString(3, students.getLastName());
			prepStatement.setInt(4, students.getRollNumber());
			prepStatement.setDate(5,students.getCourseStartDate());
			prepStatement.setDate(6, students.getCourseEndDate());
			prepStatement.setString(7, students.getPhone());
			prepStatement.setInt(8, students.getCollege().getCollegeId());
			prepStatement.setString(9, students.getPassword());
			prepStatement.setString(10, students.getCourse().getCourseId());
			
			
			
			if( prepStatement.executeUpdate() !=0) {
				
				
				retValue = true;
			}
			
			else {
				
				
				retValue = false;
			}
			
			connection.close();	
			
		} catch (SQLException e) {
		
		
			e.printStackTrace();
		}
		
		return retValue;
	}

	

}
