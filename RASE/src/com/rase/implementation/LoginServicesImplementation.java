package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.rase.dao.DbConnection;
import com.rase.model.Admin;
import com.rase.model.College;
import com.rase.model.Students;
import com.rase.services.LoginServices;

public class LoginServicesImplementation implements LoginServices{

	private static Connection connection= DbConnection.getConnection();
	
	@Override
	public Admin adminLogin(String userName, String password) throws SQLException {

		Admin admin = null;
		
		try(PreparedStatement prepStatement =connection.prepareStatement("select * from admin where email_id = (?) AND password =(?)")) {
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			ResultSet resultset = prepStatement.executeQuery();
			if(resultset.next() ) {	
				admin = new Admin();
				admin.setEmail(resultset.getString("email_id"));
				admin.setFirstName(resultset.getString("first_name"));
				admin.setLastName(resultset.getString("last_name"));
				admin.setPhone(resultset.getString("phone_num"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
	@Override
	public Students studentLogin(String userName, String password) {
		Students students = null;
		College college = null;
		try(PreparedStatement prepStatement = connection.prepareStatement("select * from students where email_id = (?) AND password =(?)")) {
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			ResultSet resultset = prepStatement.executeQuery();
			if(resultset.next() ) {	
				students = new Students();
				college = new College();
				students.setEmail(resultset.getString("email_id"));
				students.setFirstName(resultset.getString("first_name"));
				students.setLastName(resultset.getString("last_name"));
				students.setPhone(resultset.getString("phone_num"));
				students.setRollNumber(resultset.getInt("roll_number"));
				students.setCourseStartDate(resultset.getDate("c_start_date"));
				students.setCourseEndDate(resultset.getDate("c_end_date"));
				college.setCollegeId(resultset.getInt("college_id"));
				students.setCollege(college);
//				students.setCollege.(resultset.getInt("college_id"));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	
}
