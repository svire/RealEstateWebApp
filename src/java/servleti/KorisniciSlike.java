package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import beans.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class KorisniciSlike extends HttpServlet {

  
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
        
        ArrayList<NekretnineSlike> slikelista=new ArrayList<NekretnineSlike>();
        String redirect="";
        HttpSession s=request.getSession();
        Korisnik kor=new Korisnik();
        String pozicija="";
        kor=(Korisnik)s.getAttribute("korisnik");
        
        if(kor!=null){
        pozicija=kor.getPozicija();
        }
        
        if(kor==null){
            redirect="PosjetilacSlike.jsp";
        }
        if(pozicija.equals("korisnik")){
            redirect="KorisnikSlike.jsp";
        }
        
       
        
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        
        String slike1="SELECT * FROM nekretnine_slike WHERE nekretnina_id='"+id+"'";
     
        
        try{
            
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(slike1);
            
        while(rs.next()){
            NekretnineSlike slibe=new NekretnineSlike();
            slibe.setId(rs.getInt(1));
            slibe.setNaziv(rs.getString(3));
            slibe.setTitle(rs.getString(6));
            
            
            slikelista.add(slibe);
        }
        
        
        request.setAttribute("slibe", slikelista);
        request.getRequestDispatcher(redirect).forward(request, response);
        
        
        }
                
        catch(SQLException e)
        {
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher(redirect).forward(request, response);
        }
        finally{
            if(rs!=null) {  try{rs.close();}catch(SQLException ex){}   }
            if(stmt!=null) {  try{stmt.close();}catch(SQLException ex){}   }
            if(kon!=null) {  try{kon.close();}catch(SQLException ex){}   }
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
