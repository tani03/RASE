package interfaces;

public interface IUser {
	boolean registerUser(String userName, String password);
	boolean loginUser(String userName, String password);
	boolean logout();
}