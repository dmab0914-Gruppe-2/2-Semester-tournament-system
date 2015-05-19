package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBTeam {

	// get all Teams
	public ArrayList<Team> getAllTeams();


	// find a Team by name
	public Team findTeamByName(String name);
	
	//find a Team by id
	public Team findTeamById(int id);

	// insert new Team
	public int insertTeam(Team Team) throws Exception;

	// update Team
	public int updateTeam(Team Team);

	// Delete Team
	public int deleteTeam(int id);


	

}
	
