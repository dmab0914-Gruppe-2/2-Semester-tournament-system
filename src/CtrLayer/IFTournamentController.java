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
	
	/*
	 * Method to get all tournaments 
	 * @return ArrayList of all tournaments
	 */
	public ArrayList<Tournament> getTournaments();
	/*
	 * Method the get a tournament by name
	 * @param tournamentName name of tournament to search for
	 * @return the found tournament
	 */
	public Tournament getTournamentByName(String tournamentName);
	/*
	 * Method the get a tournament by id
	 * @param tournamentID id of tournament to search for
	 * @return the found tournament
	 */
	public Tournament getTournament(int tournamentID);
	/*
	 * Method to open tournament for signup for team
	 * @param tournamentID the id of tournament you want to enable signup for
	 * @return boolean if signup has been set enable
	 */
	public boolean enableSignup(int tournamentID);
	/*
	 * Method start the tournament and create first round of matches
	 * @param tournament of you want to start
	 * @return ArrayList of matches for first round of the tournament
	 */
	public ArrayList<Match> startTournament(int tournamentID) throws Exception;
	/*
	 * Method to set result for a match and set it done when result has been set
	 * @param matchID id of the match your setting result for
	 * @param team1Score score of team 1 in the match
	 * @param team2Score score of team 2 in the match
	 * @return rowcount from db
	 */
	public int setMatchResults(int matchID, int team1Score, int team2Score);
	/*
	 * Method to advance tournament and start/create next round
	 * @param tournamentID of the tournament you are advancing 
	 * @return Arraylist of matches for next round
	 */
	public ArrayList<Match> advanceTournament(int tournamentID);
	
	/*
	 * Method to endTournament when last match are done, adavanceTournemnt will ask for this when it get advance any more rounds
	 * @param tournament id of your finished tournament
	 * @return the tournament again with new status(done) and a winner team
	 */
	public Tournament endTournament(int tournamentID);
	
	/*
	 * Method to sign a team up for the tournament
	 * @param tournament the tournament you are adding the team for
	 * @param team the team you want to add to the team
	 */
	public void addTeamToTournament(Tournament tournament, Team team) throws Exception;
	/*
	 * Method to remove team from a tournament
	 * @param tournament the tournament you to remove a team from
	 * @param team the team you want to remove from the tournament
	 */
	public void removeTeamFromTournament(Tournament tournament, Team team) throws Exception;
	/*
	 * Method to get all teams in a tournament
	 * @param tournament id for the tournament you want to get teams for
	 * @return Arraylist of teams
	 */
	public ArrayList<Team> getTournamentTeams(int tournamentID);
	/*
	 * Method to get all tournaments a team are in 
	 * @param teamID id of the team you want to get tournaments for
	 * @return Arraylist of tournaments
	 */
	public ArrayList<Tournament> getTournamentFromTeam(int teamID);
	
	/*
	 *  Method to get all matches for a tournament
	 *  @param tournament Id of the tournament you want matches for
	 *  @return Arraylist of matches
	 */
	public ArrayList<Match> getMatchesForTournament(int tournamentID);
	/*
	 *   Method to get a single match
	 *   @param matchID id of the match you want to get
	 *   @return Match with the given ID
	 */
	public Match getMatch(int matchID);
}
