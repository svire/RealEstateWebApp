/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Konekcija;
import beans.Korisnik;
import beans.Poruka;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class ProcitajPoruku extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
        
        String redirect="";
        HttpSession s=request.getSession();
        Korisnik kor=new Korisnik();
        
        kor=(Korisnik)s.getAttribute("korisnik");
        String pozicija=kor.getPozicija();
        
        
        if(pozicija.equals("klijent")){
            redirect="KlijentProcitajPoruku.jsp";
        }
        if(pozicija.equals("menadzer")){
            redirect="MenadzerProcitajPoruku.jsp";
        }
        if(pozicija.equals("admin")){
            
            redirect="AdminProcitajPoruku.jsp";            
        }
        if(pozicija.equals("korisnik")){
            
            
            redirect="KorisnikProcitajPoruku.jsp";
        }
        
        
        
        Konekcija kon=new Konekcija();
        ResultSet rs;
        Poruka por2=new Poruka();
        
        String porukeinbox="select * from poruka where poruka_id='"+id+"'";
        rs=kon.query(porukeinbox);
        try{
        while(rs.next()){
           
            por2.setPorukaId(rs.getInt(1));
            por2.setOdId(rs.getInt(2));
            por2.setZaId(rs.getInt(3));
            por2.setTema(rs.getString(4));
            por2.setSadrzaj(rs.getString(5));
            por2.setVrijeme(rs.getDate(6));
            por2.setReadd(rs.getBoolean(7));            
                                  
        }
        rs.close();        
          
        
        request.setAttribute("citaj", por2);
        request.getRequestDispatcher(redirect).forward(request, response);
        
        
        }
                
        catch(SQLException e)
        {
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher(redirect).forward(request, response);
        }
        
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
