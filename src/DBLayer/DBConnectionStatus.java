package DBLayer;

import UILayer.MainUI;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.SQLException;

/**
 * Created by Andreas on 27-05-2015.
 */
public class DBConnectionStatus extends Thread {
    SQLServerDataSource dataSource = DBConnection.getInstance().getDataSource();
    public DBConnectionStatus() {
        super();
    }

    public void run(){

        while (true) {

            try {

                Thread.sleep(1000*10);
                if(dataSource.getConnection() != null)
                {
                    MainUI.setDBStatus(true);
                    //System.out.println("Connection to DB is ok");
                    MainUI.updateData();

                }

            } catch (InterruptedException e) {
                System.out.println("Thread were closed!");
                MainUI.setDBStatus(false);
            } catch (SQLException e) {
                System.out.println("Can not connect to the DB");
                MainUI.setDBStatus(false);

            } finally {
                try {
                    dataSource.getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
