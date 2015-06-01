/**
 * 
 */
package CtrLayer;

import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.User;

/**
 * @author nicklas
 *
 */
public interface IFUserController {

	/*
	 * Method to add user
	 * @param handle the Alias/nickname for the user
	 * @param name real name of the user
	 * @param password password to login with
	 * @param isAdmin to check if user is admin role
	 */
	public void addUser(String handle, String name, String password,
			boolean isAdmin) throws Exception;
	/*
	 * Method to add team to a user
	 * @param team the team user belongs to
	 */
	public void addTeamToUser(Team team);
	/*
	 * Method to find user by handle/alias
	 * @param handle to find user by
	 * @return found user
	 */
	public User findUserByHandle(String handle);
	/*
	 * Method to find user by name
	 * @param name to find user by
	 * @return found user
	 */
	public User findUser(String name);
	/*
	 * Method to find user by id
	 * @param id to find user by
	 * @return found user
	 */
	public User findUserID(int id);
	/*
	 * Method to update a user
	 * @param id for the user your updating (cant be changed, only find get the right user by)
	 * @param handle the handle you want for the user
	 * @param name the real name of your user
	 * @param password the users password
	 * @param isAdmin boolean to set admin role
	 * @return rowcount from db
	 */
	public int updateUser(int id, String handle, String name, String password,
			boolean isAdmin);
	/*
	 * Method to delete a user
	 * 
	 * @param id the id of the user you want to delete
	 * 
	 * @return a rowcount from db
	 */
	public int deleteUser(int id);
	/*
	 * Method to get all users
	 * @return Arraylist of users
	 */
	public ArrayList<User> getAllUsers();
}
