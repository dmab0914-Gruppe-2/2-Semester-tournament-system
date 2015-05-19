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

	public ArrayList<Team> getTeamsFromTournament(int TournamentID);
	
	public boolean addTeamToTournament(int tournamentID, Team team);
}
