package DBLayer;

import java.util.ArrayList;
import java.sql.*;

import ModelLayer.Team;

public class DBTeam implements IFDBTeam {
	private Connection con;
	private IFDBTeamMembers dbTeamMembers;

	public DBTeam() {
		con = DBConnection.getInstance().getDBcon();
		dbTeamMembers = new DBTeamMembers();
	}

	@Override
	public ArrayList<Team> getAllTeams() {
		return miscWhere("", true);
	}

	@Override
	public Team findTeamByName(String name) {
		String wClause =" name = '" + name + "'";
		return singleWhere(wClause, true);
	}

	@Override
	public Team findTeamById(int id) {
		String wClause =" id = '" + id + "'";
		return singleWhere(wClause, true);
	}

	@Override
	public int insertTeam(Team team) throws Exception {
		int rc = -1;
		String query = "INSERT INTO Team(name,leader) VALUES('"
				+ team.getName()
				+ "','"
				+ team.getLeader()+ "')";


		System.out.println("insert : " + query);
		try { // insert new Team
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}// end try
		catch (SQLException ex) {
			System.out.println("Team ikke oprettet");
			throw new Exception("Team is not inserted correct");
		}
		return (rc);
	}

	public int updateTeam(Team team) {
		int rc = -1;
		String query = "UPDATE Team SET "
				+ "', " + "name ='" + team.getName()
				+ "', " + "leader ='" + team.getLeader()+"'";
		System.out.println("Update query:" + query);

		try { // update team
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);

			stmt.close();
		}// slut try
		catch (Exception ex) {
			System.out.println("Update exception in team db: " + ex);
		}

		return rc;
	}

	@Override
	public int deleteTeam(int id) {
		int rc = -1;

		String query = "DELETE FROM Team WHERE id = '" + id + "'";
		System.out.println("DELETE query: " + query);
		System.out.println("Removing Teams members first");
		dbTeamMembers.removeAllUsersFromTeam(id); //Removes all Users from the team so it can be removed successfully.
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		} catch(Exception ex) {
			System.out.println("Delete exception in Team db: " + ex);
		}
		return rc;
	}

	// Help methods. NOT IN IF!
	// private methods
	/**
	 * miscWhere is used whenever we want to select more than one team
	 * 
	 * @param wClause
	 * @return list of team
	 */
	private ArrayList<Team> miscWhere(String wClause, boolean retrieveAssociation) {
		ResultSet results;
		ArrayList<Team> list = new ArrayList<Team>();

		String query = buildQuery(wClause);

		try { // read the Team from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Team teamObj = new Team();
				teamObj = buildTeam(results);
				list.add(teamObj);
			}// end while
			stmt.close();
			// Association is to be build
			if(retrieveAssociation) {
				for(Team teamObj : list){
					//Build list of Tournament Teams
					teamObj.setUsers(dbTeamMembers.getUsersFromTeam(teamObj.getId()));
				}
			}//end if
		}// slut try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * method to get one team
	 * 
	 * @param wClause
	 * @return one team
	 */
	private Team singleWhere(String wClause, boolean retrieveAssociation) {
		ResultSet results;
		Team teamObj = new Team();

		String query = buildQuery(wClause);
		System.out.println(query);
		try { // read the employee from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next()) {
				teamObj = buildTeam(results);
				// assocaition is to be build
				stmt.close();
				// Association is to be build
				if(retrieveAssociation) {
					//Build list of Tournament Teams
					teamObj.setUsers(dbTeamMembers.getUsersFromTeam(teamObj.getId()));
				}//end if
			} else { // no employee was found
				teamObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return teamObj;
	}

	/**
	 * method to buildquery
	 * 
	 * @param wClause
	 * @return query
	 */
	private String buildQuery(String wClause) {

		String query = "SELECT * FROM Team";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	/**
	 * method to build a team object
	 * 
	 * @param results
	 * @return a team object
	 */
	private Team buildTeam(ResultSet results) {
		Team teamObj = new Team();
		try { // the columns from the table team are used
			teamObj.setId(results.getInt("id"));
			teamObj.setName(results.getString("name"));
			teamObj.setLeader(results.getString("Leader"));
		} catch (Exception e) {
			System.out.println("error in building the team object");
		}
		return teamObj;
	}





}
