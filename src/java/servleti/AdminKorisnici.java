package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.*;
/**
 *
 * @author Djole
 */
public class AdminKorisnici extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Korisnik> listaKorisnika=new ArrayList<Korisnik>();
        
        HttpSession s=request.getSession();
        Connection kon=null;  
        ResultSet rs=null;
        Statement stmt=null;
        try{
            kon=Konekcija2.getConnection();
            String upit="select * from korisnik";
        
           
            
            stmt=kon.createStatement();
            rs=stmt.executeQuery(upit);
            while(rs.next()){
                Korisnik korisnik=new Korisnik();
                korisnik.setKorisnikID(rs.getInt(1));
                korisnik.setIme(rs.getString(2));
                korisnik.setPrezime(rs.getString(3));
                korisnik.setUsername(rs.getString(4));
                korisnik.setPassword(rs.getString(5));
                korisnik.setAdresa(rs.getString(6));
                korisnik.setEmail(rs.getString(7));
                korisnik.setTelefon(rs.getString(8));
                korisnik.setPozicija(rs.getString(9));
               
                
                listaKorisnika.add(korisnik);
            }
            
             
            request.setAttribute("korisnici", listaKorisnika);
            request.getRequestDispatcher("AdminKorisnici.jsp").forward(request, response);
        
        } catch(SQLException e)
           {
              
               
                request.setAttribute("poruka", "Greska u radu sa bazom");
                request.getRequestDispatcher("AdminKorisnici.jsp").forward(request, response);
         
           }
        finally{
             if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
             if(rs!=null) {   try{  rs.close(); }   catch(Exception exc){}  }
             if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }
            
            
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
