package DBLayer;

import UILayer.MainUI;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Andreas on 27-05-2015.
 */
public class DBConnectionStatus extends Thread {
    public DBConnectionStatus() {
        super();
    }

    public void run(){

        while (true) {

            try {

                Thread.sleep(1000);
                SQLServerDataSource dataSource = new SQLServerDataSource();
                dataSource.setUser("sa");
                dataSource.setPassword("isAllowed");
                dataSource.setPortNumber(1433);
                dataSource.setDatabaseName("TournamentPlanner");

                if(dataSource.getConnection() != null)
                {
                    MainUI.setDBStatus(true);
                    System.out.println("Connection to DB is ok");
                }

            } catch (InterruptedException e) {
                System.out.println("Thread were closed!");
                MainUI.setDBStatus(false);
            } catch (SQLException e) {
                System.out.println("Can not connect to the DB");
                MainUI.setDBStatus(false);
            }
        }
    }
}
