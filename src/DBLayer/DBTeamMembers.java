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
import CtrLayer.IFUserController;
import CtrLayer.TeamController;
import CtrLayer.UserController;
import ModelLayer.Team;
import ModelLayer.User;

/**
 * @author Jacob 19/05/2015
 *
 */
public class DBTeamMembers implements IFDBTeamMembers {

	private Connection con;
	private IFUserController userController;
	private IFTeamController teamController;

	public DBTeamMembers() {
		con = DBConnection.getInstance().getDBcon(); //Get instance of DbConnection, which creates the connection to DB.
		userController = new UserController();
		teamController = new TeamController();
	}

	public ArrayList<User> getUsersFromTeam(int teamID) {
		String wClause = "  teamID = '" + teamID + "'";
		return miscWhere(wClause);
	}

	@Override
	public ArrayList<Team> getTeamsFromUsers(int userID) {
		String wClause = " userID = '" + userID + "'";
		return miscWhereTeam(wClause);
	}

	public void addUserToTeam(int teamID, int userID) {
		String query="INSERT INTO TeamMembers(teamID, userID)  VALUES('"+
				teamID  + "','"  +
				userID + "')";

		System.out.println("Query = " + query);
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("ERROR: User couldn't be added");
			//throw new Exception ("User is not added correctly");
		}
	}

	public void removeUserFromTeam(int teamID, int UserID) {
		String query="DELETE FROM TeamMembers WHERE teamID = '" +
				teamID + "'" +
				" AND  UserID='" + 
				UserID + "'";
		System.out.println(query);
		try{ // delete from TeamMembers
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}//end try	
		catch(Exception ex){
			System.out.println("Error in removing user: " + UserID + " from team: " + teamID + " Exception: " + ex);
		}
	}
	
	public void removeAllUsersFromTeam(int teamID) {
		String query="DELETE FROM TeamMembers WHERE teamID = '" +
				teamID + "'";
		System.out.println(query);
		try{ // delete from TeamMembers
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}//end try	
		catch(Exception ex){
			System.out.println("Error in removing all users from team: " + teamID + " Exception: " + ex);
		}
	}
	
	private ArrayList<User> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<User> list = new ArrayList<User>();

		String query = buildQuery(wClause);

		try { // read the Team members from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				User userObj = userController.findUserID(results.getInt("userID"));
				list.add(userObj);
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
	
	private ArrayList<Team> miscWhereTeam(String wClause) {
		ResultSet results;
		ArrayList<Team> list = new ArrayList<Team>();

		String query = buildQuery(wClause);

		try { // read the Team members from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
//				User userObj = userController.findUserID(results.getInt("userID"));
//				list.add(userObj);
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
		String query = "SELECT teamID, userID FROM TeamMembers";
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}
}
