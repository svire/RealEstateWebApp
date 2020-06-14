package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class DodajOpis extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        
        String nekid=request.getParameter("id");
        String opis=request.getParameter("opis");     
        
        HttpSession sesija=request.getSession();      
        Korisnik kor=(Korisnik)sesija.getAttribute("korisnik");
        int korid=kor.getKorisnikID();                          
        
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            
            String provjera1="select nekretnina_id from opis where nekretnina_id='"+nekid+"'"; 
            rs=stmt.executeQuery(provjera1);
      
            if(rs.next()){
                String kveri="UPDATE opis SET opis='"+opis+"',vrijeme=CURRENT_TIMESTAMP,korisnik_id='"+korid+"' WHERE nekretnina_id='"+nekid+"'";
                stmt.executeUpdate(kveri);
                request.setAttribute("poruka","Updejtovan opis za nekretninu");
                request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
                
            }
            else{
                        String insert="INSERT INTO opis VALUES (null,'"+nekid+"','"+opis+"',CURRENT_TIMESTAMP,'"+korid+"')";
                        
                        stmt.executeUpdate(insert);
                        request.setAttribute("poruka","Dodat opis za nekretninu");
                        request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);  
                
            }
        }
        catch(SQLException ex){
              request.setAttribute("poruka","Dodat opis za nekretninu");
              request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);  
            
        }
        finally{
            if(rs!=null) {try{rs.close();} catch(SQLException ex) {    }   }
            if(stmt!=null) {try{stmt.close();} catch(SQLException ex) {    }   }
            if(kon!=null) {try{kon.close();} catch(SQLException ex) {    }   }
        }
        
     
    
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

