package controllers;

import model.DataHolder;
import model.User;

public class ModelServiceController {
	
	DataHolder data;
	
	public ModelServiceController() {
		data = new DataHolder();
	}

	public boolean saveUser(User user) {
		data.getDataHolder().put(user.getEmail(), user);
		return true;
	}
	
	public User getUser(String email) {
		return data.getDataHolder().get(email);
	}
	
	public boolean emailExists(String email) {
		return data.getDataHolder().containsKey(email);
	}
}
