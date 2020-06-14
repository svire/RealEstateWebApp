
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="MenadzerLista.jsp"%>
<%@include file="banner.jsp"%>




<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; min-height: 750px;">
      
            
        
          
        <div class="tab">
            
            <button class="tablinks" onclick="eventy(event, 'Inbox')">Cekanje</button>
            <button class="tablinks" onclick="eventy(event, 'Outbox')">Odobrene</button>
            <button class="tablinks" onclick="eventy(event, 'New')">Odbijene</button>
  
        </div>
        <center> <h1 style="color:darkcyan;">Rezervacije</h1> </center>
       <div id="Inbox" class="tabcontent">
        <center><h3 style="color:red;">Cekanje</h3></center>
        <% 
         String poruka=(String)request.getAttribute("poruka");         
         if(poruka!=null)
         {      
        %>
        <h3 style="color:red;"><%=poruka%></h3>        
        <% }%>
           <table id="tablica">
            <tr id="header">
                 <td><b>Nekretnina_id:</b></td><td><b>Korisnik_id:</b></td><td><b>STATUS:</b></td><td><b>CHECK IN:</b></td><td><b>CHECK OUT:</b></td><td><b>Detalji:</b></td>  
                 <td><b>ODOBRI</b></td><td><b>Info</b></td>
                               
            </tr>
               
           <%  ArrayList<Rezervacije> lista=(ArrayList<Rezervacije>)request.getAttribute("lista");
               
           %>
               <% for(Rezervacije pom:lista){ 
                    if(pom.getBookingStatus().equals("CEKANJE")){
            %>
            <tr>
                <td><%=pom.getNekretninaId()%></td><td><%=pom.getKorisnikId()%></td><td><%=pom.getBookingStatus()%></td>
                <td><%=pom.getBookingStartDate()%></td> <td><%=pom.getBokkingEndDate()%></td><td><%=pom.getDetalji()%></td>
                 <td style="background-color: green;"><a style="color:white;text-decoration: none;"href="ObradiRezervaciju?id=<%=pom.getRezervacijaId()%>&korid=<%=pom.getKorisnikId()%>&da=da">Odobri</a></td>
                 <td style="background-color: red;"><a style="color:white;text-decoration: none;"  href="ObradiRezervaciju?id=<%=pom.getRezervacijaId()%>&korid=<%=pom.getKorisnikId()%>&da=ne">Odbij</a></td>
     
            </tr>
            
            <% } %>
            
            
            <%  }  %>
            
            
        </table>
           
       
       </div>
     
       <div id="Outbox" class="tabcontent">
           <center><h3 style="color:red;">Odobrene</h3></center>
           
            <div style='margin:25px;'> 
         
          
             
        </div> 
            
        
                     
         <table id="tablica">
            <tr id="header">
                 <td><b>Nekretnina_id:</b></td><td><b>Korisnik_id:</b></td><td><b>STATUS:</b></td><td><b>CHECK IN:</b></td><td><b>CHECK OUT:</b></td><td><b>Detalji:</b></td>  
                
            </tr>
            <% for(Rezervacije pom:lista){ 
                    if(pom.getBookingStatus().equals("ODOBREN")){
            %>
            <tr>
                  <td><a href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getNekretninaId()%></a></td>
                
                
                <td><%=pom.getKorisnikId()%></td><td><%=pom.getBookingStatus()%></td>
                <td><%=pom.getBookingStartDate()%></td> <td><%=pom.getBokkingEndDate()%></td><td><%=pom.getDetalji()%></td>
               
            </tr>
            
            <% } %>
            
            
            <%  }  %>
            
      
        </table>
      </div> 
        
        
           <div id="New" class="tabcontent">
                <center><h3 style="color:red;">Odbijene</h3></center>
       
         <table id="tablica">
            <tr id="header">
                 <td><b>Nekretnina_id:</b></td><td><b>Korisnik_id:</b></td><td><b>STATUS:</b></td><td><b>CHECK IN:</b></td><td><b>CHECK OUT:</b></td><td><b>Detalji:</b></td>  
                             
            </tr>
                <% for(Rezervacije pom:lista){ 
                    if(pom.getBookingStatus().equals("ODBIJEN")){
            %>
            <tr>
                <td><%=pom.getNekretninaId()%></td><td><%=pom.getKorisnikId()%></td><td><%=pom.getBookingStatus()%></td>
                <td><%=pom.getBookingStartDate()%></td> <td><%=pom.getBokkingEndDate()%></td><td><%=pom.getDetalji()%></td>
               
            </tr>
            
            <% } %>
            
            
            <%  }  %>          
                  
        </table>               
</div>
        
        
        
        
        
        
         

        
        
  </div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
<script>
 
    function eventy(evt, eventy) {
  // Declare all variables
  var i, tabcontent, tablinks;

  // Get all elements with class="tabcontent" and hide them
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Get all elements with class="tablinks" and remove the class "active"
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(eventy).style.display = "block";
  evt.currentTarget.className += " active";
}
    
    </script> 
 