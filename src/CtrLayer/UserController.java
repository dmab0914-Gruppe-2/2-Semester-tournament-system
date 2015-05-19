package CtrLayer;

import java.util.ArrayList;

import DBLayer.DBUser;
import DBLayer.IFDBUser;
import ModelLayer.Team;
import ModelLayer.User;

public class UserController implements IFUserController {

	@Override
	public void addUser(String handle, String name,
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
		IFDBUser dbUser = new DBUser();

		return dbUser.findUserByName(name);
	}

	@Override
	public User findUserByHandle(String handle) {
		IFDBUser dbUser = new DBUser();

		return dbUser.findUserByHandle(handle);
	}

	@Override
	public User findUserID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(int id, String handle, String name, String password,
			boolean isAdmin) {

		IFDBUser dbUser = new DBUser();
		User user = new User();

		user.setUserID(id);
		user.setHandle(handle);
		user.setName(name);
		user.setPassword(password);
		user.setAdmin(isAdmin);

		try {
			return dbUser.updateUser(user);
		} catch (Exception e) {
			System.out.println("Update exception in User db: " + e);
			return -1;
		}
	}

	@Override
	public int deleteUser(int id) {
		IFDBUser dbUser = new DBUser();
		return dbUser.deleteUser(id);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		IFDBUser dbUser = new DBUser();
		return dbUser.getAllUsers();
	}

}
