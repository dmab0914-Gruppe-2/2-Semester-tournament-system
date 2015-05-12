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
	
	public ArrayList<Tournament> getTournaments();
	
	public Tournament getTournament(int tournamentID);
	
	public boolean addTournament(Tournament tournament);
	
	public boolean enableSignup(int tournamentID);
	
	public boolean startTournament(int tournamentID);
	
	public ArrayList<Team> getTournamentTeams(int tournamentID);
	
	public int advanceTournament(int tournamentID);
	
	public Tournament endTournament(int tournamentID);
}
