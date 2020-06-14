package servleti;

import beans.Konekcija2;
import beans.Rezervacije;
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
import beans.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Djole
 */
public class KorisnikRezervacije extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Rezervacije> rezervacije=new ArrayList<Rezervacije>();
       
        Connection kon=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        HttpSession ses=request.getSession();    
        Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
        int korid=kor.getKorisnikID();
        
        
        
        
        String qvery="select * from rezervacije where korisnik_id='"+korid+"'";  
   
        
        try{
            kon=Konekcija2.getConnection();
            stmt=kon.createStatement();
            rs=stmt.executeQuery(qvery);
            while(rs.next()){
                Rezervacije rez=new Rezervacije();
                rez.setRezervacijaId(rs.getInt(1));
                rez.setNekretninaId(rs.getInt(2));
                rez.setKorisnikId(rs.getInt(3));
                rez.setBookingStatus(rs.getString(4));
                rez.setBookingStartDate(rs.getString(5));
                rez.setBokkingEndDate(rs.getString(6));
                rez.setDetalji(rs.getString(7));                
                
                rezervacije.add(rez);
               
                
            }
            
                        
        }
        catch(SQLException ex)
        {            
             request.setAttribute("poruka", qvery);
             request.getRequestDispatcher("KorisnikPocetna.jsp").forward(request, response);
        }       
        finally
            {
                 if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                 if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                 if(rs!=null) { try{ rs.close();    } catch(SQLException ex){}  }
            }
        
        request.setAttribute("rezervacije", rezervacije);
        request.getRequestDispatcher("KorisnikRezervacije.jsp").forward(request, response);
        
       
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
