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
public interface IFTeamController  {

	public void addTeam(int id, String name, int leader) throws Exception;
	
	public void addUserToTeam(User user, Team team) throws Exception;
	
	public void removeUserFromTeam(User user, Team team) throws Exception;
	
	public ArrayList<User> getTeamMembers(int teamId);
	
	public Team findTeam(String name);
	
	public Team findTeamById(int id);

	public int updateTeam(int id, String name, int leader);
	
	public int deleteTeam(int id);
	
	public ArrayList<Team> getAllTeams();
}