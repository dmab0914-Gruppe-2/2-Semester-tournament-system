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
import CtrLayer.IFTournamentController;
import CtrLayer.TeamController;
import CtrLayer.TournamentController;
import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 19/05/2015 Handles linking a specific team to a specific
 *         tournament in the database. As well as retrieving a team related to a
 *         tournament.
 */
public class DBTournamentTeams implements IFDBTournamentTeams {

	private Connection con;
	private IFTeamController teamController;

	public DBTournamentTeams() {
		con = DBConnection.getInstance().getDBcon(); // Get instance of
														// DbConnection, which
														// creates the
														// connection to DB.
		teamController = new TeamController();
		//tournamentController = new TournamentController();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DBLayer.IFDBTournamentTeams#getTeamsFromTournament(int)
	 */
	public ArrayList<Team> getTeamsFromTournament(int tournamentID) {
		String wClause = "  tournamentID = '" + tournamentID + "'";
		return miscWhere(wClause);
	}

	@Override
	public ArrayList<Tournament> getTournamentFromTeams(int teamID) {
		String wClause = "  teamID = '" + teamID + "'";
		return miscWhereTournament(wClause);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DBLayer.IFDBTournamentTeams#addTeamToTournament(int,
	 * ModelLayer.Team)
	 */
	public void addTeamToTournament(int tournamentID, int teamID) {
		String query = "INSERT INTO TournamentTeams(tournamentID, teamID)  VALUES('"
				+ tournamentID + "','" + teamID + "')";

		System.out.println("Query = " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}// end try
		catch (SQLException ex) {
			System.out.println("ERROR: Team couldn't be added");
			// throw new Exception ("Team is not added correctly");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DBLayer.IFDBTournamentTeams#removeTeamFromTournament(int
	 * tournamentID, int teamID)
	 */
	public void removeTeamFromTournament(int tournamentID, int teamID) {
		String query = "DELETE FROM TournamentTeams WHERE tournamentID = '"
				+ tournamentID + "'" + " AND  teamID='" + teamID + "'";
		System.out.println(query);
		try { // delete from TournamentTeams
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}// end try
		catch (Exception ex) {
			System.out
					.println("Error in removing team: " + teamID
							+ " from tournament: " + tournamentID
							+ " Exception: " + ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DBLayer.IFDBTournamentTeams#removeAllTeamsFromTournament(int)
	 */
	@Override
	public void removeAllTeamsFromTournament(int tournamentID) {
		String query = "DELETE FROM TournamentTeams WHERE tournamentID = '"
				+ tournamentID + "'";
		System.out.println(query);
		try { // delete from TournamentTeams
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}// end try
		catch (Exception ex) {
			System.out.println("Error in removing all teams from tournament: "
					+ tournamentID + " Exception: " + ex);
		}
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
				Team teamObj = teamController.findTeamById(results
						.getInt("teamID"));
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

	private ArrayList<Tournament> miscWhereTournament(String wClause) {
		ResultSet results;
		ArrayList<Tournament> list = new ArrayList<Tournament>();
		IFTournamentController tournamentController = new TournamentController();

		String query = buildQuery(wClause);

		try { // read the Team members from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			while (results.next()) {
				Tournament tObj = tournamentController.getTournament(results
						.getInt("tournamentID"));
				list.add(tObj);
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
		String query = "SELECT tournamentID, teamID FROM TournamentTeams";
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}

}
