/**
 * 
 */
package DBLayer;

import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.User;

/**
 * @author Jacob 19/05/2015
 *
 */
public interface IFDBTeamMembers {

	/**
	 * Finds all Users linked to a certain team.
	 * 
	 * @param teamID
	 *            The id of the tournament, to check for.
	 * @return ArrayList of Users. Will be empty if none was found.
	 */
	public ArrayList<User> getUsersFromTeam(int teamID);

	/**
	 * Finds all teams linked to a certain user.
	 * 
	 * @param userID
	 * @return ArrayList of teams. Will be empty if none was found.
	 */
	public ArrayList<Team> getTeamsFromUsers(int userID);

	/**
	 * Links a specified User to a specified Team.
	 * 
	 * @param teamID
	 *            THe id of the team the user should be added to.
	 * @param userID
	 *            The user to add to the tournament.
	 */
	public void addUserToTeam(int teamID, int userID);

	/**
	 * Remove the User from the tournament.
	 * 
	 * @param teamID
	 *            The id of the team to remove the user from.
	 * @param UserID
	 *            The user id of the user to be removed.
	 */
	public void removeUserFromTeam(int teamID, int UserID);

	/**
	 * Remove all the users from the team.
	 * 
	 * @param teamID
	 *            The id of the team to remove the users from.
	 */
	public void removeAllUsersFromTeam(int teamID);
}