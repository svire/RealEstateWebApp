/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Djole
 */
public class MenadzerNajgledanije extends HttpServlet {
  
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Nekretnina> nekretnine=new ArrayList<Nekretnina>();
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        String query="SELECT nekretnina.nekretnina_id,nekretnina.grad,nekretnina.cijena,nekretnina.tip,mostviewed.broj_posjeta from nekretnina inner join mostviewed on nekretnina.nekretnina_id=mostviewed.nekretnina_id order by mostviewed.broj_posjeta DESC limit 20";        
        try{
            
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                
                Nekretnina nek=new Nekretnina();
                
                nek.setNekretninaId(rs.getInt(1));
                nek.setGrad(rs.getString(2));
                nek.setCijena(rs.getDouble(3));
                nek.setTip(rs.getString(4));
                nek.setGodinaIzgradnje(rs.getInt(5));
                
                
                nekretnine.add(nek);
                
            }
            
            request.setAttribute("najgledanije", nekretnine);
            request.getRequestDispatcher("MenadzerNajgledanije1.jsp").forward(request, response);
            
        }
        catch(SQLException ex){
            
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
            request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
            
            
            
        }
        finally{
            if(rs!=null){ try{ rs.close(); } catch(SQLException ex){ }  }    
            if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){ }  }    
            if(kon!=null){ try{ kon.close(); } catch(SQLException ex){ }  }
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
