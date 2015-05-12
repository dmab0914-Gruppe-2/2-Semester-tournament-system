package CtrLayer;

import java.util.ArrayList;

import DBLayer.DBUser;
import DBLayer.IFDBUser;
import ModelLayer.Team;
import ModelLayer.User;

public class UserController implements IFUserController {

	@Override
	public void addCustomer(int id, String handle, String name,
			String password, boolean isAdmin) throws Exception {
		User user = new User();
		user.setHandle(handle);
		user.setName(name);
		user.setPassword(password);
		user.setAdmin(isAdmin);

		try {
			IFDBUser dbUser = new DBUser();
			dbUser.insertUser(user);
		} catch (Exception e) {
			throw new Exception("User not inserted");
		}
	}

	@Override
	public void addTeamToUser(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUser(String name) {
		IFDBUser dbCUs = new DBUser();
		
		return dbCUs.findUserByName(name);
	}

	@Override
	public User findUserByHandle(String handle) {
		IFDBUser dbCUs = new DBUser();
	 
		return dbCUs.findUserByHandle(handle);
	}
	
	@Override
	public int updateUser(int id, String handle, String name, String password,
			boolean isAdmin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
