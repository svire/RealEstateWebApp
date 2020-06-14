
<%@page import="pomocni.KorRezervacije"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="javax.servlet.*"%>
<%@include file="KorisnikLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; height: 700px;" class="container pt-lg-3 pb-md-5" >
  
         <div class="tab">
            <button class="tablinks" ><a href="KorisnikRezervacije">Rezervacije</a></button>
            <button class="tablinks" ><a href="KorisnikPisiRecenzije.jsp">Pisi recenzije &#x270D;</a></button>
            <button class="tablinks" ><a style="color:red;" href="KorisnikMojiFavoriti">Moji favoriti &#x2764;</a></button>
            <button class="tablinks" ><a href="PorukeKorisnika">Poruke &#x2709;</a></button>
        </div>
        <center> <h1 style="color:darkcyan;">Moje rezervacije</h1> </center>
        
        <% String poruka=(String)session.getAttribute("poruka");
         if(poruka!=null){
        %>
        <h1><%=poruka%></h1>
        
        <% } %>
          <%
                ArrayList<Rezervacije> rez=(ArrayList<Rezervacije>)request.getAttribute("rezervacije");
                
    
    
    %>
        <table id="tablica">
            <tr id="header">
                <th><b>Grad:</b></td><th><b>Ulica:</b></td><th><b>Booking status:</b></td><th><b>Od:</b></td><th><b>Do:</b></td>
            </tr>
             <%     for(Rezervacije pom:rez){  

                 String[] info=KorRezervacije.getInfo(pom.getNekretninaId());
             %>
             <tr>             
                 <td> <%=info[0]%></td><td><%=info[1]%></td><td><%=pom.getBookingStatus()%></td><td><%=pom.getBookingStartDate()%></td><td><%=pom.getBokkingEndDate()%></td>
            </tr>       
                

        <%    }      %>
        </table>
      
    </div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
 