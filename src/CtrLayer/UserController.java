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
public class UserController implements IFUserController {

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#addCustomer(int, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void addCustomer(int id, String handle, String name,
			String password, boolean isAdmin) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#addTeamToUser(ModelLayer.Team)
	 */
	@Override
	public void addTeamToUser(Team team) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#updateUser(int, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public int updateUser(int id, String handle, String name, String password,
			boolean isAdmin) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#deleteUser(int)
	 */
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see CtrLayer.IFUserController#getAllUsers()
	 */
	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
