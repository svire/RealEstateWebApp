package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class ObradiRezervaciju extends HttpServlet {

  
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession sesija=request.getSession(); 
            Korisnik kor=(Korisnik)sesija.getAttribute("korisnik");
            int odint=kor.getKorisnikID();   
            
            String korid=request.getParameter("korid");
            String bookid=request.getParameter("id");            
            String da=request.getParameter("da");         
            int koridint=0;
            koridint=Integer.parseInt(korid);            
          
            
            Connection kon=null;
            Statement stmt=null;
            
            try{
                kon=Konekcija2.getConnection();
                stmt=kon.createStatement();
                
                
                String insert="";
                String sadrzaj="";
                if(da.equals("da")){
                       insert="update rezervacije set booking_status='ODOBREN' where rezervacija_id='"+bookid+"'";
                       sadrzaj="Postovani korisnice:"+korid+",uspjesno ste rezervisali smjestaj.Pozdrav";
                                    }
                    
                if(da.equals("ne")){
                    insert="update rezervacije set booking_status='ODBIJEN' where rezervacija_id='"+bookid+"'";
                    sadrzaj="Postovani korisnice:"+korid+", nazalost nismo u mogucnosti da Vam na trazeni datum izdamo stan.";
                                    }
                
                stmt.executeUpdate(insert);
                
                String insertporuka="insert into poruka values(null,'"+odint+"','"+korid+"','"+"Drugo"+"','"+sadrzaj+"',CURRENT_TIMESTAMP,'0')";
                try{
                    stmt=kon.createStatement();
                    stmt.executeUpdate(insertporuka);
                    
                    
                }
                catch(SQLException ex){
                    
                      request.setAttribute("poruke", "Doslo je do greske u slanju poruke");
                      request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
                           
                }
               
                
                
            }
            catch(SQLException ex){
                
                request.setAttribute("poruke", "Doslo je do greske u radu sa bazom");
                request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request, response);
                
            }
            finally{
                if(stmt!=null){try{stmt.close(); } catch(SQLException ex){}  }
                if(kon!=null){try{ kon.close(); } catch(SQLException ex){}  }
            }
           
            response.sendRedirect("MenadzerRezervacijeLista");
            
      
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
