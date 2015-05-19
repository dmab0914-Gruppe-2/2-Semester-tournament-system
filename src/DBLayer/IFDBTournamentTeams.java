/**
 * 
 */
package DBLayer;

import java.util.ArrayList;

import ModelLayer.Team;

/**
 * @author Jacob 19/05/2015
 *
 */
public interface IFDBTournamentTeams {

	/**
	 * Finds all Teams linked to a certain tournament. 
	 * @param tournamentID	The id of the tournament, to check for.
	 * @return	ArrayList of teams. Will be empty if none was found.
	 */
	public ArrayList<Team> getTeamsFromTournament(int tournamentID);
	
	/**
	 * Links a specified team to a specified tournament.
	 * @param tournamentID	THe id of the tournament the team should be added to.
	 * @param teamID	The team to add to the tournament.
	 */
	public void addTeamToTournament(int tournamentID, int teamID);
	
	/**
	 * Remove the team from the tournament.
	 * @param tournamentID	The id of the tournament to remove the team from.
	 * @param teamID	The team id of the team to be removed.
	 */
	public void removeTeamFromTournament(int tournamentID, int teamID);
	
	/**
	 * Remove all the teams from the tournament.
	 * @param tournamentID	The id of the tournament to remove the teams from.
	 */
	public void removeAllTeamsFromTournament(int tournamentID);
}
