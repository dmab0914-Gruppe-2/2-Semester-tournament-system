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
import ModelLayer.IdAllreadyExsistException;
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
	public ArrayList<Tournament> getTournaments(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#getTournament(int)
	 */
	public Tournament getTournament(int tournamentID, boolean retriveAssociation) {
		// TODO Auto-generated method stub
		String wClause = "  tournamentID = '" + tournamentID + "'";
		return singleWhere(wClause, retriveAssociation);
	}

	/* (non-Javadoc)
	 * @see DBLayer.IFDBTournament#addTournament(ModelLayer.Tournament)
	 */
	public Tournament addTournament(Tournament tournament) throws Exception {
		// TODO Auto-generated method stub
		if(getTournament(tournament.getId(), false) == null) {
			int playOffBit;
			if(tournament.isWithPlayOff()) {
				playOffBit = 1;
			}
			else {
				playOffBit = 0;
			}

			int rc = -1;
			String query="INSERT INTO Tournament(id, name, gameName, teamSize, withPlayOff, statusID, startTime, winnerTeam, roundNumber)  VALUES('"+
					tournament.getId()  + "','"  + //TODO 
					tournament.getName()  + "','"  +
					tournament.getGameName() + "','" +
					tournament.getTeamSize() + "','" +
					playOffBit + "','" +
					tournament.statusToInt(tournament.getStatus()) + "','" +
					tournament.getStartTime() + "','" +
					tournament.getWinnerTeam() + "','" +
					tournament.getRoundNumber() + "')";

			System.out.println("insert : " + query);
			try{
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				rc = stmt.executeUpdate(query); //Returns the row count which may be the id.
				/*ResultSet returnSet = stmt.executeQuery("Select SCOPE_IDENTIFIRY();"); //Alternative way to get the id, if before doesn't.
				returnSet.next();
				int id = returnSet.getInt(1);*/
				stmt.close();
				tournament.setId(rc);
				return tournament;
			}//end try
			catch(SQLException ex){
				System.out.println("Product haven't been created");
				throw new Exception("Adding Tournament: " + tournament.getName() + " Couldn't be added.");
			}
		}
		throw new IdAllreadyExsistException ("Tournament: " + tournament.getName() + " Allready exsist.");
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
		return dbTournamentTeams.getTeamsFromTournament(tournamentID);
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
	public Tournament endTournament(int tournamentID, boolean retriveAssociation) {
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
