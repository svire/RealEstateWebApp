package servleti;

import beans.Korisnik;
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
/**
 *
 * @author Djole
 */
public class IstakniOglas extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
        String nekid=request.getParameter("nekid");
        String tip=request.getParameter("tip");//
        
        HttpSession ses=request.getSession();    
        Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
        int korid=kor.getKorisnikID();
        
        String redirect="";
        
        if(tip.equals("GLEDANO")){
        
         redirect="MenadzerIstaknuti";
        
        }
        if(tip.equals("NAJ")){
        
         redirect="MenadzerNajgledanije";
        
        }
         if(tip.equals("OMI")){
        
         redirect="MenadzerOmiljene";
        
        }
          if(tip.equals("PRE")){
        
         redirect="MenadzerPretrazi";
        
        }
        
        
        String fav="select * from favourites where nekretnina_id='"+nekid+"' and korisnik_id='"+korid+"'";
        
        int id=0;
        ResultSet rs=null;
        
        
        Connection kon=null;
        Statement stmt=null;
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(fav);
            if(rs.next()){
                
                String delete="delete from favourites where nekretnina_id='"+nekid+"' and korisnik_id='"+korid+"'";
                try{
                    stmt=kon.createStatement();
                    stmt.executeUpdate(delete);
                     request.getRequestDispatcher(redirect).forward(request, response);
                
                }
                catch(SQLException ex){
            
                     request.setAttribute("poruka", "Doslo je greske u radu sa bazom.");
                     request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
                 }
                
                
                
            }
            else{
                
                String insert="insert into favourites values(null,'"+nekid+"','"+korid+"')";
                
                 try{
                    stmt=kon.createStatement();
                    stmt.executeUpdate(insert);
                    
                    
                    
               request.setAttribute("poruka", "Dodano u favorite!");
               request.getRequestDispatcher(redirect).forward(request, response);
                    
                }
                catch(SQLException ex){
            
                     request.setAttribute("poruka", "Doslo je do greske u radu sa bazom");
                     request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
                 }
                                                  
            }            
            
            
        }
        catch(SQLException ex){
            
            request.setAttribute("poruka", "Doslo je do greske u radu sa bazom   rs1");
            request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
        }
        finally{
            if(stmt!=null){ try{ stmt.close(); } catch(SQLException ex){ }  }    
            if(kon!=null){ try{ kon.close(); } catch(SQLException ex){ }  }
        }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
