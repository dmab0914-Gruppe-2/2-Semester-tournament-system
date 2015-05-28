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
		return miscWhere("");
	}

	@Override
	public User findUserByHandle(String handle) {
		String wClause =" handle = '" + handle + "'";
		return singleWhere(wClause);
	}

	@Override
	public User findUserByName(String name) {
		String wClause =" name = '" + name + "'";
		return singleWhere(wClause);
	}

	@Override
	public User findUserById(int id) {
		String wClause =" id = '" + id + "'";
		return singleWhere(wClause);
	}

	@Override
	public int insertUser(User user) throws Exception {
		int rc = -1;
		String query = "INSERT INTO dbo.[User](handle,name,password,isAdmin) VALUES('"
				+ user.getHandle()
				+ "','"
				+ user.getName()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.isAdmin() + "')";
		
		System.out.println("insert : " + query);
		try { // insert new User
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}// end try
		catch (SQLException ex) {
			System.out.println("insert exception in user db:");
			throw new Exception("User is not inserted correct");
		}
		return (rc);
	}

	@Override
	public int updateUser(User user) {
		int rc = -1;
		String query = "UPDATE dbo.[User] SET " + "handle = '" + user.getHandle()
				+ "', " + "name ='" + user.getName()
				+ "', " + "password ='" + user.getPassword()
				+ "', " + "isAdmin ='" + user.isAdmin() +"' WHERE id = '"
				+ user.getUserID() + "'";
		
		System.out.println("Update query:" + query);

		try { // update user
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);

			stmt.close();
		}// slut try
		catch (Exception ex) {
			System.out.println("Update exception in user db: " + ex);
		}

		return rc;
	}

	@Override
	public int deleteUser(int id) {
		int rc = -1;
		
		String query = "DELETE FROM dbo.[User] WHERE id = '" + id + "'";
		System.out.println("DELETE query: " + query);
		
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		} catch(Exception ex) {
			System.out.println("Delete exception in User db: " + ex);
		}
		return rc;
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
		//This were kinda annoying with constant updates
		//System.out.println(query);
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

		String query = "SELECT * FROM dbo.[User]";

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
