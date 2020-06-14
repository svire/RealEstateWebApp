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
public class KorisnikPocetna extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
         String redirect="";
         String pozicija="";
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         if(kor!=null){
         int korid=kor.getKorisnikID();
         pozicija=kor.getPozicija();
         }
         if(kor==null){
             
             redirect="PosjetilacPocetna.jsp";
         }
         
         if(pozicija.equals("korisnik")){
             
              redirect="KorisnikPocetna.jsp";
         }
         ArrayList<Nekretnina> listaProdaja=new ArrayList<Nekretnina>();
              
        
        
         Connection kon=null;
         Statement stmt=null;
         
           ResultSet rs=null,rs1;    
        
         try{
             
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            
             
            
            int brojredova=0;
            String profilna="minus2020.png"; 
            String kveri="select nek.nekretnina_id,nek.grad,nek.ulica,nek.tip,nek.kvadratura,nek.broj_soba,nek.godina_izgradnje,nek.garaza from nekretnina nek inner join favourites fav on fav.nekretnina_id=nek.nekretnina_id inner join korisnik kor on kor.korisnikID=fav.korisnik_id where kor.pozicija='menadzer'";
            
            
            rs=stmt.executeQuery(kveri);
            while(rs.next()){
                                
                Nekretnina nek=new Nekretnina();
                
                nek.setNekretninaId(rs.getInt(1));
                nek.setGrad(rs.getString(2));               
                nek.setUlica(rs.getString(3));
                nek.setTip(rs.getString(4));               
                nek.setVelicina(rs.getInt(5));
                nek.setBrojSoba(rs.getInt(6));
                nek.setGodinaIzgradnje(rs.getInt(7));
                nek.setGaraza(rs.getString(8));
                
                listaProdaja.add(nek);                
            }
            
           
             if(listaProdaja.size()==0){
               request.setAttribute("prodaja", listaProdaja);
               request.setAttribute("poruka", "Druze moj nema tih rez");
               
               
             }
             if(listaProdaja.size()>0){
              
               request.setAttribute("prodaja", listaProdaja);
               
             }       
            request.getRequestDispatcher(redirect).forward(request, response);
               
           
        } catch(SQLException e)
           {               
                request.setAttribute("poruka", "ne radi nesto");
                request.getRequestDispatcher(redirect).forward(request, response);
           }
         finally{
             if(rs!=null){ try{ rs.close();} catch(SQLException ex){} }
             if(stmt!=null){ try{ stmt.close();} catch(SQLException ex){} }
             if(kon!=null){ try{ kon.close();} catch(SQLException ex){} }
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
