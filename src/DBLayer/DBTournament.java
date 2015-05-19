/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import CtrLayer.IFTeamController;
import CtrLayer.TeamController;
import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 18/05/2015
 *
 */
public class DBTournament implements IFDBTournament {
	
	private Connection con;
	private IFTeamController teamController;
	private IFDBTournamentTeams dbTournamentTeams;
	
	public DBTournament() {
		con = DBConnection.getInstance().getDBcon(); //Get instance of DbConnection, which creates the connection to DB.
		teamController = new TeamController();
		dbTournamentTeams = new DBTournamentTeams();
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
	
	private ArrayList<Tournament> miscWhere(String wClause, boolean retrieveAssociation) {
		ResultSet results;
		ArrayList<Tournament> list = new ArrayList<Tournament>();

		String query = buildQuery(wClause);

		try { // read the Tournament from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Tournament tournamentObj = new Tournament(); 
				tournamentObj = buildTournament(results);
				list.add(tournamentObj);
			}// end while
			stmt.close();
			// Association is to be build
			if(retrieveAssociation)
			{   //The winnerTeam is to be build as well
				for(Tournament tournamentObj : list){
					tournamentObj.setWinnerTeam(teamController.findTeamById(tournamentObj.getWinnerTeam().getId()));
					System.out.println("Winner Team have been added");
					//Build list of Tournament Teams
					tournamentObj.setTeams(dbTournamentTeams.getTeamsFromTournament(tournamentObj.getId()));
				}
			}//end if 
		}// end try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	
	private Tournament singleWhere(String wClause, boolean retrieveAssociation) {
		ResultSet results;
		Tournament tournamentObj = new Tournament();

		String query = buildQuery(wClause);
		System.out.println(query);
		try { // read the Tournament from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next()) {
				tournamentObj = buildTournament(results);
				stmt.close();
				// Association is to be build
				if(retrieveAssociation)
				{   
					tournamentObj.setWinnerTeam(teamController.findTeamById(tournamentObj.getWinnerTeam().getId()));
					System.out.println("Winner Team have been added");
					//Build list of Tournament Teams
					tournamentObj.setTeams(dbTournamentTeams.getTeamsFromTournament(tournamentObj.getId()));
				}

			} else { // no tournament was found
				tournamentObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return tournamentObj;
	}
	
	private String buildQuery(String wClause) {
		String query = "SELECT id, name, gameName, teamSize, withPlayOff, statusID, startTime, winnerTeam, roundNumber FROM Tournament";
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	private Tournament buildTournament(ResultSet results) {
		Tournament tournamentObj = new Tournament();
		try { // the columns from the table Tournament is used
			tournamentObj.setId(results.getInt("id"));
			tournamentObj.setName(results.getString("name"));
			tournamentObj.setGameName(results.getString("gameName"));
			tournamentObj.setTeamSize(results.getInt("teamSize"));
			tournamentObj.setWithPlayOff(results.getBoolean("withPlayOff"));
			tournamentObj.setStartTime(results.getDate("startTime"));
			tournamentObj.setWinnerTeam(new Team(results.getInt("winnerTeam")));
			tournamentObj.setRoundNumber(results.getInt("roundNumber"));
		} catch (Exception e) {
			System.out.println("error in building the Product object");
		}
		return tournamentObj;
	}
}
