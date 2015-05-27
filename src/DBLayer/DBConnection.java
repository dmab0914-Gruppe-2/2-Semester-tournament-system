//usefull git command: 
//First cd into the directory where the file is located using the git console and then run the command.
//Ignore this file: git update-index --assume-unchanged DBConnection.java
//Undo ignore file: git update-index --no-assume-unchanged DBConnection.java
package DBLayer;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection {
	// Constants used to get access to the database
	// SQL Server

	//TODO Edit these in order to get Data Magic, todo to make it more visible in case you were not looking ;)
	private static String user = "";
	private static String pass = "";
	private static String conn = "";
	private static int port = ;
	private static String dbName = "";

	private static final String driver = "jdbc:sqlserver://"+conn + ":" + Integer.toString(port);	//localhost:1433"; //Connection adress to the sql server
	private static final String databaseName = ";databaseName=" + dbName; //The sql server database

	private static String userName = ";user=" + user; //sql database username
	private static String password = ";password=" + pass; //sql database password

	private DatabaseMetaData dma;
	private static Connection con;
	// an instance of the class is generated
	private static DBConnection instance = null;

	// the constructor is private to ensure that only one object of this class
	// is created
	private DBConnection() {
		String url = driver + databaseName + userName + password;

		try {
			// load af driver
			// SQL Server
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Load af class ok");

		} catch (Exception e) {
			System.out.println("Can not find the driver");
			System.out.println(e.getMessage());
		}// end catch
		try {
			// connection to the database

			con = DriverManager.getConnection(url);
			// set auto commit
			con.setAutoCommit(true);
			dma = con.getMetaData(); // get meta data
			System.out.println("Connection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name "
					+ dma.getDatabaseProductName());
		}// end try
		catch (Exception e) {

			System.out.println("Problems with the connection to the database");
			System.out.println(e.getMessage());
			System.out.println(url);
		}// end catch
	}// end constructor

	// closeDb: closes the connection to the database
	public static void closeConnection() {
		try {
			con.close();
			System.out.println("The connection is closed");
		} catch (Exception e) {
			System.out.println("Error trying to close the database "
					+ e.getMessage());
		}
	}// end closeDB

	// getDBcon: Get-method, returns the connection to the database
	public Connection getDBcon() {
		return con;
	}

	// this method is used to get the instance of the connection
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	public static void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("fejl start transaction");
			System.out.println(e.getMessage());
		}
	}

	public static void commitTransaction() {
		try {
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("fejl commit transaction");
			System.out.println(e.getMessage());
		}
	}

	public static void rollbackTransaction() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("fejl rollback transaction");
			System.out.println(e.getMessage());
		}
	}

	public static SQLServerDataSource getDataSource() {

		SQLServerDataSource dataSource = new SQLServerDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pass);
		dataSource.setPortNumber(port);
		dataSource.setDatabaseName(dbName);
		return dataSource;
	}
}// end DBConnection
