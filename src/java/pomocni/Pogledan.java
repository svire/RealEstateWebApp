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
public class Pogledan {
    
    public static int getPogledan(int vidjen){
        
        int broj=0;
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        String upit="select broj_posjeta from mostviewed where nekretnina_id='"+vidjen+"'";
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(upit);
            while(rs.next()){
                broj=rs.getInt(1);
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
        
        
        
        
        
        
        return broj;
    }
    
}
