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
public class Prosjecna {
    
    public static String[] getProsjecna(int nekid){
        
        String[] prosjecna=new String[2];
        prosjecna[0]="0.0";
        prosjecna[1]="0";
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        int brojev=0;
        int suma=0;
        String prosjecnast="select recenzije.ocjena from recenzije where nekretnina_id='"+nekid+"'";
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(prosjecnast);
            while(rs.next()){
                suma+=rs.getInt(1);
                brojev++;
                
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
         Double ocjena=0.0;   
            if(brojev!=0){
            Double fsuma=Double.parseDouble(String.valueOf(suma));
            Double fcount=Double.parseDouble(String.valueOf(brojev));
            ocjena=fsuma/fcount;
                 }
        
        
         prosjecna[0]=ocjena.toString();
         prosjecna[1]=String.valueOf(brojev);
        
        //                <%
             //   DecimalFormat dec = new DecimalFormat("#0.0");
        return prosjecna;
    }
    
}
