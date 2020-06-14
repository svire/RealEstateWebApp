/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;
import beans.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Djole
 */
public class Username {
    
    
    private int id;
    private String username;
    
    public int getId(){
        return id;
    }
    
    public static String getUsername(int id){
        
        String username="";
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        String query="select username from korisnik where korisnikID='"+id+"'";
        
        try{
            
            
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
                username=rs.getString(1);
            }
            rs.close();
            stmt.close();
            kon.close();
        
        }
        catch(SQLException ex){
            
             System.out.println("Greska u radu sa bazom");
        }
        finally {
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
            if(rs!=null) {   try{  rs.close(); }   catch(Exception exc){}  }
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
        }
        
         return username;
       
    }
    
    
}
