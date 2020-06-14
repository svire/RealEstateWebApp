package servleti;


import beans.*;
import beans.Korisnik;
import beans.Nekretnina;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class PretraziNekretnineS extends HttpServlet {

  
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cijenamin="0.0";
        String cijenamax="10000000";  
        String kvadraturamin="0";
        String kvadraturamax="10000";
        String grad="%%";
        if(request.getParameter("grad")!=null)
        {
           grad="%"+request.getParameter("grad")+"%"; 
        }
        
        if(request.getParameter("cijenamin")!=null)
        {
            cijenamin=request.getParameter("cijenamin");
        }
        if(request.getParameter("cijenamin")=="")
        {
            cijenamin="0";
        }
        
        
        if(request.getParameter("cijenamax")!=null)
        {
            cijenamax=request.getParameter("cijenamax");
        }
         if(request.getParameter("cijenamax")=="")
        {
            cijenamax="10000000";
        }
        
        
        if(request.getParameter("kvadraturamin")!=null)
        {
            kvadraturamin=request.getParameter("kvadraturamin");
        }
         if(request.getParameter("kvadraturamin")=="")
        {
            kvadraturamin="0";
        }
        
        if(request.getParameter("kvadraturamax")!=null)
        {
            kvadraturamax=request.getParameter("kvadraturamax");
        }
        if(request.getParameter("kvadraturamax")=="")
        {
            kvadraturamax="10000";
        }
        
       
      
        int kvadraturaminint=0;
        int kvadraturamaxint=0;
        Float cijenamindo=0.0f;        
        Float cijenamaxdo=0.0f;
        
        
        
        
        if(cijenamin!=null||cijenamax!=null||kvadraturamin!=null||kvadraturamax!=null){
        try {  cijenamindo=Float.parseFloat(cijenamin); }   catch (NumberFormatException e) {     }  
        try {  cijenamaxdo=Float.parseFloat(cijenamax); }catch (NumberFormatException e) {}                 
        try {  kvadraturamaxint=Integer.parseInt(kvadraturamax);}catch (NumberFormatException e) {}      
       try {  kvadraturaminint=Integer.parseInt(kvadraturamin);}catch (NumberFormatException e) {}
         
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
             redirect="PosjetilacStan.jsp";
             
         }
         
         
         
         if(pozicija.equals("korisnik")){
             
             redirect="KorisnikStan.jsp";
         }
       
         
        
        
         ArrayList<Stannadan> listaStan=new ArrayList<Stannadan>();      
         
         Connection kon=null;
         ResultSet rs=null;
         Statement stmt=null;
         String kveri1="SELECT nekretnina.nekretnina_id,nekretnina.grad,nekretnina.ulica,nekretnina.kvadratura,stannadan.min_gost,stannadan.max_gost,stannadan.nocenje_cijena,stannadan.pets from nekretnina inner join stannadan ON nekretnina.nekretnina_id=stannadan.nekretnina_id  where status='AKTIVAN' and (grad like '"+grad+"') and cast(nocenje_cijena as decimal(10,2))>'"+cijenamindo+"' and cast(nocenje_cijena as decimal(10,2))<'"+cijenamaxdo+"' and kvadratura <'"+kvadraturamaxint+"' and kvadratura>'"+kvadraturaminint+"'";
        
        
         try{
             kon=Konekcija2.getConnection();
             stmt=kon.createStatement();
             rs=stmt.executeQuery(kveri1);
                      
            
             HttpSession sesija=request.getSession();
            
            
            
            while(rs.next()){
                
                
                Stannadan nek=new Stannadan();
                
                nek.setNekretninaId(rs.getInt(1));
                nek.setGrad(rs.getString(2));
                nek.setUlica(rs.getString(3));
                nek.setVelicina(rs.getInt(4));
                
                nek.setMinGost(rs.getInt(5));
                nek.setMaxGost(rs.getInt(6));
                nek.setNocenjeCijena(rs.getDouble(7));
                nek.setPets(rs.getString(8));
                
                listaStan.add(nek);
                
            }
        
           
             if(listaStan.size()==0){
               request.setAttribute("stan", listaStan);
               request.setAttribute("poruka", "Nema rezultata pretrage za date parametre.");
               
               
             }
             if(listaStan.size()>0){
              
               request.setAttribute("stan", listaStan);
               
             }
           request.getRequestDispatcher(redirect).forward(request, response);
               
           
           
        
        } catch(SQLException e)
           {
               
                request.setAttribute("poruka", "ne radi nesto");
                request.getRequestDispatcher(redirect).forward(request, response);
           }
           finally{
             if(rs!=null){   try{rs.close(); } catch(SQLException ex){}  }
             if(stmt!=null){   try{stmt.close(); } catch(SQLException ex){}  }
             if(kon!=null){   try{kon.close(); } catch(SQLException ex){}  }
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
