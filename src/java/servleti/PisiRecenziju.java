package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import beans.*;

public class PisiRecenziju extends HttpServlet {

  
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nekid=request.getParameter("id");
        String ocjena=request.getParameter("ocjena");
        String pozitivno=request.getParameter("pozitivno");
        String negativno=request.getParameter("negativno");
        String naslov=request.getParameter("naslov");
        
        
        int nekidint=Integer.parseInt(nekid);
        int ocjenaint=Integer.parseInt(ocjena);
        HttpSession ses=request.getSession();
        Korisnik kor=new Korisnik();
        kor=(Korisnik)ses.getAttribute("korisnik");
        int korid=kor.getKorisnikID();    


        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            
            
            
            String insert="INSERT INTO recenzije VALUES (null,'"+nekidint+"','"+korid+"','"+naslov+"','"+ocjenaint+"','"+pozitivno+"','"+negativno+"',CURRENT_TIMESTAMP)";
                     
            stmt.executeUpdate(insert);
            
            
            
            
        }
        catch(SQLException ex)
        {
         request.setAttribute("poruka", "Doslo je do greske u radu sa bazom.");
         request.getRequestDispatcher("KorisnikPocetna.jsp").forward(request, response);
        }
         finally{
            if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){ }  }    
            if(kon!=null){ try{ kon.close(); } catch(SQLException ex){ }  }
        }
        
      
       
        
         
         
         request.setAttribute("poruka", "Dodana recenzija");
         request.getRequestDispatcher("KorisnikPisiRecenzije.jsp").forward(request, response);
         
    }

   
   

}
