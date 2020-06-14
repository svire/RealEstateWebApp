
package pomocni;
import java.sql.*;
import beans.*;

/**
 *
 * @author Djole
 */
public class Najvise {
    
    public Najvise(int nekid){
        
        Konekcija kon=new Konekcija();
        ResultSet rs,rs1;
                
        String provjera="select * from mostviewed where nekretnina_id='"+nekid+"'";
        rs=kon.query(provjera);
        int redovi=0;
        
        try{            
            while(rs.next()){
           
                redovi++;            
                           
                            } 
            }
        catch(SQLException ssql){
            
        }
        if(redovi==0){
            String insert="insert into mostviewed values('"+nekid+"','1','0')";
            kon.insert(insert);
        }
        else{
            String update="UPDATE mostviewed SET broj_posjeta=broj_posjeta+1 WHERE nekretnina_id='"+nekid+"'";
            kon.insert(update);
            
                       
            
        }
        
        
    }
    
}
