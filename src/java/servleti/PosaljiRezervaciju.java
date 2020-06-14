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
public class PosaljiRezervaciju extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses=request.getSession();
        Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
        int korid=kor.getKorisnikID();
        
        int bookid=0;        
        String pozicija="";
        HttpSession s=request.getSession();
        
        
         
         //sad pravi to
        String redirect="KorisnikRezervacije";
         
        String nekid=request.getParameter("id");      
        String from=request.getParameter("from");      
        String to=request.getParameter("to");
        
        from=from.replace("/", "-");
        to=to.replace("/", "-");        
        
        String bookingstatus="CEKANJE";
        String detalji=request.getParameter("detalji");
          
        String insert="INSERT INTO rezervacije VALUES (null,'"+nekid+"','"+korid+"','"+bookingstatus+"','"+from+"','"+to+"','"+detalji+"')";
 
        
        Connection kon=null;
        Statement stmt=null;
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(insert);
            
        }
        catch(SQLException ex){
            
            request.setAttribute("poruke", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher("KorisnikPocetna.jsp").forward(request, response);
            
            
        }
       
       
       s.setAttribute("poruka","Rezervacija poslata!");
       response.sendRedirect(redirect);

 
       
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
        
        
    }

}
