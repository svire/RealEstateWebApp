/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;
import beans.*;
import java.sql.*;

/**
 *
 * @author Djole
 */
public class Rezervisano {
    
    public static String[] getRezervisano(int nekid){
         
        String date="dsa";
        int br=0;
        String[] niz2=new String[20];
        
        
             
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select * from rezervacije where nekretnina_id='"+nekid+"'";
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               niz2[br]=rs.getString(5);
               br++;
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
        
        return niz2;
    }
    
}
