/**
 * 
 */
package DBLayer;

import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 12/05/2015
 *
 */
public interface IFDBTournament {
	
	/*
	 * Method to get all tournaments
	 * @param boolean retriveAssociation not used, just set false
	 * @return Arraylist of tournamets
	 */
	public ArrayList<Tournament> getTournaments(boolean retriveAssociation);
	/*
	 * Method the get single tournament
	 * @param tournamentID the id of the tournament you need to get
	 * @param boolean retriveAssociation not used, just set false
	 * @return Tournament matching ID
	 */
	public Tournament getTournament(int tournamentID, boolean retriveAssociation);
	/*
	 * Method the get single tournament
	 * @param tournamentName the name of the tournament you need to get
	 * @param boolean retriveAssociation not used, just set false
	 * @return Tournament matching name
	 */
	public Tournament getTournamentByName(String tournamentName, boolean retriveAssociation);
	/*
	 * Method to add a tournament
	 * @param tournament the tournament object to add
	 * @return the created tournament
	 */
	public Tournament addTournament(Tournament tournament)  throws Exception;
	/*
	 * Method to enableSignup
	 * @param tournamentID to enable signup for
	 * @return boolean true if enable has been set 
	 */
	public boolean enableSignup(int tournamentID);
	/*
	 * Method to start tournament (sets tournamet status to running)
	 * @param tournamentID of the tournamet your setting status for
	 * @return boolean return true, if tournamnet status has been changed 	
	 */
	public boolean startTournament(int tournamentID);
	/*
	 * Method to abort tournament, (sets tournamet status to cancel)
	 * @param tournamentID of the tournamet your setting status for
	 * @return boolean return true, if tournamnet status has been changed 
	 */
	public boolean abortTurnament(int tournamentID);
	/*
	 * Method to get all teams in a tournament
	 * @param tournamentID id of the tournament you want teams for
	 * @return Arraylist of teams in tournament 
	 */
	public ArrayList<Team> getTournamentTeams(int tournamentID);
	/*
	 * Method to advance tournament, to advance roundnumber
	 * @param tournamentID for tournament your advancing 
	 * @int rowcount from db
	 */
	public int advanceTournament(int tournamentID);
	/*
	 * Method to rollback a roundnumber (for fail in advance tournament)
	 * @param tournamentID for tournament your rolling back
	 */
	public int rollBackRound(int tournamentID);
	/*
	 * Method to end tournament, (sets tournamet status to done, and winner team)
	 * @param tournamentID for tournament your ending
	 * @param winner the team who has won
	 * @return the finsh and updated tournament object 
	 */
	public Tournament endTournament(int tournamentID, Team winner);
	/*
	 * Method to remove a tournament
	 * @param tournamentID to remove
	 * @return boolean returns true if deleted
	 */
	public boolean removeTournament(int tournamentID);
}
