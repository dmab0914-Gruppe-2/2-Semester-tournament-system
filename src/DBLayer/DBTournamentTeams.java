/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CtrLayer.IFTeamController;
import CtrLayer.TeamController;
import ModelLayer.Team;

/**
 * @author Jacob 19/05/2015
 * Handles linking a specific team to a specific tournament in the database.
 * As well as retrieving a team related to a tournament.
 */
public class DBTournamentTeams implements IFDBTournamentTeams {

	private Connection con;
	private IFTeamController teamController;

	public DBTournamentTeams() {
		con = DBConnection.getInstance().getDBcon(); //Get instance of DbConnection, which creates the connection to DB.
		teamController = new TeamController();
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournamentTeams#getTeamsFromTournament(int)
	 */
	public ArrayList<Team> getTeamsFromTournament(int tournamentID) {
		String wClause = "  tournamentID = '" + tournamentID + "'";
		return miscWhere(wClause);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournamentTeams#addTeamToTournament(int, ModelLayer.Team)
	 */
	public boolean addTeamToTournament(int tournamentID, int teamID) {
		int rc = -1;
		String query="INSERT INTO TournamentTeams(tournamentID, teamID)  VALUES('"+
				tournamentID  + "','"  +
				teamID + "')";

		System.out.println("Query = " + query);
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("ERROR: Team couldn't be added");
			//throw new Exception ("Team is not added correctly");
		}
		if(rc == 0) {
			return false;
		}
		return true;
	}

	private ArrayList<Team> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Team> list = new ArrayList<Team>();

		String query = buildQuery(wClause);

		try { // read the Tournament teams from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Team teamObj = teamController.findTeamById(results.getInt("teamID"));
				list.add(teamObj);
			}// end while
			stmt.close();
			// Association is not to be build
		}// end try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}

	private String buildQuery(String wClause) {
		String query = "SELECT tournamentID, teamID FROM TournamentMatches";
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}
}
