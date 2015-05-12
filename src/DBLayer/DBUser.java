package DBLayer;

import java.util.ArrayList;
import java.sql.*;

import ModelLayer.User;

public class DBUser implements IFDBUser {
	private Connection con;

	public DBUser() {
		con = DBConnection.getInstance().getDBcon();
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByHandle(String handle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inserUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Help methods. NOT IN IF!
	// private methods
	/**
	 * miscWhere is used whenever we want to select more than one user
	 * 
	 * @param wClause
	 * @return list of user
	 */
	private ArrayList<User> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<User> list = new ArrayList<User>();

		String query = buildQuery(wClause);

		try { // read the user from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				User userObj = new User();
				userObj = buildUser(results);
				list.add(userObj);
			}// end while
			stmt.close();
		}// slut try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * method to get one user
	 * 
	 * @param wClause
	 * @return one user
	 */
	private User singleWhere(String wClause) {
		ResultSet results;
		User userObj = new User();

		String query = buildQuery(wClause);
		System.out.println(query);
		try { // read the employee from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next()) {
				userObj = buildUser(results);
				// assocaition is to be build
				stmt.close();

			} else { // no employee was found
				userObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return userObj;
	}

	/**
	 * method to buildquery
	 * 
	 * @param wClause
	 * @return query
	 */
	private String buildQuery(String wClause) {

		String query = "SELECT * FROM User";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	/**
	 * method to build a user object
	 * 
	 * @param results
	 * @return a user object
	 */
	private User buildUser(ResultSet results) {
		User userObj = new User();
		try { // the columns from the table user are used
			userObj.setUserID(results.getInt("id"));
			userObj.setHandle(results.getString("handle"));
			userObj.setName(results.getString("name"));
			userObj.setPassword(results.getString("password"));
			userObj.setAdmin(results.getBoolean("isAdmin"));
		} catch (Exception e) {
			System.out.println("error in building the user object");
		}
		return userObj;
	}

}
