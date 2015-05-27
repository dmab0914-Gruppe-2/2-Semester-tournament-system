package CtrLayer;

import java.security.MessageDigest;
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
		user.setPassword(stringToHash(password));
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
		IFDBUser dbUser = new DBUser();
		return dbUser.findUserById(id);
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

	/**
	 * Takes a password as parameter which this method then hashes with the SHA-512 algorithm and returns the hashed password
	 * -author Andreas
	 * @param input unhashed password
	 * @return hashed password
	 * @throws Exception unknown
	 */
	public String stringToHash(String input) throws Exception{

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(input.getBytes());

			byte byteData[] = messageDigest.digest();

			//Convert to HEX 1
			StringBuffer stringBuffer = new StringBuffer();
			for(int i = 0; i<byteData.length; i++){
				stringBuffer.append(Integer.toString(byteData[i] & 0xff + 0x100, 16).substring(1));
			}
			//System.out.print("HEX Format method 1: "+stringBuffer.toString() + "\n");

		return stringBuffer.toString();
	}

	public User login(String username, String password){

        User user = findUserByHandle(username);
        if(user != null){
            try {
                String hashed = stringToHash(password);
                if(hashed.equals(user.getPassword())){
                    return user;
                } else{
                    System.out.println("Wrong password!");
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Wrong Username!");
        }
        return null;
	}
	
	public String findUserNameById(int id) {
		IFDBUser dbUser = new DBUser();
		
		User u = dbUser.findUserById(id);
		
		return u.getHandle();
	}

}
