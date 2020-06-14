
package servleti;

import beans.Konekcija;
import beans.Konekcija2;
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
public class KreirajKorisnika extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesija=request.getSession();
        String ime=request.getParameter("ime");
        String prezime=request.getParameter("prezime");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password1=request.getParameter("password1");
        String adresa=request.getParameter("adresa");
        String email=request.getParameter("email");
        String telefon=request.getParameter("telefon");
        
        String pozicija=request.getParameter("pozicija");
        
        int id=0;
         Connection kon=Konekcija2.getConnection();
         Statement stmt=null;
         ResultSet rs=null; 
         ResultSet rs1=null;
         
         
         String provjera="select * from korisnik where username='"+username+"'";
         try
            {
                   stmt=kon.createStatement();
                   rs1=stmt.executeQuery(provjera);
                   
                   
                   if(rs1.next())
                   {
                       
                      request.setAttribute("poruka", "Postoji korisnik sa takvim username-om");
                      request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request, response);
                       
                   }
        else{
         
        if(ime!=null&&ime.length()>0&&prezime!=null&&prezime.length()>0&&username!=null&&username.length()>0&&
          password!=null&&password.length()>0&&password1!=null&&password1.length()>0&&adresa!=null&&adresa.length()>0
          &&email!=null&&email.length()>0&&telefon!=null&&telefon.length()>0)
        {
               if(password.equals(password1))
               {                  
                  
                
               String prazan=""; //ni
               String upit="insert into korisnik values(null,'"+ime+"','"+prezime+"','"+username+"','"+password+"','"+adresa+"','"+email+"','"+telefon+"','"+pozicija+"')";
               
              
               stmt.executeUpdate(upit);
                
               
               
               request.setAttribute("poruka","Uspjesno dodan korisnik.");
               request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request, response);
                  
                 }
                 
               else
               {
               
               request.setAttribute("poruka", "Passwordi se razlikuju!");
               request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request, response);
               }
               
        }
       
        else
        {
             request.setAttribute("poruka", "Unesi sve parametre");
             request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request, response);
       
        }
       
            
        }
                    
               }
                   catch(SQLException ex5)
               {
                   request.setAttribute("poruka", "Greska u radu sa bazom");
                   request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request, response);
                   
               } 
         
         finally{
             if (rs1 != null) try { rs1.close(); } catch (SQLException logOrIgnore) {}
             if (stmt != null) try { stmt.close(); } catch (SQLException logOrIgnore) {}
             if (kon != null) try { kon.close(); } catch (SQLException logOrIgnore) {}
         }
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } 

}
