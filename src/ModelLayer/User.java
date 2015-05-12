/**
 * 
 */
package ModelLayer;

/**
 * @author nicklas
 *
 */
public class User {
	private int userID;
	private String handle;
	private String name;
	private Team team;

	/**
	 * Constructor for a all fields set!
	 */
	
	public User(int id, String handle, String name, Team team) {
		this.userID = id;
		this.handle = handle;
		this.name = name;
		this.team = team;
	}
	
	/**
	 * Constructor for a empty User
	 */
	
	public User() {

	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
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
	 * @param handle the handle to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

}
