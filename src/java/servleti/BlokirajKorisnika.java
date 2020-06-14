package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class BlokirajKorisnika extends HttpServlet {

   

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String korid=request.getParameter("korid");   
        String upit="update korisnik set pozicija='BLOKIRAN' where korisnikID='"+korid+"'";   
        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(upit);
            
        }
        catch(SQLException ex){
             request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
             request.getRequestDispatcher("AdminPocetna.jsp").forward(request, response);
        
            
        }
        finally{
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} }          
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }           
        }
      
        
        request.setAttribute("poruka", "Uspjesno ste blokirali korisnika");
        request.getRequestDispatcher("AdminPocetna.jsp").forward(request, response);
    }

   

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
