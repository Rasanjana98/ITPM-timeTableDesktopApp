package Database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://itpmdatabase.mysql.database.azure.com:3309/timetablemanagementsystem";
            Connection con = DriverManager.getConnection(url, "itpm_we05@itpmdatabase", "20Kuruppu");
            System.out.println("Database Connection Successfull!!");
            return con;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }


//save update delete
public static void setData(String sql) throws Exception {
        Database.getConnection().createStatement().executeUpdate(sql);
        
    }

    // search
    public static ResultSet getData(String sql) throws Exception {
        ResultSet executeQuery = Database.getConnection().createStatement().executeQuery(sql);
        return executeQuery;
    }

    public static ResultSet getRowCount(String sql) throws Exception {
        ResultSet executeQuery = Database.getConnection().createStatement().executeQuery(sql);
        return executeQuery;
    }
    
    public static ResultSet getlatestDetails(String sql) throws Exception {
        ResultSet executeQuery = Database.getConnection().createStatement().executeQuery(sql);
        return executeQuery;
    }
    
    

//     Statement stmt = con.createStatement();
}
