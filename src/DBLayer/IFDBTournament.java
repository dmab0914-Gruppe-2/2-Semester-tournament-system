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
	
	public ArrayList<Tournament> getTournaments(boolean retriveAssociation);
	
	public Tournament getTournament(int tournamentID, boolean retriveAssociation);
	
	public Tournament getTournamentByName(String tournamentName, boolean retriveAssociation);
	
	public Tournament addTournament(Tournament tournament)  throws Exception;
	
	public boolean enableSignup(int tournamentID);
	
	public boolean startTournament(int tournamentID);
	
	public boolean abortTurnament(int tournamentID);
	
	public ArrayList<Team> getTournamentTeams(int tournamentID);
	
	public int advanceTournament(int tournamentID);
	
	public int rollBackRound(int tournamentID);
	
	public Tournament endTournament(int tournamentID);
	
	public boolean removeTournament(int tournamentID);
}
