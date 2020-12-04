package com.rase.interfaces;

import com.rase.model.User;

public interface IDBService {

	public boolean createUser(User user); // return true if record is inserted without any exception. else false
	public boolean emailExists(String email); // return true if email already exists in DB, else return false 
	public User getUser(String email); // email is our primary key, fetch records from database, return null if not found
}
