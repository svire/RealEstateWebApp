package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;
import java.sql.*;
/**
 *
 * @author Djole
 */
public class Prijava extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sesija=request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
      
        Connection kon=null;
        ResultSet rs=null;
        Statement stmt=null;
        
        if(username!=null&&username.length()>0&&password!=null&&password.length()>0)
        {
            try{
              
                kon=Konekcija2.getConnection();
                
                String upit="SELECT * from korisnik where username='"+username+"' and password='"+password+"'";
                stmt=kon.createStatement();
                rs=stmt.executeQuery(upit);
                
                if(rs.next())
                {
                    Korisnik kor=new Korisnik();                   
                    String pozicija=rs.getString("pozicija");
                    int korisnikid=rs.getInt("korisnikID");
                    
                    
                    stmt.close();
                    kon.close();
                    
                    kor.setUsername(username);
                    kor.setPassword(password);
                    kor.setPozicija(pozicija);
                    kor.setKorisnikID(korisnikid);
                    kor.setPozicija(pozicija);
                    
                    
                    
                    
                    if(pozicija.equals("admin")){
                        sesija.setAttribute("korisnik",kor);
                        request.getRequestDispatcher("AdminDodajKorisnika.jsp").forward(request,response);
                        
                    }
                    if(pozicija.equals("menadzer")){
                        sesija.setAttribute("korisnik",kor);
                        request.getRequestDispatcher("MenadzerPocetna.jsp").forward(request,response);
                        
                    }
                    if(pozicija.equals("korisnik")){
                        sesija.setAttribute("korisnik",kor);                     
                       response.sendRedirect("KorisnikPocetna");
                      
                    }
                    if(pozicija.equals("klijent")){
                        sesija.setAttribute("korisnik",kor);
                        request.getRequestDispatcher("KlijentNoveNekretnine.jsp").forward(request,response);
                       
                    }
                    if(pozicija.equals("BLOKIRAN")){
                        request.setAttribute("poruka", "Blokirani ste zbog krsenja pravila!Nema ulaza!");
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                      
                    }
                   
                    
                    
                }
                else{
                    stmt.close();
                    kon.close();
                    request.setAttribute("poruka","Nispravno korisnicko ime ili lozinka.");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
                            
                
                
                }
           
            catch(SQLException sqle){
                
                 
                request.setAttribute("poruka","Doslo je do greske u radu sa bazom!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                
            }
            finally{
                if(kon!=null){  try{ kon.close();  }catch(Exception ex){ }  }
                if(stmt!=null){ try{ stmt.close(); }catch(Exception ex){ }  }
            }
           
            
            
            
        }
        else{
            request.setAttribute("poruka","Niste popunili sva polja");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
