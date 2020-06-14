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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class MenadzerIstaknuti extends HttpServlet {
 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
         String pozicija="";
         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         int korid=kor.getKorisnikID();
        
         
         String redirect="MenadzerIstaknuti.jsp"; 
         
              
        
         Connection kon=null;
         Statement stmt=null;
         ResultSet rs=null;
         
         String kveri="select nekretnina.nekretnina_id,nekretnina.grad,nekretnina.ulica,nekretnina.tip,nekretnina.kvadratura,nekretnina.broj_soba,nekretnina.godina_izgradnje,nekretnina.garaza from nekretnina inner JOIN favourites on nekretnina.nekretnina_id=favourites.nekretnina_id where favourites.korisnik_id='"+korid+"'";
         
         ArrayList<Nekretnina> listaProdaja=new ArrayList<Nekretnina>();      
        
         try{
             kon=Konekcija2.getConnection();
             stmt=kon.createStatement();
             
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
             
             if(rs!=null){  try{ rs.close(); } catch(SQLException ex){ }  }
             if(stmt!=null){  try{ stmt.close(); } catch(SQLException ex){ }  }
             if(kon!=null){  try{kon.close(); } catch(SQLException ex){ }  }
         }
        
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
