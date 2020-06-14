/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import beans.*;
import java.util.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class ObrisiSliku extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         String nekid=request.getParameter("nekid");         
         String redirect="KlijentObrisiSliku.jsp?id="+nekid;
         String brisi=request.getParameter("brisi");
         
         Connection kon=null;
         Statement stmt=null;
         ResultSet rs=null;         
         String obrisi="DELETE FROM nekretnine_slike WHERE id='"+brisi+"'";
         
         try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(obrisi);
         }
         catch(SQLException ex){
             request.setAttribute("poruka", "Doslo je do greske prilikom brisanja slike");
             request.getRequestDispatcher(redirect).forward(request, response);             
          }
         finally{
             if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
             if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
         }
         
         
         
         
         request.setAttribute("poruka", "Uspjesno obrisana slika");
         request.getRequestDispatcher(redirect).forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
