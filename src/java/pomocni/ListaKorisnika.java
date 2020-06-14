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
public class ListaKorisnika {
    
     public static ArrayList<Korisnik> getInfo(){
        
      
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        ArrayList<Korisnik> korisnici=new ArrayList<Korisnik>();
        
        String kver="select korisnikID,username from korisnik";    
        String[] info=new String[3];
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(kver);
            while(rs.next()){
                
                Korisnik kor=new Korisnik();                
                kor.setKorisnikID(rs.getInt(1));
                kor.setUsername(rs.getString(2));                
                korisnici.add(kor);
               
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
        
      
        return korisnici;
    }
    
}
