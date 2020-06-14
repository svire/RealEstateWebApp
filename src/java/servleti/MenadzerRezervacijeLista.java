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
import beans.*;
import pomocni.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class MenadzerRezervacijeLista extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs1=null;
        
        ArrayList<Rezervacije> cekanje=new ArrayList<Rezervacije>(); 
        
        
        kon=Konekcija2.getConnection();
        try{
            stmt=kon.createStatement();
            String podaci="select * from rezervacije";
            
            rs1=stmt.executeQuery(podaci);
            
            while(rs1.next()){
                Rezervacije rez=new Rezervacije();
                
                rez.setRezervacijaId(rs1.getInt(1)); 
                rez.setNekretninaId(rs1.getInt(2));
                rez.setKorisnikId(rs1.getInt(3));
                rez.setBookingStatus(rs1.getString(4));
                rez.setBookingStartDate(rs1.getString(5));
                rez.setBokkingEndDate(rs1.getString(6));
                rez.setDetalji(rs1.getString(7));
                
                cekanje.add(rez);
                
                
            }
            
        }
        catch(SQLException ex)
        {
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
        }
        
        finally{
            if(rs1!=null) {try{ rs1.close(); }catch(SQLException ex) {}   }
            if(stmt!=null) {try{ stmt.close(); }catch(SQLException ex) {}   }
            if(kon!=null)  {try{  kon.close(); }catch(SQLException ex) {}   }
            
        }
        
        
        request.setAttribute("lista", cekanje);
        request.getRequestDispatcher("MenadzerRezervacije1.jsp").forward(request, response);
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
