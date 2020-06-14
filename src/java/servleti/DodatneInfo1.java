package servleti;

import beans.Konekcija;
import beans.Korisnik;
import beans.*;
import pomocni.Najvise;
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
public class DodatneInfo1 extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
        String tip="";
        
        
        Connection kon=null;
        Statement stmt=null;
        
        
        
        try
        {
           kon=Konekcija2.getConnection();
           ResultSet rs=null;
           
          String upit="select * from nekretnina where nekretnina_id='"+id+"'";
          
          stmt=kon.createStatement();
          rs=stmt.executeQuery(upit);
          
          while(rs.next()){
                tip=rs.getString(2);
          }           
                    
       }     
         catch(SQLException e)
       {
           request.setAttribute("pooruka", "Doslo je do greske u radu sa bazom.");
           
      
       }  
                
         
         String pozicija="";
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         if(kor!=null)
         {
             pozicija=kor.getPozicija();
         }
         String redirect=""; //radi ovdje ga baci ako nisi ulogovan empty
         
         
         if(kor==null){
             if(tip.equals("SALE")){
                 redirect="PosjetilacProdajaInfo.jsp";
             }
             if(tip.equals("RENT")){
                 redirect="PosjetilacRentaInfo.jsp";
             }
             if(tip.equals("DAILY")){
                 redirect="PosjetilacStanInfo.jsp";
             }
             
             
         }
         
         
         
         if(pozicija.equals("korisnik")){
             
             if(tip.equals("SALE")){
                 redirect="KorisnikProdajaInfo.jsp";
             }
             if(tip.equals("RENT")){
                 redirect="KorisnikRentaInfo.jsp";
             }
             if(tip.equals("DAILY")){
                 redirect="KorisnikStanInfo.jsp";
             }
         }
         if(pozicija.equals("klijent")){
             if(tip.equals("SALE")){
                 redirect="KlijentProdajaInfo.jsp";
             }
             if(tip.equals("RENT")){
                 redirect="KlijentRentaInfo.jsp";
             }
             if(tip.equals("DAILY")){
                 redirect="KlijentStanInfo.jsp";
             }
             
             
         }
         if(pozicija.equals("menadzer")){
              if(tip.equals("SALE")){
                 redirect="MenadzerProdajaInfo.jsp";
             }
             if(tip.equals("RENT")){
                 redirect="MenadzerRentaInfo.jsp";
             }
             if(tip.equals("DAILY")){
                 redirect="MenadzerStanInfo.jsp";
             }
             
             
         } 
         
         
           if(tip.equals("SALE")){
            
            Nekretnina nek=new Nekretnina();
            ResultSet rs1=null;
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
                
                
                
                if(pozicija.equals("korisnik")||kor==null){
                    Najvise naj=new Najvise(nekid);
                }
                
             
                }
                  
                  request.setAttribute("nekretnina", nek);
                  request.getRequestDispatcher(redirect).forward(request, response);
                
                
               }
               catch(SQLException e)
               {
                  request.setAttribute("poruka", "Doslo je do greske u radu sa bazom(DodatneInfo1)!");
                  request.getRequestDispatcher("KlijentPocetna.jsp").forward(request, response);
      
               }
            finally
            {
                 if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                 if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                 if(rs1!=null) { try{ rs1.close(); } catch(SQLException ex){}  }
            }
            }
           
           if(tip.equals("RENT"))
            {
          
            kon=Konekcija2.getConnection();
            Rentanje nek3=new Rentanje();
            ResultSet rs;
           // String upit3="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.klima,stannadan.ves_masina,stannadan.internet,stannadan.fen,stannadan.posteljina,stannadan.pusenje_dozv,stannadan.pets from nekretnina inner join stannadan on nekretnina.nekretnina_id=stannadan.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
            //String upit4="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.klima,stannadan.ves_masina,stannadan.internet,stannadan.fen,stannadan.posteljina,stannadan.pusenje_dozv,stannadan.pets from nekretnina inner join stannadan on nekretnina.nekretnina_id=stannadan.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
            String upit5="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status, rentanje.klima,rentanje.ves_masina,rentanje.internet,rentanje.tv,rentanje.struja,rentanje.grijanje,rentanje.period_placanja,rentanje.min_renta,rentanje.useljiv from nekretnina inner join rentanje on nekretnina.nekretnina_id=rentanje.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
          
            try{   
                 
                stmt=kon.createStatement();
                rs=stmt.executeQuery(upit5);
                
                while(rs.next())
                {
                    int nekid=rs.getInt(1);
                    String tipnek=rs.getString(3);
                    String grad=rs.getString(4);
                    String ulica=rs.getString(5);
                    int kvadratura=rs.getInt(6);
                    String struktura=rs.getString(7);
                    Double cijena=rs.getDouble(8);
                    String sprat=rs.getString(9);
                    int godizg=rs.getInt(10);
                    String lift=rs.getString(11);
                    int brojsoba=rs.getInt(12);
                    Double daljina=rs.getDouble(13);
                    String garaza=rs.getString(14);
                    String parking=rs.getString(15);
                    String terasa=rs.getString(16);
                    String podrum=rs.getString(17);
                    String kreiran=rs.getString(18);
                    int vlasnikid=rs.getInt(19);
                    String status=rs.getString(20);                   
                   
                    
                    String klima=rs.getString(21);
                    String vesmasina=rs.getString(22);
                    String internet=rs.getString(23);
                    String tv=rs.getString(24);
                    Double struja=rs.getDouble(25);
                    Double grijanje=rs.getDouble(26);
                    String period=rs.getString(27);
                    String minrenta=rs.getString(28);
                    String useljiv=rs.getString(29);
                    
                    
                    
                   
                   nek3.setNekretninaId(Integer.parseInt(id));   
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
               
                
                
               if(pozicija.equals("korisnik")||kor==null){
                    Najvise naj=new Najvise(nekid);
                }        
                    
               
                    
                }
                 request.setAttribute("renta", nek3);
                 request.getRequestDispatcher(redirect).forward(request, response);
                
                
                }
               catch(SQLException e)
              {
                 request.setAttribute("poruka","Doslo je do greske(DodatneInfoServlet)!");
                 request.getRequestDispatcher("PosjetilacProdaja.jsp").forward(request,response);
              } 
             finally
            {
                 if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                 if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                  
            }
        
        }
           
           
           if(tip.equals("DAILY")){
             kon=Konekcija2.getConnection();
           // Nekretnina1 nek=new Nekretnina1();
            Stannadan nek=new Stannadan();
            ResultSet rs;
           // String upit3="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.klima,stannadan.ves_masina,stannadan.internet,stannadan.fen,stannadan.posteljina,stannadan.pusenje_dozv,stannadan.pets from nekretnina inner join stannadan on nekretnina.nekretnina_id=stannadan.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
            String upit4="SELECT nekretnina.nekretnina_id,nekretnina.tip,nekretnina.tip_nekretnine,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,nekretnina.struktura,nekretnina.cijena,nekretnina.sprat,nekretnina.godina_izgradnje,nekretnina.lift,nekretnina.broj_soba,nekretnina.daljina_od_centra,nekretnina.garaza,nekretnina.parking,nekretnina.terasa,nekretnina.podrum,nekretnina.kreiran,nekretnina.vlasnik_id,nekretnina.status,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.klima,stannadan.ves_masina,stannadan.internet,stannadan.fen,stannadan.posteljina,stannadan.pusenje_dozv,stannadan.pets from nekretnina inner join stannadan on nekretnina.nekretnina_id=stannadan.nekretnina_id where nekretnina.nekretnina_id='"+id+"'";
           
            try{             
                
                stmt=kon.createStatement();
                rs=stmt.executeQuery(upit4);
                while(rs.next())
                {
                    int nekid=rs.getInt(1);
                    String tipnek=rs.getString(3);
                    String grad=rs.getString(4);
                    String ulica=rs.getString(5);
                    int kvadratura=rs.getInt(6);
                    String struktura=rs.getString(7);
                    Double cijena=rs.getDouble(8);
                    String sprat=rs.getString(9);
                    int godizg=rs.getInt(10);
                    String lift=rs.getString(11);
                    int brojsoba=rs.getInt(12);
                    Double daljina=rs.getDouble(13);
                    String garaza=rs.getString(14);
                    String parking=rs.getString(15);
                    String terasa=rs.getString(16);
                    String podrum=rs.getString(17);
                    String kreiran=rs.getString(18);
                    int vlasnikid=rs.getInt(19);
                    String status=rs.getString(20);
                    
                    int mingost=rs.getInt(21);
                    int maxgost=rs.getInt(22);
                    Double nocenjecijena=rs.getDouble(23);
                    String klima=rs.getString(24);
                    String vesmasina=rs.getString(25);
                    String internet=rs.getString(26);
                    String fen=rs.getString(27);
                    String posteljina=rs.getString(28);
                    String pusenje=rs.getString(29);
                    String pets=rs.getString(30);
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
                nek.setTv("DA");
                
                
                
                if(pozicija.equals("korisnik")||kor==null){
                    Najvise naj=new Najvise(nekid);
                }
                    
                }
                 request.setAttribute("daily", nek);
                 request.getRequestDispatcher(redirect).forward(request, response);
                
             } 
               catch(SQLException e)
              {
                  request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
                  request.getRequestDispatcher(redirect).forward(request, response);
              } 
              finally
             {
                 if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                 if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                  
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
    }// </editor-fold>

}
