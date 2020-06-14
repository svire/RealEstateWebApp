/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;
import java.sql.*;
import beans.*;
/**
 *
 * @author Djole
 */
public class Opis {
    
    
   public static String getOpis(int nekid){
        
        String opis="";
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        String upit="select * from opis where nekretnina_id='"+nekid+"'";
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(upit);
            while(rs.next()){
                opis=rs.getString(3);
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
        
       
        
        
        return opis;
    }
    
    
}
