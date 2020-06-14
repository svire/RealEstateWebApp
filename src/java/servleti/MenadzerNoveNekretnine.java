package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import beans.*;
import java.util.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class MenadzerNoveNekretnine extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String biraj=request.getParameter("biraj");
        
        HttpSession s=request.getSession();
        Korisnik kor=(Korisnik)s.getAttribute("korisnik");
        int vlasid=kor.getKorisnikID();
        
        
        if(request.getAttribute("poruka")!=null){
            request.setAttribute("poruka", request.getAttribute("poruka"));
        }
        
        ArrayList<Nekretnina> listanek=new ArrayList<Nekretnina>();
        
        String podaci="";
        if(biraj.equals("SVE"))
        {
            podaci="select * from nekretnina where status='ODOBRI'";
        }
        else
        {
         podaci="select * from nekretnina where status='ODOBRI' and tip='"+biraj+"'";
        }
        
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(podaci);
            
             
            
            while(rs.next()){
            Nekretnina nekj=new Nekretnina();    
                
            int id=rs.getInt(1);
            String tip=rs.getString(2);
            String tip_nekretnine=rs.getString(3);
            String grad=rs.getString(4);
            String ulica=rs.getString(5);
            int godinaizgradnje=rs.getInt(10);
            String kreiran=rs.getString(18);
            int vlasnik=rs.getInt(19);
            String status=rs.getString(20); 
                
            
            
            nekj.setNekretninaId(id);
            nekj.setTip(tip);
            nekj.setEstateType(tip_nekretnine);
            nekj.setGrad(grad);
            nekj.setUlica(ulica);
            nekj.setGodinaIzgradnje(godinaizgradnje);
            nekj.setKreiran(kreiran);
            nekj.setVlasnikId(vlasnik);
            nekj.setStatus(status);
            
            
            listanek.add(nekj);
            }
            
             if(listanek.size()==0){
             
               request.setAttribute("poruka", "Nema takvih nekretnina");
               
             }
            request.setAttribute("lista", listanek);
            
        }
        catch(SQLException e)
           {
               
                request.setAttribute("poruka", "ne radi nesto");
                request.getRequestDispatcher("PosjetilacProdaja.jsp").forward(request, response);
           }
        finally{
                if(rs!=null){ try{ rs.close(); } catch(SQLException ex){  }    }
                if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){  }    }
                 if(rs!=null){ try{ rs.close(); } catch(SQLException ex){  }    }
            }
        
     
   
        request.getRequestDispatcher("MenadzerNoveNekretnine.jsp").forward(request, response);
    
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
