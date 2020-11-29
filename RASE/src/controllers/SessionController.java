package controllers;

import interfaces.IUser;
import model.Student;

public class SessionController implements IUser {
	ModelServiceController modelServiceController;
	
	public SessionController() {
		modelServiceController = new ModelServiceController();
	}

	@Override
	public boolean registerUser(String userName, String password) {
		if(!modelServiceController.emailExists(userName)) {
			Student user = new Student();
			modelServiceController.saveUser(user);	
			return true;
		}
		return false;
	}

	@Override
	public boolean loginUser(String userName, String password) {
		
		return false;
	}

	@Override
	public boolean logout() {
		return true;
	}

}
