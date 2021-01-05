package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rase.dao.DbConnection;
import com.rase.model.College;
import com.rase.model.Students;
import com.rase.services.SearchAlumniServices;


public class SearchAlumniServicesImplementation  implements  SearchAlumniServices{

	
	
	private static Connection connection= DbConnection.getConnection();
	
	@Override
	public ArrayList<Students> search(String firstName) {
		ArrayList <Students> list = new ArrayList<Students>();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select * from students s, college c where first_name = initcap(?) and c.college_id=s.college_id");
			
			prepStatement.setString(1, firstName);
			
			ResultSet resultset = prepStatement.executeQuery();
			
			
			
			while(resultset.next() ) {
				Students students=new Students();
				College college = new College(); 
				students.setFirstName(resultset.getString("first_name"));
				students.setLastName(resultset.getString("last_name"));
				students.setEmail(resultset.getString("email_id"));
				students.setPhone(resultset.getString("phone_num"));
				students.setRollNumber(resultset.getInt("roll_number"));
				college.setCollegeName(resultset.getString("Name"));
				students.setCollege(college);
				list.add(students);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Students searchStudent(String email) {
		
		Students students=new Students();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select * from students s, college c where email_id = lower(?) and c.college_id= s.college_id");
			
			prepStatement.setString(1, email);
			
			ResultSet resultset = prepStatement.executeQuery();
			
			
			
			if(resultset.next() ) {
				
				College college = new College(); 
				students.setFirstName(resultset.getString("first_name"));
				students.setLastName(resultset.getString("last_name"));
				students.setEmail(resultset.getString("email_id"));
				students.setPhone(resultset.getString("phone_num"));
				students.setRollNumber(resultset.getInt("roll_number"));
				college.setCollegeName(resultset.getString("Name"));
				college.setCollegeId(resultset.getInt("college_id"));
				students.setCollege(college);
				students.setCourseStartDate(resultset.getDate("c_start_date"));
				students.setCourseEndDate(resultset.getDate("c_end_date"));
				
				
				
			}
			else {
				students=null;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}
