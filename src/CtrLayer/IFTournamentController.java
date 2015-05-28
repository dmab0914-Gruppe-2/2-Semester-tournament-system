/**
 * 
 */
package CtrLayer;

import java.util.ArrayList;

import ModelLayer.Match;
import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 12/05/2015
 *
 */
public interface IFTournamentController {
	
	public ArrayList<Tournament> getTournaments();
	
	public Tournament getTournamentByName(String tournamentName);
	
	public Tournament getTournament(int tournamentID);
	
	public boolean enableSignup(int tournamentID);
	
	public ArrayList<Match> startTournament(int tournamentID) throws Exception;
	
	public int setMatchResults(int matchID, int team1Score, int team2Score);
	
	public ArrayList<Match> advanceTournament(int tournamentID);
	
	public Tournament endTournament(int tournamentID);
	
	public void addTeamToTournament(Tournament tournament, Team team) throws Exception;
	
	public void removeTeamFromTournament(Tournament tournament, Team team) throws Exception;
	
	public ArrayList<Team> getTournamentTeams(int tournamentID);
	
	public ArrayList<Tournament> getTournamentFromTeam(int teamID);
}
