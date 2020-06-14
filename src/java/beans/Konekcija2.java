/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Djole
 */
public class Konekcija2 {
    
    public static Connection getConnection() {
        Connection conn = null;
        
        String dbUrl="jdbc:mysql://localhost:3306/zavrsni2";
        String user="root";
        String pass="";
        try {
            
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbUrl,user,pass);
        }
        catch (SQLException e) {
        System.out.println("Could not connect to DB: " + e.getMessage());
        }
        catch(ClassNotFoundException cnf){
               
        System.out.println("Could not connect to DB: " + cnf.getMessage());
        
        }
        return conn;
}
    
}
