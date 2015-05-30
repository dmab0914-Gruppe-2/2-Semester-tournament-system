/**
 * 
 */
package CtrLayer;

import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.User;

/**
 * @author Ronnie
 *
 */
public interface IFTeamController {

	/*
	 * Method to add a team
	 * 
	 * @param name The name of the team you want to create
	 * 
	 * @param leader the userID of the person who is leader for the team
	 */
	public void addTeam(String name, int leader) throws Exception;

	/*
	 * Method to add a user to a team
	 * 
	 * @param user The user you want to add to team
	 * 
	 * @param team the Team you want to add the user to
	 */
	public void addUserToTeam(User user, Team team) throws Exception;

	/*
	 * Method to remove a user from a team
	 * 
	 * @param user The user you want to remove from team
	 * 
	 * @param team the Team you want to remove the user from
	 */
	public void removeUserFromTeam(User user, Team team) throws Exception;

	/*
	 * Method to get all team members from a given team
	 * 
	 * @param teamID the id of the team you want to get
	 * 
	 * @return Arraylist list of users in a team
	 */
	public ArrayList<User> getTeamMembers(int teamId);

	/*
	 * Method to get all teams a user are in
	 * 
	 * @param userID the id of the user you need to get teams for
	 * 
	 * @return Arraylist list of teams the user are in
	 */
	public ArrayList<Team> getTeamsFromUser(int userId);

	/*
	 * Method to get a team by team name
	 * 
	 * @param name team name you want to search for
	 * 
	 * @return a matching team for the name
	 */
	public Team findTeam(String name);

	/*
	 * Method to get a team by team id
	 * 
	 * @param id team id you want to search for
	 * 
	 * @return a matching team for the id
	 */
	public Team findTeamById(int id);

	/*
	 * Method to update a team
	 * 
	 * @param id the id for the team your updating (cant be changed, only find
	 * get the right team by)
	 * 
	 * @param name the new name for the team
	 * 
	 * @param leader id of the user you want to make leader for the team
	 * 
	 * @return a rowcount from db
	 */
	public int updateTeam(int id, String name, int leader);

	/*
	 * Method to delete a team
	 * 
	 * @param id the id of the team you want to delete
	 * 
	 * @return a rowcount from db
	 */
	public int deleteTeam(int id);

	/*
	 * Method to get all teams return Arraylist with all teams
	 */
	public ArrayList<Team> getAllTeams();
}