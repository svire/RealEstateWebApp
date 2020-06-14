/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author Djole
 */
public class KorRezervacije {
    
    public static String[] getInfo(int nekid){
        
      
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        
        String qvery="select nekretnina.grad,nekretnina.ulica from nekretnina where nekretnina_id='"+nekid+"'";  
        String[] info=new String[3];
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(qvery);
            while(rs.next()){
                info[0]=rs.getString(1);
                info[1]=rs.getString(2);
                
               
                
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
                 if(rs!=null) { try{ rs.close();    } catch(SQLException ex){}  }
            }
        
      
        return info;
    }
    
}
