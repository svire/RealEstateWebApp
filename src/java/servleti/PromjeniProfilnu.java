/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
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
public class PromjeniProfilnu extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         String pozicija=kor.getPozicija();
         String redirect="KlijentMojeNekretnine1?biraj=SALE";
         
         
        String idslike=request.getParameter("profile");
        String nekid=request.getParameter("nekid");
        int nekidint=Integer.parseInt(nekid);
        String update="update nekretnine_slike set title='not' where nekretnina_id='"+nekidint+"'";
        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(update);   //stavi sve na not
            
            if(idslike!=null){
                int idslikeint=Integer.parseInt(idslike);
                String update1="update nekretnine_slike set title='profile' where  id='"+idslikeint+"' and nekretnina_id='"+nekidint+"'";
                stmt=kon.createStatement();
                stmt.executeUpdate(update1);
                
                request.setAttribute("poruka", "Updejtovana profilna slika za nekretninu!");
                request.getRequestDispatcher(redirect).forward(request, response);
                
            }
            else{
            request.setAttribute("poruka", "Izaberi jednu sliku za profilnu nekretnine");
            request.getRequestDispatcher(redirect).forward(request, response);
            
        }
            
        }
        catch(SQLException ex){
             request.setAttribute("poruka", "Doslo je do greske pri promjeni profilne slike!");
             request.getRequestDispatcher(redirect).forward(request, response);
            
        }
        finally{
            if(kon!=null){ try{ kon.close(); } catch(SQLException ex){}}
            if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){}}
        }
      
      
        
        
     
        
    }

   

    

}
