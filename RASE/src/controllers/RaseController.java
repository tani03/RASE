package controllers;

public class RaseController {
	SessionController session;
	
	public RaseController(SessionController session) {
		this.session = session;
	}
	
	public boolean registerUser(String userName, String password) {
		return session.registerUser(userName, password);
	}
	
	public boolean loginUser(String userName, String password) {
		return session.loginUser(userName, password);
	}
	
	
}
