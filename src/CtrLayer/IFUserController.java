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

	public void addCustomer(int id, String handle, String name, String password,
			boolean isAdmin) throws Exception;
	
	public void addTeamToUser(Team team);
	
	public User findUser(String name);

	public int updateUser(int id, String handle, String name, String password,
			boolean isAdmin);
	
	public int deleteUser(int id);
	
	public ArrayList<User> getAllUsers();
}
