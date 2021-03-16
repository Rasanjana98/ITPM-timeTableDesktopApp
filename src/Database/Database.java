package Database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database {
    
       // create connection
    
    public static Connection con;
    
    public static Connection getConnection() throws Exception{
        
          String dbpath = "jdbc:mysql://localhost:3306/timetablemanagementsystem";
          String user = "root";
          String pass ="1234";
        
//        try{
//          File file = new File("e:\\RZKTechnology\\Configurations\\db_config.txt");
//          dbpath = Files.readAllLines(file.toPath()).get(0);
//          user = Files.readAllLines(file.toPath()).get(1);
//          pass = Files.readAllLines(file.toPath()).get(2);
//        
//      } 
//      catch(IOException e){
//        System.out.println(e);
//      }
//        
        
        
        if(con == null){
        Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbpath, user, pass);
        }
        
        
        return con;
    }
    
    //save update delete
    
    public static void setData(String sql)throws Exception{  
       Database.getConnection().createStatement().executeUpdate(sql);
    }
    
    // search
    
    public static ResultSet getData(String sql)throws Exception{
        ResultSet executeQuery = Database.getConnection().createStatement().executeQuery(sql);
        return executeQuery;
    }
    
}
