package com.rase.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rase.interfaces.IDBService;
import com.rase.model.User;

public class IDBImplement  implements IDBService{

	
	DbConnection dbcon = new DbConnection();
	
	Connection connection= dbcon.get_conection();
	
	
	@Override
	public boolean createUser(User user) {
		
		boolean returnValue = false;
		try {
			PreparedStatement prepStatement = connection.prepareStatement("insert into students values (?,?,?,?)");
			prepStatement.setString(1, user.getEmail());
			prepStatement.setString(2, user.getFirstName());
			prepStatement.setString(3, user.getPhone() );
			prepStatement.setString(4,user.getPassword());
			
			if(prepStatement.executeUpdate() !=0) {	
				returnValue = true;	
			}
			else {
				returnValue =false;
			}
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return returnValue;
	}

		
	@Override
	public boolean emailExists(String email) {
		
		boolean returnValue = false;
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select * from students where email_id = (?)");
			prepStatement.setString(1, email);
			ResultSet resultset = prepStatement.executeQuery();
			
			if(resultset.next() ) {	
				returnValue=true;
			}
			else {
				returnValue=false;
			}
			connection.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	
	@Override
	public User getUser(String email) {
		
		User user = new User();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("select * from students where email_id = (?)");
			prepStatement.setString(1, email);
			ResultSet resultset = prepStatement.executeQuery();
			
			if(resultset.next() ) {	
				
				user.setFirstName(resultset.getString("first_name"));
				user.setEmail(resultset.getString("email_id"));
				user.setPhone(resultset.getString("phone"));
				
				
			}
			else {
				user = null;
			}
			connection.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return user;
	}

}
