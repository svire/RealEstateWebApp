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
public class MenadzerOmiljene extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Nekretnina> nekretnine=new ArrayList<Nekretnina>();
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query="select nek.nekretnina_id,nek.grad,nek.ulica,COUNT(fav.nekretnina_id),nek.tip from nekretnina nek INNER join favourites fav on fav.nekretnina_id=nek.nekretnina_id GROUP by (fav.nekretnina_id) ORDER by count(nek.nekretnina_id) desc limit 10";
         try{
            
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                
                Nekretnina nek=new Nekretnina();
                
                nek.setNekretninaId(rs.getInt(1));
                nek.setGrad(rs.getString(2));
                nek.setUlica(rs.getString(3));
                nek.setGodinaIzgradnje(rs.getInt(4));
                nek.setTip(rs.getString(5));
                
                   
                nekretnine.add(nek);
                
            }
            
             request.setAttribute("omiljene", nekretnine);
             request.getRequestDispatcher("MenadzerOmiljene1.jsp").forward(request, response);
            
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
