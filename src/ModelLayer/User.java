/**
 * 
 */
package ModelLayer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author nicklas
 *
 */
public class User {
	private int userID;
	private String handle;
	private String name;
	private String password;
	private boolean isAdmin;
	private ArrayList<Team> team;

	/**
	 * Constructor for a all fields set!
	 */

	public User(int id, String handle, String name, String password,
			boolean isAdmin) {
		this.userID = id;
		this.handle = handle;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
		// ArrayList<Team> team = new ArrayList<Team>();
	}

	/**
	 * Constructor for a empty User
	 */

	public User() {

	}
	
	/*
	 * @return userID as string
	 */
	public String getUserIdAsString(){
		String i = Integer.toString(this.userID);
		return i;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the handle
	 */
	public String getHandle() {
		return handle;
	}

	/**
	 * @param handle
	 *            the handle to set
	 */
	public void setHandle(String handle) {
		this.handle = handle;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the team
	 */
	public ArrayList<Team> getTeam() {
		return team;
	}

	/**
	 * Adds a team to the user
	 * 
	 * @param t
	 */
	public void addTeam(Team t) {
		if (!team.contains(t)) {
			team.add(t);
		}
	}

	public boolean removeTeam(String teamName) {
		try {
			Iterator<Team> it = team.iterator();
			while (it.hasNext()) {
				Team t = it.next();
				if (t.getClass().equals(teamName))
					it.remove();
			}
			return true;
		} catch (IllegalArgumentException ie) {
			return false;
		}
	}

}
