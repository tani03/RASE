package com.rase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DbConnection {

	
	private static Connection connection=null;
	
	 public static Connection getConnection() {
	
		 try {
			DriverManager.registerDriver(new OracleDriver());
			connection=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rase", "rase");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return connection;
	 }
}
