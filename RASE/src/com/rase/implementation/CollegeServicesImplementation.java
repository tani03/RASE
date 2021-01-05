package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rase.dao.DbConnection;
import com.rase.model.College;


public class CollegeServicesImplementation {

	
	private static Connection connection= DbConnection.getConnection();

	public ArrayList<College> viewAllCollege() {
		
		System.out.println("Call Success");
		ArrayList <College> list = new ArrayList<College>();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select * from college");
			
			
			ResultSet resultset = prepStatement.executeQuery();
			
			
			
			while(resultset.next() ) {
				College college = new College(); 
				college.setCollegeId(resultset.getInt("college_id"));
				college.setCollegeName(resultset.getString("name"));
				college.setCollegeAddress(resultset.getString("college_address"));
				System.out.println(resultset.getString("name"));
				list.add(college);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}


