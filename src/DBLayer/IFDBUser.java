package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBUser {

	// get all users
	public ArrayList<User> getAllUsers();

	// get one user by handle
	public User findUserByHandle(String handle);

	// find one user by name
	public User findUserByName(String name);

	// insert new user
	public int insertUser(User user) throws Exception;

	// update user
	public int updateUser(User user);

	// Delete User
	public int deleteUser(int id);
}