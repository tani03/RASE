package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rase.dao.DbConnection;
import com.rase.model.Students;
import com.rase.services.ModifyServices;

public class ModifyServicesImplementation  implements ModifyServices{


	private static Connection connection= DbConnection.getConnection();
	
	@Override
	public boolean updateDetails(Students students) {
		// TODO Auto-generated method stub
		
		boolean retValue =false;
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement("update students set first_name =(?), last_name= (?) ,roll_number=(?), c_start_Date=(?), c_end_Date=(?),phone_num =(?), college_id=(?) where email_id= (?)");
			
			prepStatement.setString(8, students.getEmail());
			prepStatement.setString(1, students.getFirstName());
			prepStatement.setString(2, students.getLastName());
			prepStatement.setInt(3, students.getRollNumber());
			prepStatement.setDate(4,students.getCourseStartDate());
			prepStatement.setDate(5, students.getCourseEndDate());
			prepStatement.setString(6, students.getPhone());
			prepStatement.setInt(7, students.getCollege().getCollegeId());
			
						
			
			if( prepStatement.executeUpdate() !=0) {
				retValue = true;
			}
			
			else {
				retValue = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return retValue;
	}

	@Override
	public boolean deleteDetails(String email) {
		
		
		boolean retValue =false;
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement("delete students where email_id= (?)");
			
			prepStatement.setString(1, email);
			
						
			if( prepStatement.executeUpdate() !=0) {
				retValue = true;
			}
			
			else {
				retValue = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return retValue;
	}
	

}
