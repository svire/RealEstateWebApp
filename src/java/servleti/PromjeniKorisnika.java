package servleti;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class PromjeniKorisnika extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s=request.getSession();
       
        String id=request.getParameter("id");
        String ime=request.getParameter("ime");
        String prezime=request.getParameter("prezime");
        String username=request.getParameter("username");
        String password=request.getParameter("password");       
        String adresa=request.getParameter("adresa");
        String email=request.getParameter("email");
        String telefon=request.getParameter("telefon");
       
        String pozicija=request.getParameter("pozicija");
        
        Connection kon=null;
        Statement stmt=null;
        
        if(ime!=null&&ime.length()>0&&prezime!=null&&prezime.length()>0&&username!=null&&username.length()>0&&
          password!=null&&password.length()>0&&adresa!=null&&adresa.length()>0
          &&email!=null&&email.length()>0&&telefon!=null&&telefon.length()>0)
          {
        
            try{
                kon=Konekcija2.getConnection();
                stmt=kon.createStatement();
                String upit="update korisnik set ime='"+ime+"',prezime='"+prezime+"',username='"+username+
                    "',password='"+password+"',adresa='"+adresa+"',email='"+email+"',telefon='"+telefon+"',pozicija='"+pozicija+"'where korisnikID='"+id+"'";
         
                stmt.executeUpdate(upit);
                
                request.setAttribute("poruka", "Uspjesno ste promjenili podatke o korisniku");        
                request.getRequestDispatcher("AdminPocetna.jsp").forward(request, response);
            
            }
            catch(SQLException exc){
                request.setAttribute("poruka", "Doslo je do greske u radu sa bazom.");
                request.getRequestDispatcher("AdminPocetna.jsp").forward(request, response);
            }
            finally{
                if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }   
                
            }
         
       
       
       
        
      
      
       }
       else{
           request.setAttribute("poruka", "Popunite sva polja");
           request.getRequestDispatcher("AdminKorisniciMjenjaj.jsp").forward(request, response);
        }
    }

}
