package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Match;
import ModelLayer.Team;
import ModelLayer.Tournament;

public class DBMatch implements IFDBMatch {
	private Connection con;

	public DBMatch() {
		con = DBConnection.getInstance().getDBcon();
	}

	@Override
	public Match addmatch(Match match)throws Exception {
		String query = "INSERT INTO Match(team1ID, team2ID, score1, score2, statusID, roundnumber, tournamentID) VALUES('"
				+ Integer.toString(match.getTeam1().getId())
				+ "','"
				+ Integer.toString(match.getTeam2().getId())
				+ "','"
				+ Integer.toString(match.getTeam1Score())
				+ "','"
				+ Integer.toString(match.getTeam2Score())
				+ "','"
				+ Tournament.statusToInt(match.getStatus())
				+ "','"
				+ Integer.toString(match.getRoundNumber())
				+ "','"
				+ Integer.toString(match.getTournamentId()) + "')";
		
		System.out.println("insert : " + query);
		
		ResultSet rs;
		try { // insert new match
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			rs = stmt.executeQuery("SELECT SCOPE_IDENTITY();"); //Makes it possible to retrieve the the incremental id.
			rs.next();
			int id = rs.getInt(1); //gets the incremental id.
			rs.close();
			stmt.close();
			System.out.println("Tournaments database ID: " + id);
			match.setId(id);
			return match;
		}// end try
		catch (SQLException ex) {
			System.out.println("insert exception in Match db:");
			throw new Exception("Match is not inserted correct");
		}
	}

	@Override
	public int removeMatch(int matchID) {
		int rc = -1;
		String query = "DELETE FROM Match WHERE id = '" + matchID + "'";
		System.out.println("DELETE query: " + query);

		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		} catch (Exception ex) {
			System.out.println("Delete exception in match db: " + ex);
		}
		return rc;
	}

	public Match getMatch(int matchID) {
		String wClause = " id = '" + matchID + "'";
		return singleWhere(wClause);
	}

	@Override
	public int setMatchResults(int matchID, int team1Score, int team2Score) {
		int rc = -1;
		String query = "UPDATE Match SET " + "score1 = '" + team1Score
				+ "', " + "score2 = '" + team2Score + "' WHERE id = '" 
				+ matchID + "'";
		
		System.out.println("Update query:" + query);
		
		try { // update match result
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);

			stmt.close();
		}// slut try
		catch (Exception ex) {
			System.out.println("Update exception in match db: " + ex);
		}

		return rc;
	}

	@Override
	public ArrayList<Match> getMatchesForTournament(int tournamentID) {
		String wClause = Integer.toString(tournamentID);
		return miscWhere(wClause);
	}

	private Match singleWhere(String wClause) {
		ResultSet results;
		Match matchObj = new Match();

		String query = buildQuery(wClause);
		System.out.println(query);
		try { //
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next()) {
				matchObj = buildMatch(results);
				// assocaition is to be build
				stmt.close();

			} else { // no employee was found
				matchObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return matchObj;
	}
	
	private ArrayList<Match> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Match> list = new ArrayList<Match>();
		
		String query = buildQuery("tournamentID = " + wClause);

		try { // read the user from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Match matchObj = new Match();
				matchObj = buildMatch(results);
				list.add(matchObj);
			}// end while
			stmt.close();
		}// slut try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}

	private String buildQuery(String wClause) {

		String query = "SELECT * FROM Match";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	private Match buildMatch(ResultSet results) {
		Match matchObj = new Match();
		try { // the columns from the table Match are used
			matchObj.setId(results.getInt("id"));
			matchObj.setTeam1(new Team(results.getInt("team1ID")));
			matchObj.setTeam2(new Team(results.getInt("team2ID")));
			matchObj.setTeam1Score(results.getInt("score1"));
			matchObj.setTeam2Score(results.getInt("score2"));
			matchObj.setStatus(Tournament.intToStatus(results
					.getInt("statusID")));
			matchObj.setRoundNumber(results.getInt("roundNumber"));
			matchObj.setTournamentId(results.getInt("tournamentID"));
		} catch (Exception e) {
			System.out.println("error in building the user object");
		}
		return matchObj;
	}

}
