/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;
import beans.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class Profilna1 {
    
    
    private int id;
    private String link;
    
   public int getId() {
      return id;
   }
   public void setId( int id ) {
       
       
      String profilna="noimage.png";
         Connection kon=null;
         Statement stmt=null;
         ResultSet rs=null;
         
         int redovi=0;
         String kveri="select naziv from nekretnine_slike where nekretnine_slike.title='profile' and nekretnina_id='"+id+"'";
         
         
         try{ 
             
             kon=Konekcija2.getConnection();
             stmt=kon.createStatement();
             rs=stmt.executeQuery(kveri);
             
             
            while(rs.next()){
                    profilna=rs.getString(1);
                    redovi++;            
                           
                     } 
            }
           catch(SQLException ssql){
            
             }
           finally{
             if(rs!=null){ try { rs.close(); } catch(SQLException ex){ } }
             if(stmt!=null){ try { stmt.close(); } catch(SQLException ex){ } }
             if(kon!=null){ try { kon.close(); } catch(SQLException ex){ } }
             
          }
        
         this.link=profilna;
         this.id = id;
   }
     public String getLink() {
      return link;
   }
   public void setName( String link ) {
      this.link = link;
   }
   
   
    
    
}
