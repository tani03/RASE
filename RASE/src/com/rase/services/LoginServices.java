package com.rase.services;

import java.sql.SQLException;

import com.rase.model.Admin;
import com.rase.model.Students;

public interface LoginServices {

	Admin adminLogin(String userName, String password) throws SQLException;
	Students studentLogin(String userName, String password) throws SQLException;
	
}
