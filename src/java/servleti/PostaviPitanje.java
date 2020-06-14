package servleti;

import beans.Konekcija;
import beans.Konekcija2;
import beans.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
public class PostaviPitanje extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        HttpSession sesija=request.getSession();        
        String tema=request.getParameter("tema");                      //tema
        String sadrzaj=request.getParameter("sadrzaj");
        String za=request.getParameter("za");
        //int zaint=Integer.parseInt(za);
        
        String grad=request.getParameter("grad");
        String ulica=request.getParameter("ulica");
        String tip=request.getParameter("tip");
        
        Korisnik kor=(Korisnik)sesija.getAttribute("korisnik");
        int korid=kor.getKorisnikID();                                 //korisnikiD ko salje
        int menadzerid=4;                                                //menadzerID
        boolean read=false;                                  //status
        
        
        String pozicija="";
        pozicija=kor.getPozicija();
        String redirect="";
         if(pozicija.equals("korisnik")){
             
             redirect="PorukeKorisnika";
         }
        
         String slanje="Pitanje za:Grad:"+grad+",Ulica:"+ulica+",Tip:"+tip+".Sadrzaj:"+sadrzaj;
               
        
         Connection kon=null;
         Statement stmt=null;
      
       //  ResultSet rs=null; 
       //  ResultSet rs1=null;
         try{
               
               kon=Konekcija2.getConnection();
               stmt=kon.createStatement();
               
               
             
               String insertporuka="insert into poruka values(null,'"+korid+"','4','"+tema+"','"+slanje+"',CURRENT_TIMESTAMP,'0')";
                 
               stmt.executeUpdate(insertporuka);
                             
               
             //  request.setAttribute("poruka", "Poslana poruka.");
               sesija.setAttribute("poruka", "Poslana poruka.");
               response.sendRedirect(redirect);
              
        }
        catch(Exception e){
            
             request.setAttribute("poruka", "Greska pri slanju poruke");
             request.getRequestDispatcher("AdminPoruke.jsp").forward(request, response);
            
        }
        finally{
             if(stmt!=null){  try{ stmt.close();  }catch(SQLException ex){   }   }
             if(kon!=null){  try{ kon.close();  }catch(SQLException ex){   }   }
          
         }
       
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
