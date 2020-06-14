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
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import beans.*;

/**
 *
 * @author Djole
 */


  

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploadServlet3 extends HttpServlet {
        
    private final static Logger LOGGER =
            Logger.getLogger(FileUploadServlet2.class.getCanonicalName());
    private static final long serialVersionUID = 7908187011456392847L;

    
   ///////////////////////////////////////////////////////
    /////KlijentSamoSlike.jsp?id=12    REDIRECT
    ///////////////////////////
    
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

         HttpSession s=request.getSession();
         Korisnik kor=(Korisnik)s.getAttribute("korisnik");
         String pozicija=kor.getPozicija();
         
         
         String nekid=request.getParameter("nekid");
         
         String redirect="KlijentSamoSlike.jsp?id="+nekid;
             
         ArrayList<String> slike=new ArrayList<String>();
         if((ArrayList<String>)s.getAttribute("nizslika")!=null){
         
          slike=(ArrayList<String>)s.getAttribute("nizslika");
         }
        // slike=(ArrayList<String>)s.getAttribute("nizslika");
        // Create path components to save the file
        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
          
           slike.add(fileName);
           
           
          String niz="";
          String poruka="Uspjesno dodana nova slika"+fileName;
          
          s.setAttribute("nizslika", slike);
          request.setAttribute("poruka", poruka);
          request.getRequestDispatcher(redirect).forward(request, response);

        } catch (FileNotFoundException fne) {
      
          request.setAttribute("poruka", "Niste izabrali sliku za upload");
          request.getRequestDispatcher(redirect).forward(request, response);
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
//ovdje negdje provjera ekstenzije 
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
                
            }
        }
        return null;
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String id=request.getParameter("id");
        PrintWriter out = response.getWriter();
        out.println(id);  //pise 1
        
         ArrayList<String> slibe=new ArrayList<String>();
         HttpSession s=request.getSession();
         if((ArrayList<String>)s.getAttribute("nizslika")!=null){
             slibe=(ArrayList<String>)s.getAttribute("nizslika");
         }
         slibe.remove(Integer.parseInt(id));
          request.setAttribute("poruka", "Obrisana slika");
          request.getRequestDispatcher("KlijentSamoSlike.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Servlet that uploads files to a user-defined destination";
    }
}