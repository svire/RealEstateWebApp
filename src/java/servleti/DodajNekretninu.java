package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class DodajNekretninu extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String tip=request.getParameter("tip");
        
        //korisnik id
        HttpSession session=request.getSession();
        Korisnik korisnik=(Korisnik)session.getAttribute("korisnik");
        int korisnikid=korisnik.getKorisnikID();
        
        //MAX ID NEKRETNINA
         int maxid=0;         
         
        Connection kon=null; 
        Statement stmt=null;
        ResultSet rs=null;         
        String query="select max(nekretnina_id) from nekretnina";          
        
        kon=Konekcija2.getConnection();
        try{
            
            stmt=kon.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next())
            {
                maxid=rs.getInt(1);
            }
            rs.close();
            }
        catch(SQLException ex)
            {            
                 
                
                request.setAttribute("poruka", "greska u radu sa bazom");
                request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
            }           
         maxid+=1;
        
        //uzmi slike iz sesije 
        ArrayList<String> slibe=(ArrayList<String>)session.getAttribute("nizslika");
        String title="standard";
         
        //vrijeme
        String timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());        
        
        
        
        
        //nekretnina
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
        String status="ODOBRI";  
        
        
        
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
         String klima=request.getParameter("klima");
         String vesmasina=request.getParameter("vesmasina");
         String internet=request.getParameter("internet");
         String tv=request.getParameter("tv");
         String fen=request.getParameter("fen");
         String posteljina=request.getParameter("posteljina");
         String pusenje=request.getParameter("pusenje");
         String kucniljubimci=request.getParameter("kucniljubimci");
        
        
        
        if(tip.equals("SALE")){
                     
        if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
          &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0){    
            
            int kvadratint=Integer.parseInt(kvadratura);
            int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
            int brojsobaint=Integer.parseInt(brojsoba);
            Float cijenaflo=Float.parseFloat(cijena);
            Float daljinado=Float.parseFloat(daljina);
            
            String insert1="insert into nekretnina values(null,'"+tip+"','"+vrstanekretnine+"','"+grad+"','"+ulica+"','"+kvadratura+"','"+struktura+"','"+cijenaflo+"','"+sprat+"','"+godinaizgradnjeint+"','"+lift+"','"+brojsobaint+"','"+daljinado+"','"+garaza+"','"+parking+"','"+terasa+"','"+podrum+"','"+timeStamp+"','"+korisnikid+"','"+status+"')";
          
               
               
               try{
                   
                   stmt=kon.createStatement();
                   stmt.executeUpdate(insert1);

                   try{
                       if(slibe!=null)
                         {
                         for(int i=0;i<slibe.size();i++){
           
                         //poslenja slika u nizu se postavlja za profilnu 
                         if(i==slibe.size()-1){
                         title="profile";
                         }
                         String insert4="insert into nekretnine_slike values (null,'"+maxid+"','"+slibe.get(i)+"','AKTIVNA','alt','"+title+"') ";
                         stmt.executeUpdate(insert4);
                             }
                        }
                   }
                   catch(SQLException ex)
                   {
                       request.setAttribute("poruka", "Greska prilikom dodavanja slika.");
                       request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
                   }
                   
               }
               catch(SQLException ex)
               {
                   request.setAttribute("poruka", "Greska prilikom dodavanja nekretnine.");
                   request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
               }
               finally{
                    if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                    if(stmt!=null)  { try{ stmt.close(); } catch(Exception exc){} }   
                    if(rs!=null) {try{ rs.close();} catch(Exception exc){} }
               }
               
                  
            request.setAttribute("poruka", "Uspjesno dodana nekretnina");
            request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
                  
              }
           else
            {
             request.setAttribute("poruka", "Unesi sve parametre");
             request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
       
            }
           
            
        }
                
        if(tip.equals("RENT")){
            
        
         
            
        if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
          &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0
                &&struja!=null&&struja.length()>0&&grijanje!=null&&grijanje.length()>0&&useljiv!=null&&useljiv.length()>0
               &&minrenta!=null&&minrenta.length()>0&&periodplacanja!=null&&periodplacanja.length()>0
                ){    
            
            
            int kvadratint=Integer.parseInt(kvadratura);
            int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
            int brojsobaint=Integer.parseInt(brojsoba);
            Float cijenaflo=Float.parseFloat(cijena);
            Float daljinado=Float.parseFloat(daljina);
            
             Float strujado=0f;   
             Float grijanjedo=0f;
             try { strujado=Float.parseFloat(struja); }  catch (NumberFormatException e) {     } 
             try {  grijanjedo=Float.parseFloat(grijanje);    } catch (NumberFormatException e) {       }
        
             String insert1="insert into nekretnina values(null,'"+tip+"','"+vrstanekretnine+"','"+grad+"','"+ulica+"','"+kvadratura+"','"+struktura+"','"+cijenaflo+"','"+sprat+"','"+godinaizgradnjeint+"','"+lift+"','"+brojsobaint+"','"+daljinado+"','"+garaza+"','"+parking+"','"+terasa+"','"+podrum+"','"+timeStamp+"','"+korisnikid+"','"+status+"')";
             String insert="insert into rentanje values('"+maxid+"','"+klima1+"','"+vesmasina1+"','"+internet1+"','"+tv1+"','"+strujado+"','"+grijanjedo+"','"+periodplacanja+"','"+minrenta+"','"+useljiv+"')";
           
             
             try{
                   
                   stmt=kon.createStatement();
                   stmt.executeUpdate(insert1);
                   
                   stmt.executeUpdate(insert);
                   try{
                       if(slibe!=null)
                         {
                         for(int i=0;i<slibe.size();i++){
           
                         //poslenja slika u nizu se postavlja za profilnu 
                         if(i==slibe.size()-1){
                         title="profile";
                         }
                         String insert4="insert into nekretnine_slike values (null,'"+maxid+"','"+slibe.get(i)+"','AKTIVNA','alt','"+title+"') ";
                         stmt.executeUpdate(insert4);
                             }
                        }
                   }
                   catch(SQLException ex)
                   {
                       request.setAttribute("poruka", "Greska prilikom dodavanja slika.");
                       request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
                   }
                   
               }
               catch(SQLException ex)
               {
                   request.setAttribute("poruka", "Greska prilikom dodavanja nekretnine (renta).");
                   request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
               }
               finally{
                    if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                    if(stmt!=null)  { try{ stmt.close(); } catch(Exception exc){} }   
                    if(rs!=null) {try{ rs.close();} catch(Exception exc){} }
               }
            
         
           
                request.setAttribute("poruka", "Uspjesno dodana nekretnina za rentanje.");
                request.getRequestDispatcher("KlijentNoveNekretnineRenta.jsp").forward(request, response);
            
                        
        }
                
        
        else
        {
             request.setAttribute("poruka", "Unesite sve parametre");
             request.getRequestDispatcher("KlijentNoveNekretnineRenta.jsp").forward(request, response);
       
        }
       
    }
        
        
        
         if(tip.equals("DAILY"))
         {
            if(grad!=null&&grad.length()>0&&ulica!=null&&ulica.length()>0&&kvadratura!=null&&kvadratura.length()>0
          &&cijena!=null&&cijena.length()>0&&godinaizgradnje!=null&&godinaizgradnje.length()>0&&daljina!=null&&daljina.length()>0
                 &&cijenanocenja!=null&&cijenanocenja.length()>0&&mingostiju!=null&&mingostiju.length()>0&&maxgostiju!=null&&maxgostiju.length()>0   
                    ){
                
                Float cijenanocenjado=0f;   int mingostijuint=0;    int maxgostijuint=0;
                 try { cijenanocenjado=Float.parseFloat(cijenanocenja);   } catch (NumberFormatException e) {     } 
                 try {   mingostijuint=Integer.parseInt(mingostiju);  } catch (NumberFormatException e) {    } 
                 try {   maxgostijuint=Integer.parseInt(maxgostiju);  } catch (NumberFormatException e) {     } 
                 int kvadratint=Integer.parseInt(kvadratura);
                 int godinaizgradnjeint=Integer.parseInt(godinaizgradnje);
                 int brojsobaint=Integer.parseInt(brojsoba);
                 Float cijenaflo=Float.parseFloat(cijena);
                 Float daljinado=Float.parseFloat(daljina);    
               
                 String insert1="insert into nekretnina values(null,'"+tip+"','"+vrstanekretnine+"','"+grad+"','"+ulica+"','"+kvadratura+"','"+struktura+"','"+cijenaflo+"','"+sprat+"','"+godinaizgradnjeint+"','"+lift+"','"+brojsobaint+"','"+daljinado+"','"+garaza+"','"+parking+"','"+terasa+"','"+podrum+"','"+timeStamp+"','"+korisnikid+"','"+status+"')";
          
                 String insert="insert into stannadan values('"+maxid+"','"+mingostijuint+"','"+maxgostijuint+"','"+cijenanocenjado+"','"+klima+"','"+vesmasina+"','"+internet+"','"+tv+"','"+fen+"','"+posteljina+"','"+pusenje+"','"+kucniljubimci+"')";
                 
                try{
                   
                   stmt=kon.createStatement();
                   stmt.executeUpdate(insert1);
                   
                   stmt.executeUpdate(insert);
                   try{
                       if(slibe!=null)
                         {
                         for(int i=0;i<slibe.size();i++){
           
                         //poslenja slika u nizu se postavlja za profilnu 
                         if(i==slibe.size()-1){
                         title="profile";
                         }
                         String insert4="insert into nekretnine_slike values (null,'"+maxid+"','"+slibe.get(i)+"','AKTIVNA','alt','"+title+"') ";
                         stmt.executeUpdate(insert4);
                             }
                        }
                   }
                   catch(SQLException ex)
                   {
                       request.setAttribute("poruka", "Greska prilikom dodavanja slika.");
                       request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
                   }
                   
               }
               catch(SQLException ex)
               {
                   request.setAttribute("poruka", "Greska prilikom dodavanja nekretnine (renta).");
                   request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request, response);
               
               }
               finally{
                    if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
                    if(stmt!=null)  { try{ stmt.close(); } catch(Exception exc){} }   
                    if(rs!=null) {try{ rs.close();} catch(Exception exc){} }
               }
                
                
                
                request.setAttribute("poruka", "Uspjesan unos nove stan na dan");
                request.getRequestDispatcher("KlijentNoveNekretnineStan.jsp").forward(request, response);
                
            }
            else{
            request.setAttribute("poruka", "Unesi sve parametre");
            request.getRequestDispatcher("KlijentNoveNekretnineStan.jsp").forward(request, response);    
                
            }
            
            
            
         }
        
        
        
        
        
    
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
