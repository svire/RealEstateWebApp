/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class Konekcija {
    Connection veza=null;
    Statement stmt;
    ResultSet rs=null;
    
    
    public Konekcija(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbUrl="jdbc:mysql://localhost:3306/zavrsni2";
            String user="root";
            String pass="";
            veza=DriverManager.getConnection(dbUrl,user,pass);
            
            
        }
        
        catch(ClassNotFoundException e){ }
        
        catch(SQLException sqle){}
        
    }
    
    public void close(){
        try{ rs.close();}catch(Exception e){}
        try{ stmt.close();}catch(Exception e){}
        try{ veza.close();}catch(Exception e){}
        
        
    }
    
    
    
    
     public void insert(String upit){
            
            if(veza!=null){
                try{
                    stmt=veza.createStatement();
                    stmt.executeUpdate(upit);
                   // veza.close();
                    
                }
                catch(SQLException sqle){
                   String error=sqle.getMessage();
                   
                }
              
            }
            
        }
     
     public ResultSet query(String upit){
            try{
                stmt=veza.createStatement();
                rs=stmt.executeQuery(upit);                
            
                return rs;
                
            }
            catch(SQLException sqle){
                String error=sqle.getMessage();
               return rs;
            }
            finally{
                //try{ rs.close();}catch(Exception e){}
                //try{ stmt.close();}catch(Exception e){}
                //try{ veza.close();}catch(Exception e){}
                }
                
            }
            
            
           
        }
     
     
