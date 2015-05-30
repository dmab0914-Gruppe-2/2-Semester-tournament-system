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
import ModelLayer.Tournament;
import ModelLayer.Tournament.Status;

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
	public ArrayList<Tournament> getTournaments(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournamentByName(java.lang.String)
	 */
	@Override
	public Tournament getTournamentByName(String tournamentName, boolean retriveAssociation) {
		String wClause = "name = '" + tournamentName + "'";
		return singleWhere(wClause, retriveAssociation);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournament(int)
	 */
	public Tournament getTournament(int tournamentID, boolean retriveAssociation) {
		String wClause = "id = '" + tournamentID + "'";
		return singleWhere(wClause, retriveAssociation);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#addTournament(ModelLayer.Tournament)
	 */
	public Tournament addTournament(Tournament tournament) throws Exception {
		int playOffBit;
		if(tournament.isWithPlayOff()) {
			playOffBit = 1;
		}
		else {
			playOffBit = 0;
		}
		String query="INSERT INTO Tournament(name, gameName, teamSize, withPlayOff, statusID, winnerTeamID, roundNumber)  VALUES('"+
				tournament.getName()  + "','"  +
				tournament.getGameName() + "','" +
				tournament.getTeamSize() + "','" +
				playOffBit + "','" +
				Tournament.statusToInt(tournament.getStatus()) + "'," +
				"NULL" + ",'" +
				tournament.getRoundNumber() + "')";

		System.out.println("insert : " + query);
		ResultSet rs;
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			rs = stmt.executeQuery("SELECT SCOPE_IDENTITY();"); //Makes it possible to retrieve the the incremental id.
			rs.next();
			int id = rs.getInt(1); //gets the incremental id.
			rs.close();
			stmt.close();
			System.out.println("Tournaments database ID: " + id);
			tournament.setId(id);
			return tournament;
		}//end try
		catch(SQLException ex){
			System.out.println("Product haven't been added to db " + ex);
			throw new Exception("Adding Tournament: " + tournament.getName() + " Couldn't be added.");
		}
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#enableSignup(int)
	 */
	public boolean enableSignup(int tournamentID) {
		String query="UPDATE Tournament SET "+
				"statusID ='"+ Tournament.statusToInt(Status.ready) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in enableSingup for tournament db: "+ex);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#startTournament(int)
	 */
	public boolean startTournament(int tournamentID) {
		String query="UPDATE Tournament SET "+
				"statusID ='"+ Tournament.statusToInt(Status.running) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in startTournament for tournament db: "+ex);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#abortTurnament(int)
	 */
	public boolean abortTurnament(int tournamentID) {
		String query="UPDATE Tournament SET "+
				"statusID ='"+ Tournament.statusToInt(Status.cancelled) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in abortTurnament for tournament db: "+ex);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournamentTeams(int)
	 */
	public ArrayList<Team> getTournamentTeams(int tournamentID) {
		return dbTournamentTeams.getTeamsFromTournament(tournamentID);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#advanceTournament(int)
	 */
	public int advanceTournament(int tournamentID) {
		Tournament t = getTournament(tournamentID, false);
		String query="UPDATE Tournament SET "+
				"roundNumber ='"+ (t.getRoundNumber() +1) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return 1;
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in advanceTournament for tournament db: "+ex);
			return 0;
		}
	}
	
	public int rollBackRound(int tournamentID) {
		Tournament t = getTournament(tournamentID, false);
		String query="UPDATE Tournament SET "+
				"roundNumber ='"+ (t.getRoundNumber() -1) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return 1;
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in roll back round for tournament db: "+ex);
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#endTournament(int)
	 */
	public Tournament endTournament(int tournamentID) {
		String query="UPDATE Tournament SET "+
				"statusID ='"+ Tournament.statusToInt(Status.done) + "'"+
				" WHERE id = '"+ tournamentID + "'";
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}//end try
		catch(Exception ex){
			System.out.println("Update exception in endTournament for tournament db: "+ex);
		}
		return getTournament(tournamentID, false);
	}

	public boolean removeTournament(int tournamentID) {
		String query = "DELETE FROM dbo.Tournament WHERE id = '" + tournamentID + "'";
		System.out.println("DELETE query: " + query);

		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch(Exception ex) {
			System.out.println("Delete exception in Tournament db: " + ex);
			return false;
		}
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
			if(retrieveAssociation) {
				System.out.println("Building Association");
				//The winnerTeam is to be build as well
				for(Tournament tournamentObj : list){
					if(tournamentObj.getWinnerTeam() != null) {
						tournamentObj.setWinnerTeam(teamController.findTeamById(tournamentObj.getWinnerTeam().getId()));
						System.out.println("Winner Team have been added");
					}
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
				if(retrieveAssociation) {
					System.out.println("Building Association");
					if(tournamentObj.getWinnerTeam() != null) {
						tournamentObj.setWinnerTeam(teamController.findTeamById(tournamentObj.getWinnerTeam().getId()));
						System.out.println("Winner Team have been added");
					}
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
		String query = "SELECT id, name, gameName, teamSize, withPlayOff, statusID, winnerTeamID, roundNumber FROM Tournament";
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
			tournamentObj.setStatus(Tournament.intToStatus(results.getInt("statusID")));
			tournamentObj.setWinnerTeam(new Team(results.getInt("winnerTeamID")));
			if(results.wasNull()) { //In case previous read integer was sql statement NULL. aka what we would translate to null in java.
				tournamentObj.setWinnerTeam(null);
			}
			tournamentObj.setRoundNumber(results.getInt("roundNumber"));
		} catch (Exception e) {
			System.out.println("error in building the Product object");
		}
		return tournamentObj;
	}
}
