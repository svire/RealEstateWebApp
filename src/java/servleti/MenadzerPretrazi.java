/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import beans.Nekretnina;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Djole
 */
public class MenadzerPretrazi extends HttpServlet {

    

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
         String redirect="MenadzerPretrazi.jsp"; 
         
         
      
        ArrayList<Nekretnina> listaProdaja=new ArrayList<Nekretnina>();   
        
        
         Connection kon=null;         
         ResultSet rs=null,rs1;
         Statement stmt=null;
        
        
        
         try{
             
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
           
            int brojredova=0;
            String profilna="minus2020.png"; 
            String kveri="select nekretnina.nekretnina_id,nekretnina.grad,nekretnina.ulica,nekretnina.tip,nekretnina.kvadratura,nekretnina.broj_soba,nekretnina.godina_izgradnje,nekretnina.garaza from nekretnina where status='AKTIVAN' and (grad like '"+grad+"') and cast(cijena as decimal(10,2))>'"+cijenamindo+"' and cast(cijena as decimal(10,2))<'"+cijenamaxdo+"' and kvadratura <'"+kvadraturamaxint+"' and kvadratura>'"+kvadraturaminint+"'";
         
            rs=stmt.executeQuery(kveri);
            HttpSession sesija=request.getSession();
            
            
            
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
               request.setAttribute("poruka", "Nema rezultata na date parametre.");
               
               
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
