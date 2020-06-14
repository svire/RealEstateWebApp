package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Djole
 */
public class PromjeniNekretninuM extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         String pozicija=kor.getPozicija();
         String redirect="MenadzerSveNekretnine?biraj=SALE";
         
         
        String idslike=request.getParameter("profile");
        String nekid=request.getParameter("nekid");
        int nekidint=Integer.parseInt(nekid);
        String update="update nekretnine_slike set title='not' where nekretnina_id='"+nekidint+"'";
        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            stmt.executeUpdate(update);   //stavi sve na not
            
            if(idslike!=null){
                int idslikeint=Integer.parseInt(idslike);
                String update1="update nekretnine_slike set title='profile' where  id='"+idslikeint+"' and nekretnina_id='"+nekidint+"'";
                stmt=kon.createStatement();
                stmt.executeUpdate(update1);
                
                request.setAttribute("poruka", "Updejtovana profilna slika za nekretninu!");
                request.getRequestDispatcher(redirect).forward(request, response);
                
            }
            else{
            request.setAttribute("poruka", "Izaberi jednu sliku za profilnu nekretnine");
            request.getRequestDispatcher(redirect).forward(request, response);
            
        }
            
        }
        catch(SQLException ex){
             request.setAttribute("poruka", "Doslo je do greske pri promjeni profilne slike!");
             request.getRequestDispatcher(redirect).forward(request, response);
            
        }
        finally{
            if(kon!=null){ try{ kon.close(); } catch(SQLException ex){}}
            if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){}}
        }
      
      
        
        
     
        
    }

   
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         String pozicija=kor.getPozicija();
         String redirect="nistavila";
         
        
        
        //SALE///////
        String idstr=request.getParameter("id");                  
        String tip=request.getParameter("tip");
        String vrstanekretnine=request.getParameter("vrstanekretnine");
        String grad=request.getParameter("grad");
        String ulica=request.getParameter("ulica");
        String kvadratura=request.getParameter("kvadratura");    
        String struktura=request.getParameter("struktura");
        String cijena=request.getParameter("cijena");      
        String sprat=request.getParameter("sprat");      
        String godinaizgradnje=request.getParameter("godinaizgradnje");    
        String lift=request.getParameter("lift");
        String brojsoba=request.getParameter("brojsoba");     
        String daljina=request.getParameter("daljina");     
        String garaza=request.getParameter("garaza");
        String parking=request.getParameter("parking");
        String terasa=request.getParameter("terasa");
        String podrum=request.getParameter("podrum");
        String status=request.getParameter("status");
        String kreiran=request.getParameter("kreiran");
        
        //renta
        String struja=request.getParameter("struja");
        String grijanje=request.getParameter("grijanje");
        String periodplacanja=request.getParameter("periodplacanja");
        String minrenta=request.getParameter("minrenta");
        String useljiv=request.getParameter("useljiv");         
        String klima1=request.getParameter("klima");
        String vesmasina1=request.getParameter("vesmasina");
        String internet1=request.getParameter("internet");
        String tv1=request.getParameter("tv");  
        
        
        //daily
         String cijenanocenja=request.getParameter("cijenanocenja");               
         String maxgostiju=request.getParameter("maxgostiju");
         String mingostiju=request.getParameter("mingostiju");
         String klima=request.getParameter("klima1");
         String vesmasina=request.getParameter("vesmasina1");
         String internet=request.getParameter("internet1");
         String tv=request.getParameter("tv1");
         String fen=request.getParameter("fen");
         String posteljina=request.getParameter("posteljina");
         String pusenje=request.getParameter("pusenje");
         String kucniljubimci=request.getParameter("kucniljubimci");
        
        
         Connection kon=null;
         Statement stmt=null;
        
        
        if(tip.equals("SALE")){
            
            
             if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
            &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0)
             {    
                 int id=Integer.parseInt(idstr);  
                 int kvadratint=Integer.parseInt(kvadratura);
                 int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
                 int brojsobaint=Integer.parseInt(brojsoba);
                 Float cijenaflo=Float.parseFloat(cijena);
                 Float daljinado=Float.parseFloat(daljina);
             
                 String update="update nekretnina SET tip_nekretnine='"+vrstanekretnine+"',grad='"+grad+"',ulica='"+ulica+"',kvadratura='"+kvadratint+"',struktura='"+struktura+"',cijena='"+cijenaflo+"',sprat='"+sprat+"',godina_izgradnje='"+godinaizgradnjeint+"',lift='"+lift+"',broj_soba='"+brojsobaint+"',daljina_od_centra='"+daljinado+"',garaza='"+garaza+"',parking='"+parking+"',terasa='"+terasa+"',podrum='"+podrum+"',status='"+status+"' WHERE nekretnina_id='"+id+"'";
                
                 try{
                     kon=Konekcija2.getConnection();
                     stmt=kon.createStatement();
                     stmt.executeUpdate(update);
                     
                 }
                 catch(SQLException ex){
                                      
                     String redirectp="MenadzerPromjeni?id="+idstr;               
                     s.setAttribute("porukas", "Doslo je do greske pri promjeni podataka.");                
                     response.sendRedirect(redirectp);
                     
                 }
                 finally{
                     if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                     if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }                     
                 }
                 
                 
                 s.setAttribute("porukas", "Uspjesno napravljene promjene");  
                 response.sendRedirect("MenadzerSveNekretnine?biraj=SALE");//?biraj=SALE
             }
             else{
                String redirectp="MenadzerPromjeni?id="+idstr;               
                s.setAttribute("porukas", "Unesite sve parametre");                
                response.sendRedirect(redirectp);
             }
            
            
            
            }
        
         if(tip.equals("RENT")){
             
             if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
          &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0
                &&struja!=null&&struja.length()>0&&grijanje!=null&&grijanje.length()>0&&useljiv!=null&&useljiv.length()>0
               &&minrenta!=null&&minrenta.length()>0&&periodplacanja!=null&&periodplacanja.length()>0
                ){
             int id=Integer.parseInt(idstr);    
             int kvadratint=Integer.parseInt(kvadratura);
             int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
             int brojsobaint=Integer.parseInt(brojsoba);
             Float cijenaflo=Float.parseFloat(cijena);
             Float daljinado=Float.parseFloat(daljina);
            
             Float strujado=0f;   
             Float grijanjedo=0f;
             try { strujado=Float.parseFloat(struja); }  catch (NumberFormatException e) {     } 
             try {  grijanjedo=Float.parseFloat(grijanje);    } catch (NumberFormatException e) {       }
                 
            String update="update nekretnina SET tip_nekretnine='"+vrstanekretnine+"',grad='"+grad+"',ulica='"+ulica+"',kvadratura='"+kvadratint+"',struktura='"+struktura+"',cijena='"+cijenaflo+"',sprat='"+sprat+"',godina_izgradnje='"+godinaizgradnjeint+"',lift='"+lift+"',broj_soba='"+brojsobaint+"',daljina_od_centra='"+daljinado+"',garaza='"+garaza+"',parking='"+parking+"',terasa='"+terasa+"',podrum='"+podrum+"',status='"+status+"' WHERE nekretnina_id='"+id+"'";
            String update1="UPDATE rentanje SET klima='"+klima1+"',ves_masina='"+vesmasina1+"',internet='"+internet1+"',tv='"+tv1+"',struja='"+struja+"',grijanje='"+grijanje+"',period_placanja='"+periodplacanja+"',min_renta='"+minrenta+"',useljiv='"+useljiv+"' where nekretnina_id='"+id+"'";
           
             try{
                 kon=Konekcija2.getConnection();
                 stmt=kon.createStatement();
                 stmt.executeUpdate(update);
                 stmt.executeUpdate(update1);
                
             }
             catch(SQLException ex){
                 s.setAttribute("porukas", "Doslo je do greske prilikom promjene podataka.");  
                 response.sendRedirect("MenadzerSveNekretnine?biraj=SALE");
                 
             }
             finally{
                 if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                 if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} } 
                 
             }
             
              s.setAttribute("porukas", "Uspjesno napravljene promjene");  
               response.sendRedirect("MenadzerSveNekretnine?biraj=SALE");
             
             
                 
             }
             else{
                String redirectp="MenadzerPromjeni?id="+idstr;               
                s.setAttribute("porukas", "Unesite sve parametre rente");                
                response.sendRedirect(redirectp);
             }
             
         }
         
         
          if(tip.equals("DAILY")){
              
              if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
          &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0
                 &&cijenanocenja!=null&&cijenanocenja.length()>0&&mingostiju!=null&&mingostiju.length()>0&&maxgostiju!=null&&maxgostiju.length()>0   
                    ){
                 int id=Integer.parseInt(idstr); 
                 Float cijenanocenjado=0f;   int mingostijuint=0;    int maxgostijuint=0;
                 try { cijenanocenjado=Float.parseFloat(cijenanocenja);   } catch (NumberFormatException e) {     } 
                 try {   mingostijuint=Integer.parseInt(mingostiju);  } catch (NumberFormatException e) {    } 
                 try {   maxgostijuint=Integer.parseInt(maxgostiju);  } catch (NumberFormatException e) {     } 
                 int kvadratint=Integer.parseInt(kvadratura);
                 int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
                 int brojsobaint=Integer.parseInt(brojsoba);
                 Float cijenaflo=Float.parseFloat(cijena);
                 Float daljinado=Float.parseFloat(daljina);   
                  
                 String update="update nekretnina SET tip_nekretnine='"+vrstanekretnine+"',grad='"+grad+"',ulica='"+ulica+"',kvadratura='"+kvadratint+"',struktura='"+struktura+"',cijena='"+cijenaflo+"',sprat='"+sprat+"',godina_izgradnje='"+godinaizgradnjeint+"',lift='"+lift+"',broj_soba='"+brojsobaint+"',daljina_od_centra='"+daljinado+"',garaza='"+garaza+"',parking='"+parking+"',terasa='"+terasa+"',podrum='"+podrum+"',status='"+status+"' WHERE nekretnina_id='"+id+"'";
                 String nest="UPDATE stannadan SET min_gost='"+mingostijuint+"',max_gost='"+maxgostijuint+"',nocenje_cijena='"+cijenanocenjado+"',klima='"+klima+"',ves_masina='"+vesmasina+"',internet='"+internet+"',tv='"+tv+"',fen='"+fen+"',posteljina='"+posteljina+"',pusenje_dozv='"+pusenje+"',pets='"+kucniljubimci+"' WHERE nekretnina_id='"+id+"'";
                
                 try{
                     kon=Konekcija2.getConnection();
                     stmt=kon.createStatement();
                     stmt.executeUpdate(update);
                     stmt.executeUpdate(nest);
                     
                 }
                 catch(SQLException ex){
                      String redirectp="MenadzerPromjeni?id="+idstr;                 
                      s.setAttribute("porukas", "Doslo je do greske prilikom promjene.");                
                      response.sendRedirect(redirectp);    
                    
                 }
                 finally{
                     if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                     if(stmt!=null)  { try{  stmt.close(); }   catch(Exception exc){} }                      
                 }
         
                 s.setAttribute("porukas", "Uspjesno izvrsena promjena podataka.");  
                  response.sendRedirect("MenadzerSveNekretnine?biraj=SALE");
                  
              }              
              else{
                String redirectp="MenadzerPromjeni?id="+idstr;                 
                s.setAttribute("porukas", "Unesite sve parametre stannadan");                
                response.sendRedirect(redirectp);                  
                  
              }
              
           }
              
              
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
