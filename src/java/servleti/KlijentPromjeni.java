package servleti;

import beans.Konekcija;
import beans.Korisnik;
import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class KlijentPromjeni extends HttpServlet {

   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String id=request.getParameter("id");
        String tip="";
        
        
       Connection kon=null;
       Statement stmt=null;
       ResultSet rs=null;
         
       try
       {
           kon=Konekcija2.getConnection();
           stmt=kon.createStatement();
           
            String upit="select * from nekretnina where nekretnina_id='"+id+"'";
            
           rs=stmt.executeQuery(upit);
           
          
           while(rs.next())
           {
                tip=rs.getString(2);
           }            
          // prouzrokuje gresku tip=rs.getString(2);                     
        }     
        catch(SQLException e) 
        {
            request.setAttribute("poruka", "Greska u radu sa bazom");
            request.getRequestDispatcher("KlijentPocetna.jsp").forward(request, response);
        }  
          
        if(tip.equals("SALE")){
            
            Nekretnina nek=new Nekretnina();
            ResultSet rs1;
            String upit="select * from nekretnina where nekretnina_id='"+id+"'";
            
             
            try{
                
                stmt=kon.createStatement();
                rs1=stmt.executeQuery(upit);
               
                while(rs1.next())
                {
                    int nekid=rs1.getInt(1);
                    String tipnek=rs1.getString(3);
                    String grad=rs1.getString(4);
                    String ulica=rs1.getString(5);
                    int kvadratura=rs1.getInt(6);
                    String struktura=rs1.getString(7);
                    Double cijena=rs1.getDouble(8);
                    String sprat=rs1.getString(9);
                    int godizg=rs1.getInt(10);
                    String lift=rs1.getString(11);
                    int brojsoba=rs1.getInt(12);
                    Double daljina=rs1.getDouble(13);
                    String garaza=rs1.getString(14);
                    String parking=rs1.getString(15);
                    String terasa=rs1.getString(16);
                    String podrum=rs1.getString(17);
                    String kreiran=rs1.getString(18);
                    int vlasnikid=rs1.getInt(19);
                    String status=rs1.getString(20);
                   //  out.print("ovo je sranje ali opet hajde da vidimooo"+daljina+status+struktura+ulica);
                nek.setNekretninaId(nekid);
                nek.setTip(tip);
                nek.setEstateType(tipnek);
                nek.setGrad(grad);
                nek.setUlica(ulica); 
                nek.setVelicina(kvadratura);
                nek.setStruktura(struktura);
                nek.setCijena(cijena);
                nek.setSprat(sprat);
                nek.setGodinaIzgradnje(godizg);
                nek.setElevator(lift);
                nek.setBrojSoba(brojsoba);
                nek.setDaljinaOdCentra(daljina);
                nek.setGaraza(garaza);
                nek.setParking(parking);
                nek.setTerasa(terasa);
                nek.setPodrum(podrum);
                nek.setKreiran(kreiran);
                nek.setVlasnikId(vlasnikid);
                nek.setStatus(status);
                
                }
                  request.setAttribute("nekretnina", nek);
                  request.getRequestDispatcher("KlijentPromjeniProdaja.jsp").forward(request, response);
                
                
            }
               catch(SQLException e)
            {
                 request.setAttribute("poruka", "Greska u radu sa bazom2");
                 request.getRequestDispatcher("KlijentPocetna.jsp").forward(request, response);
            }
            finally{
               
                if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} } 
                if(rs!=null)  { try{  rs.close(); }   catch(Exception exc){} } 
                
            }
           
            
        }
        if(tip.equals("DAILY")){
                 
            Stannadan nek=new Stannadan();
            ResultSet rs2;
            String upit4="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.klima,stannadan.ves_masina,stannadan.internet,stannadan.fen,stannadan.posteljina,stannadan.pusenje_dozv,stannadan.pets from nekretnina inner join stannadan on nekretnina.nekretnina_id=stannadan.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
           
            try{      
                stmt=kon.createStatement();
                rs2=stmt.executeQuery(upit4);
                
                while(rs2.next())
                {
                    int nekid=rs2.getInt(1);
                    String tipnek=rs2.getString(3);
                    String grad=rs2.getString(4);
                    String ulica=rs2.getString(5);
                    int kvadratura=rs2.getInt(6);
                    String struktura=rs2.getString(7);
                    Double cijena=rs2.getDouble(8);
                    String sprat=rs2.getString(9);
                    int godizg=rs2.getInt(10);
                    String lift=rs2.getString(11);
                    int brojsoba=rs2.getInt(12);
                    Double daljina=rs2.getDouble(13);
                    String garaza=rs2.getString(14);
                    String parking=rs2.getString(15);
                    String terasa=rs2.getString(16);
                    String podrum=rs2.getString(17);
                    String kreiran=rs2.getString(18);
                    int vlasnikid=rs2.getInt(19);
                    String status=rs2.getString(20);
                    
                    int mingost=rs2.getInt(21);
                    int maxgost=rs2.getInt(22);
                    Double nocenjecijena=rs2.getDouble(23);
                    String klima=rs2.getString(24);
                    String vesmasina=rs2.getString(25);
                    String internet=rs2.getString(26);
                    String fen=rs2.getString(27);
                    String posteljina=rs2.getString(28);
                    String pusenje=rs2.getString(29);
                    String pets=rs2.getString(30);
                     nek.setNekretninaId(nekid);                     
                     nek.setMinGost(mingost);
                     nek.setMaxGost(maxgost);
                     nek.setNocenjeCijena(nocenjecijena);
                     nek.setKlima(klima);
                     nek.setVesMasina(vesmasina);
                     nek.setInternet(internet);
                     nek.setFen(fen);
                     nek.setPosteljina(posteljina);
                     nek.setPusenjeDozv(pusenje);
                     nek.setPets(pets);
                     
                     String tv="da";
                nek.setTv(tv);
                nek.setTip(tip);
                nek.setEstateType(tipnek);
                nek.setGrad(grad);
                nek.setUlica(ulica); 
                nek.setVelicina(kvadratura);
                nek.setStruktura(struktura);
                nek.setCijena(cijena);
                nek.setSprat(sprat);
                nek.setGodinaIzgradnje(godizg);
                nek.setElevator(lift);
                nek.setBrojSoba(brojsoba);
                nek.setDaljinaOdCentra(daljina);
                nek.setGaraza(garaza);
                nek.setParking(parking);
                nek.setTerasa(terasa);
                nek.setPodrum(podrum);
                nek.setKreiran(kreiran);
                nek.setVlasnikId(vlasnikid);
                nek.setStatus(status);
           
                    
                }
                 request.setAttribute("daily", nek);
                 request.getRequestDispatcher("KlijentPromjeniStan.jsp").forward(request, response);
                
                
            }
            catch(SQLException e)
            {
                 request.setAttribute("poruka", "Greska u radu sa bazom3");
                 request.getRequestDispatcher("KlijentPocetna.jsp").forward(request, response);                   
            } 
            finally
            {
                if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} } 
                if(rs!=null)  { try{  rs.close(); }   catch(Exception exc){} } 
                
            }
        }
        if(tip.equals("RENT"))
        {
            ResultSet rs3=null;
            Rentanje nek3=new Rentanje();           
            String upit5="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status, rentanje.klima,rentanje.ves_masina,rentanje.internet,rentanje.tv,rentanje.struja,rentanje.grijanje,rentanje.period_placanja,rentanje.min_renta,rentanje.useljiv from nekretnina inner join rentanje on nekretnina.nekretnina_id=rentanje.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
           
            
            try{
                
                stmt=kon.createStatement();
                rs3=stmt.executeQuery(upit5);
                
                while(rs3.next())
                {
                    int nekid=rs3.getInt(1);
                    String tipnek=rs3.getString(3);
                    String grad=rs3.getString(4);
                    String ulica=rs3.getString(5);
                    int kvadratura=rs3.getInt(6);
                    String struktura=rs3.getString(7);
                    Double cijena=rs3.getDouble(8);
                    String sprat=rs3.getString(9);
                    int godizg=rs3.getInt(10);
                    String lift=rs3.getString(11);
                    int brojsoba=rs3.getInt(12);
                    Double daljina=rs3.getDouble(13);
                    String garaza=rs3.getString(14);
                    String parking=rs3.getString(15);
                    String terasa=rs3.getString(16);
                    String podrum=rs3.getString(17);
                    String kreiran=rs3.getString(18);
                    int vlasnikid=rs3.getInt(19);
                    String status=rs3.getString(20);                   
                   
                    
                    String klima=rs3.getString(21);
                    String vesmasina=rs3.getString(22);
                    String internet=rs3.getString(23);
                    String tv=rs3.getString(24);
                    Double struja=rs3.getDouble(25);
                    Double grijanje=rs3.getDouble(26);
                    String period=rs3.getString(27);
                    String minrenta=rs3.getString(28);
                    String useljiv=rs3.getString(29);
                    
                   nek3.setNekretninaId(nekid);   
                nek3.setTip(tip);
                nek3.setEstateType(tipnek);
                nek3.setGrad(grad);
                nek3.setUlica(ulica); 
                nek3.setVelicina(kvadratura);
                nek3.setStruktura(struktura);
                nek3.setCijena(cijena);
                nek3.setSprat(sprat);
                nek3.setGodinaIzgradnje(godizg);
                nek3.setElevator(lift);
                nek3.setBrojSoba(brojsoba);
                nek3.setDaljinaOdCentra(daljina);
                nek3.setGaraza(garaza);
                nek3.setParking(parking);
                nek3.setTerasa(terasa);
                nek3.setPodrum(podrum);
                nek3.setKreiran(kreiran);
                nek3.setVlasnikId(vlasnikid);
                nek3.setStatus(status);              
                nek3.setKlima(klima);
                nek3.setVesMasina(vesmasina);
                nek3.setInternet(internet);
                nek3.setTv(tv);
                nek3.setStruja(struja);
                nek3.setGrijanje(grijanje);
                nek3.setPeriodPlacanja(period);
                nek3.setMinRenta(minrenta);
                nek3.setUseljiv(useljiv);
                
                }
                 request.setAttribute("renta", nek3);
                 request.getRequestDispatcher("KlijentPromjeniRenta.jsp").forward(request, response);
                
            } catch(SQLException e)
               {
                   request.setAttribute("poruka", "Greska u radu sa bazom4");
                   request.getRequestDispatcher("KlijentPocetna.jsp").forward(request, response);
               } 
            finally
            {
                if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} } 
                if(rs!=null)  { try{  rs.close(); }   catch(Exception exc){} } 
                if(rs3!=null)  { try{  rs3.close(); }   catch(Exception exc){} } 
            }
         }
        
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
