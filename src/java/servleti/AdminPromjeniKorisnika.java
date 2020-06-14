package servleti;
import beans.*;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class AdminPromjeniKorisnika extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String korid=request.getParameter("korid");
         HttpSession ses=request.getSession();
         
         Connection kon=null;
         ResultSet rs=null;
         Statement stmt=null;
       try
       {
           kon=Konekcija2.getConnection();
           Korisnik korisnik=new Korisnik();
           String upit="select * from korisnik where korisnikID='"+korid+"'";
           
           stmt=kon.createStatement();
           rs=stmt.executeQuery(upit);
       
           
           while(rs.next())
           {
            int id=rs.getInt(1);
            String ime=rs.getString(2);
            String prezime=rs.getString(3);
            String username=rs.getString(4);
            String password=rs.getString(5);
            String adresa=rs.getString(6);
            String email=rs.getString(7);
            String telefon=rs.getString(8);
     
            String pozicija=rs.getString(9);
            korisnik.setKorisnikID(id);
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setUsername(username);
            korisnik.setPassword(password);
            korisnik.setAdresa(adresa);
            korisnik.setEmail(email);
            korisnik.setTelefon(telefon);       
            korisnik.setPozicija(pozicija);
       }
       ses.setAttribute("korisnik", korisnik);
 
       request.getRequestDispatcher("AdminKorisniciMjenjaj.jsp").forward(request, response);
       }
       catch(SQLException e)
       {
       request.setAttribute("poruka", "Greska");
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
