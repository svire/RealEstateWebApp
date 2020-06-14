package servleti;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 *
 * @author Djole
 */
public class DodajSliku extends HttpServlet {

  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nekid=request.getParameter("id");
        
        HttpSession session=request.getSession();
              
        String redirect="KlijentSamoSlike.jsp?id="+nekid;
        
        ///UBACI SLIKE U BAZU////////////////////       
        int nekidint=Integer.parseInt(nekid);
        ArrayList<String> slibe=new ArrayList<String>();
        
        
        if(session.getAttribute("nizslika")==null){
            request.setAttribute("poruka", "Dodajte prvo slike...");
            request.getRequestDispatcher(redirect).forward(request, response);
                
            }
        
        if(session.getAttribute("nizslika")!=null){
            
        slibe=(ArrayList<String>)session.getAttribute("nizslika");
        String title="standard";
        
        Connection kon=null;
        Statement stmt=null;
        try
        {
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            if(slibe!=null)
                         {
                         for(int i=0;i<slibe.size();i++){
           
                         
                         String insert4="insert into nekretnine_slike values (null,'"+nekid+"','"+slibe.get(i)+"','AKTIVNA','alt','"+title+"') ";
                         stmt.executeUpdate(insert4);
                             }
                        }
            
        }
        catch(SQLException ex)
        {
            request.setAttribute("poruka", "Greska prilikom dodavanja slika");
            request.getRequestDispatcher(redirect).forward(request, response);  
            
        }
        finally{
              if(kon!=null){   try{  kon.close();}   catch(Exception exc){} } 
              if(stmt!=null)  { try{ stmt.close(); } catch(Exception exc){} }   
              
        }
        
        
        
        
        
         slibe=new ArrayList<String>();
         session.setAttribute("nizslika", slibe);
         
        request.setAttribute("poruka", "Uspjesan unos slika");
        request.getRequestDispatcher(redirect).forward(request, response);   
            
            
        }
             
        
    }

    
    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
