package com.rase.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rase.dao.DbConnection;
import com.rase.model.College;
import com.rase.model.Course;
import com.rase.services.AdminCollegeServices;

public class AdminCollegeServicesImplementation implements AdminCollegeServices {

	private static Connection connection= DbConnection.getConnection();
	
	@Override
	public boolean checkCollegeNameExists(String collegeName,int collegeId) {
		boolean retValue=false;
		try {
			PreparedStatement prepStatement=connection.prepareStatement("SELECT name from college where name=(?) or college_id=(?)");
			prepStatement.setString(1, collegeName);
			prepStatement.setLong(2, collegeId);
			ResultSet resultset = prepStatement.executeQuery();
			
			if(resultset.next() ) {	
				System.out.println("Executed");
				retValue=true;
			}
			else {
				System.out.println("Not Executed");
				retValue=false;
			}
			
		} catch (SQLException e) {
			System.out.println("Exception in sql in checkCollegeExists method");
			e.printStackTrace();
		}
		
		return retValue;
	}

	@Override
	public boolean addCollegeDetails(College college,Course course) {
		boolean retVal=false;
		
		try{
			/*
			 * CallableStatement cs = connection.prepareCall("{call GET_COLLEGE_SEQ}");
			 * 
			 * cs.execute(); int collegeId = cs.getInt(1);
			 * System.out.println("College id generated "+collegeId);
			 */
			
			
			
			//college.setCollegeId(collegeId);
			
			PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO college VALUES(?,?,?)");
			prepStatement.setLong(1,college.getCollegeId());
			prepStatement.setString(2,college.getCollegeName());
			prepStatement.setString(3, college.getCollegeAddress());
			/*
			 * PreparedStatement prepStatement2 =
			 * connection.prepareStatement("INSERT INTO courses_in_college VALUES(?,?)");
			 * prepStatement2.setString(1, course.getCourseId()); prepStatement2.setLong(2,
			 * college.getCollegeId());
			 */
			
			if (prepStatement.executeUpdate() != 0 /* && prepStatement2.executeUpdate() !=0 */) {
				System.out.println("Database of college and courseId updated");
				retVal=true;
			}
			else {
				System.out.println("Database not executed");
				retVal=false;
			}
			connection.close();
		
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return retVal;
	}

	@Override
	public boolean removeCollege(int collegeId) {
		boolean retVal=false;
		PreparedStatement studentdel,coursedel,collegedel;
		try {
			studentdel=connection.prepareStatement("DELETE FROM students WHERE college_id = ?");
			coursedel = connection.prepareStatement("DELETE FROM courses_in_college WHERE college_id = ?");
			collegedel=connection.prepareStatement("DELETE FROM college WHERE college_id = ?");
			System.out.println("Inside removeCollege()");
			studentdel.setInt(1,collegeId);
			coursedel.setInt(1,collegeId);
			collegedel.setInt(1,collegeId);
			
			
			
			if(studentdel.executeUpdate()!=0) {
				if(coursedel.executeUpdate()!=0) {
					if(collegedel.executeUpdate()!=0) {
					//	connection.commit();
						
						retVal= true;
					}else {
						//connection.rollback();
						
					}
					
					}else {
						//connection.rollback();
						
						retVal= false;
				}
				
			}else {
				//connection.rollback();
				
				retVal= false;
			}
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	

	

}
