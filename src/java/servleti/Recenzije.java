package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import beans.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author Djole
 */
public class Recenzije extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         String pozicija="";
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         if(kor!=null)
         {
             pozicija=kor.getPozicija();
         }
         String redirect=""; //radi ovdje ga baci ako nisi ulogovan empty
         
         
         if(kor==null){    
         redirect="PosjetilacRecenzije.jsp";
                      }
         
         
         if(pozicija.equals("klijent")){
             
                 redirect="KlijentRecenzije.jsp";
         
            }  
         
         if(pozicija.equals("menadzer")){
             redirect="MenadzerRecenzije.jsp";
         }
         if(pozicija.equals("korisnik")){
             redirect="KorisnikRecenzije.jsp";
         }
        
        
        
         ArrayList<Recenzija> recenzije=new ArrayList<Recenzija>(); 
        
         
         
         
         String nekid=request.getParameter("id");
         String qvery="SELECT * from recenzije where nekretnina_id='"+nekid+"'";   
         
         Connection kon=null;
         Statement stmt=null;
         ResultSet rs=null;
       
         
         // salji i nekretnina ID!
         int nekidint=Integer.parseInt(nekid);
         request.setAttribute("nekid", nekidint);
         
         try{
             
             kon=Konekcija2.getConnection();
             stmt=kon.createStatement();
             rs=stmt.executeQuery(qvery);
             while(rs.next()){
                 
                 Recenzija rec=new Recenzija();
                 rec.setRecenzijeId(rs.getInt(1));
                 rec.setNekretninaId(rs.getInt(2));
                 rec.setKorisnikId(rs.getInt(3));
                 rec.setNaslov(rs.getString(4));
                 rec.setOcjena(rs.getInt(5));
                 rec.setPozitivno(rs.getString(6));
                 rec.setNegativno(rs.getString(7));
                 rec.setDatum(rs.getString(8));
             
                 recenzije.add(rec);
                  
                                  
             }
             request.setAttribute("recenzije", recenzije);
             
         }
         catch(SQLException ex){
             request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
             request.getRequestDispatcher("greska").forward(request, response);
            
             
             
         }
         finally{
              if(rs!=null) { try{ rs.close(); } catch(SQLException ex){}   }
              if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
              if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
         }
         
           request.getRequestDispatcher(redirect).forward(request, response);
         
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
