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
public class PosaljiPoruku extends HttpServlet {

       

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        HttpSession sesija=request.getSession();        
        String tema=request.getParameter("tema");                      //tema
        String sadrzaj=request.getParameter("sadrzaj");
        String za=request.getParameter("za");
        int zaint=Integer.parseInt(za);
        
        
        Korisnik kor=(Korisnik)sesija.getAttribute("korisnik");
        int korid=kor.getKorisnikID();                                 //korisnikiD ko salje
        int menadzerid=4;                                                //menadzerID
        boolean read=false;                                  //status
        
         Connection kon=null;
         Statement stmt=null;
         
        
         try{
             
               kon=Konekcija2.getConnection();
               stmt=kon.createStatement();
               
               
               String insertporuka="insert into poruka values(null,'"+korid+"','"+zaint+"','"+tema+"','"+sadrzaj+"',CURRENT_TIMESTAMP,'0')";
               stmt.executeUpdate(insertporuka);
             
               stmt.close();
               kon.close();
               
               
               sesija.setAttribute("poruka", "Poslana poruka.");
               response.sendRedirect("PorukeKorisnika");
            
              
        }
        catch(Exception e){
            
             sesija.setAttribute("poruka",  "Greska pri slanju poruke");              
             response.sendRedirect("PorukeKorisnika");
            
        }
         finally{
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} }           
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
        }
       
        
    }

    @Override
    public String getServletInfo() {
        
        return "Short description";
    }

}
