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
public class PorukeKorisnika extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sesija1=request.getSession(); 
        Korisnik koris=new Korisnik();
        koris=(Korisnik)sesija1.getAttribute("korisnik");
        
        int korId=koris.getKorisnikID();
        String pozicija=koris.getPozicija();
        
        String redirect="AdminPoruke1.jsp";
        
        if(pozicija.equals("admin")){
            redirect="AdminPoruke1.jsp";
        }
        if(pozicija.equals("klijent")){
            redirect="KlijentPoruke1.jsp";
        }
        if(pozicija.equals("korisnik")){
            redirect="KorisnikPoruke1.jsp";
        }
        if(pozicija.equals("menadzer")){
            redirect="MenadzerPoruke1.jsp";
        }
        
        
        ArrayList<Poruka> listaDolaznih=new ArrayList<Poruka>();
        ArrayList<Poruka> listaOdlaznih=new ArrayList<Poruka>();
        
        Connection kon=null;
        Statement stmt=null;     
        ResultSet rs=null;
        
        
        try{
            
             kon=Konekcija2.getConnection();
             String porukeinbox="select * from poruka where poruka.za_id='"+korId+"' order by vrijeme desc";
             
             stmt=kon.createStatement();
             rs=stmt.executeQuery(porukeinbox);
            
            
        while(rs.next()){
            Poruka por2=new Poruka();
            por2.setPorukaId(rs.getInt(1));
            por2.setOdId(rs.getInt(2));
            por2.setZaId(rs.getInt(3));
            por2.setTema(rs.getString(4));
            por2.setSadrzaj(rs.getString(5));
            por2.setVrijeme(rs.getDate(6));
            por2.setReadd(rs.getBoolean(7));            
            
            listaDolaznih.add(por2);           
        }
        rs.close(); 
        stmt.close();
         
        
        request.setAttribute("listaDolaznih", listaDolaznih);
        //request.getRequestDispatcher(redirect).forward(request, response);
          
        }
        catch(SQLException e)
        {
            request.setAttribute("poruka","Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher(redirect).forward(request, response);
            
        }
        
        try{
            
              
             String porukeinbox="select * from poruka where poruka.od_id='"+korId+"' order by vrijeme desc";
             
             stmt=kon.createStatement();
             rs=stmt.executeQuery(porukeinbox);
            
            
        while(rs.next()){
            Poruka por2=new Poruka();
            por2.setPorukaId(rs.getInt(1));
            por2.setOdId(rs.getInt(2));
            por2.setZaId(rs.getInt(3));
            por2.setTema(rs.getString(4));
            por2.setSadrzaj(rs.getString(5));
            por2.setVrijeme(rs.getDate(6));
            por2.setReadd(rs.getBoolean(7));            
            
            listaOdlaznih.add(por2);           
        }
        rs.close(); 
        stmt.close();
        kon.close();
        
        request.setAttribute("listaOdlaznih", listaOdlaznih);
       // request.getRequestDispatcher(redirect).forward(request, response);
          
        }
        catch(SQLException e)
        {
            if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
            if(rs!=null) {   try{  rs.close(); }   catch(Exception exc){}  }
            if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
            request.setAttribute("poruka","Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher(redirect).forward(request, response);
            
        }
        request.getRequestDispatcher(redirect).forward(request, response);
        
       
        
        
        
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
