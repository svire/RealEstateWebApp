/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import beans.Konekcija2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import beans.*;
/**
 *
 * @author Djole
 */
public class Slike {
    
    public static ArrayList<NekretnineSlike> getSlike(int nekid){
        
        
       // String[] linkovi=new String[10];
        int lin=0;
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        
        ArrayList<NekretnineSlike> nizslika=new ArrayList<NekretnineSlike>(); 
        
        String slike="select * from nekretnine_slike where nekretnina_id='"+nekid+"'";
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(slike);
            while(rs.next()){
                //linkovi[lin]=rs.getString(3);
                NekretnineSlike sli=new NekretnineSlike();
                
                sli.setId(rs.getInt(1));
                sli.setNaziv(rs.getString(3));
                sli.setTitle(rs.getString(6));
                nizslika.add(sli);
                
                 
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
        
       
        
        
        return nizslika;
    }
    
}
