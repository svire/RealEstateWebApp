/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;
import java.sql.*;
import beans.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Djole
 */
public class Omiljeni {
    
    
     public static String getOmiljeni(int nekid,int korid){
        
        
        String omiljeni="ne";
        
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        
     
        
        String upit="select * from favourites where nekretnina_id='"+nekid+"' and korisnik_id='"+korid+"'";
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(upit);
            if(rs.next()){
                
                omiljeni="da";
            }
            
        }
        catch(SQLException ex)
        {            
             System.out.println("Could not connect to DB: " + ex.getMessage());
            
        }       
        finally
            {
                 if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                 if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                 if(rs!=null) { try{ rs.close(); } catch(SQLException ex){}  }
            }
        
       
        
        
        return omiljeni;
    }
    
}
