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
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class BrisanjePoruka extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesija=request.getSession(); 
        Korisnik kor=(Korisnik)sesija.getAttribute("korisnik");
        
        String pozicija="";
        pozicija=kor.getPozicija();        
        String redirect="PorukeKorisnika";
        
        
        String id=request.getParameter("id");
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        String upit="delete from poruka where poruka_id='"+id+"'"; 
        try{
            
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(upit);
            stmt.close();
            kon.close();
           
        }
        catch(SQLException ex){
            
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
            if(rs!=null) {   try{  rs.close(); }   catch(Exception exc){}  }
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher(redirect).forward(request, response);
            
        }
        finally{
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
            if(rs!=null) {   try{  rs.close(); }   catch(Exception exc){}  }
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
        }
       
        sesija.setAttribute("poruka", "Uspjesno obrisana poruka!");
       
        response.sendRedirect(redirect);
       
        
      
    }

   
    

    @Override
    public String getServletInfo() {
        
        return "Short description";
    }

}
