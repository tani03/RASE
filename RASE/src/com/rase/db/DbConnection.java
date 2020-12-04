package com.rase.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DbConnection {

	
	private static Connection connection=null;
	
	 public Connection get_conection() {
	
		 try {
			DriverManager.registerDriver(new OracleDriver());
			connection=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
		 return connection;
	 }
}
