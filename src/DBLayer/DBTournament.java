/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.util.ArrayList;

import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 18/05/2015
 *
 */
public class DBTournament implements IFDBTournament {
	
	private Connection con;
	
	public DBTournament() {
		con = DBConnection.getInstance().getDBcon(); //Get instance of DbConnection, which creates the connection to DB.
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournaments()
	 */
	public ArrayList<Tournament> getTournaments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournament(int)
	 */
	public Tournament getTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#addTournament(ModelLayer.Tournament)
	 */
	public boolean addTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#enableSignup(int)
	 */
	public boolean enableSignup(int tournamentID) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#startTournament(int)
	 */
	public boolean startTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#abortTurnament(int)
	 */
	public boolean abortTurnament(int tournamentID) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournamentTeams(int)
	 */
	public ArrayList<Team> getTournamentTeams(int tournamentID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#advanceTournament(int)
	 */
	public int advanceTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#endTournament(int)
	 */
	public Tournament endTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return null;
	}

}
