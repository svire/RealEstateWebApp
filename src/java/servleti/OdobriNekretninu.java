
package servleti;

import beans.*;
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
public class OdobriNekretninu extends HttpServlet {

   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
        String status=request.getParameter("status");
        String upit="update nekretnina set status='"+status+"' where nekretnina_id="+id;
        
        if(status.equals("AKTIVAN"))
        {
         request.setAttribute("poruka","Odobren oglas!");
        }
        else{
            request.setAttribute("poruka","Obrisan oglas!");
        }
        
        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(upit);
            
            
        }
        catch(SQLException ex){
            request.setAttribute("poruka", "Greska u radu sa bazom");
            
            
        }
        
        request.getRequestDispatcher("MenadzerNoveNekretnine?biraj=SVE").forward(request, response);
        
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
