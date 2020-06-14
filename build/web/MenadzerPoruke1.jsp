
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>

<%@page import="pomocni.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="javax.servlet.*"%>
<%@include file="MenadzerLista.jsp"%>
<%@include file="banner.jsp"%>



<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; min-height: 750px;" class="container pt-lg-3 pb-md-5" >
        <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Poruka</h1> </center>
        
        
        
        <div class="tab">
            <button class="tablinks" onclick="eventy(event, 'Inbox')">Inbox</button>
            <button class="tablinks" onclick="eventy(event, 'Outbox')">Poslano</button>
            <button class="tablinks" onclick="eventy(event, 'New')">Nova poruka</button>
  
        </div>
         
           <% 
         String poruka=(String)session.getAttribute("poruka");         
         if(poruka!=null)
         {      
        %>
        <h3 style="color:red;"><%=poruka%></h3>        
        <% }   %>
        
       <div id="Inbox" class="tabcontent">
     
            
           
        <table id="tablica">
             
            <tr><td colspan="4" id="header"><center><b>INBOX</td></b></center></tr>
             <%
                 
                
                 ArrayList<Poruka> lista= (ArrayList<Poruka>)request.getAttribute("listaDolaznih");
            for(Poruka kor:lista){ %>
        
          
        
            <tr style="background-color: #535353;color:white;font-size: 18px;">
                 <td>Od:<%=Username.getUsername(kor.getOdId())%></td> <td>Vrijeme:<%=kor.getVrijeme()%></td><td><a href="BrisanjePoruka?id=<%=kor.getPorukaId()%>"><img src='Slike/delete30.png'</a></td>
            </tr>
            <tr>
                   <td width="700"><a href="ProcitajPoruku?id=<%=kor.getPorukaId()%>"><%=kor.getSadrzaj()%></a></td>              
            </tr>
           <% } if(lista.size()==0){ %>
           <tr><td>Inbox je prazan</td></tr>
           <% } %>
        </table> 
          
       
       
        </div>
     
       <div id="Outbox" class="tabcontent">
      <table id="tablica">
             <tr><td colspan="4" id="header"><center><b>SENT</td></b></center></tr>        
             
      <%   
          ArrayList<Poruka> lista1= (ArrayList<Poruka>)request.getAttribute("listaOdlaznih");
          for(Poruka odl:lista1){ %>
      
      
             <tr style="background-color: #535353;color:white;font-size: 18px;"> 
                <td>Za:<%=Username.getUsername(odl.getZaId())%></td> <td>Vrijeme:<%=odl.getVrijeme()%></td><td><a href="BrisanjePoruka?id=<%=odl.getPorukaId()%>"><img src='Slike/delete30.png'</a></td>
            </tr>
             <tr>                
                <td width="700" ><%=odl.getSadrzaj()%></td>
            </tr>
            <%} if(lista1.size()==0){%>
            <tr><td>Nema poruka u odlaznom sanducetu.</td></tr>
            <% } %>
        </table> 
         
           
           
      </div> 
        
        
        <div id="New" class="tabcontent">
       
       
  <form action="PosaljiPoruku" method="post">
        <table id="tablica">
            <tr id="header">
                <td>Subject:</td>
                <td>
                    <select name="tema">
                        <option value="pitanje">Pitanje</option>
                        <option value="reklamacija">Reklamacija</option>
                        <option value="drugo">Drugo</option> 
                    </select>                    
                <td></td>
            </tr>
            <%
               ArrayList<Korisnik> kor=new ArrayList<Korisnik>();
               
               kor=ListaKorisnika.getInfo();
                
            %>
            <tr id="header">
                <td>Primaoc:</td>
                <td>
                    <select name="za">
                        <% for(Korisnik pom:kor){ %>
                        <option value="<%=pom.getKorisnikID()%>"> <%=pom.getUsername()%>  </option>
                          <%} %>
                    </select>                    
                <td></td>
            </tr>
            <tr>
                <td colspan="3">Poruka:</td>
                
            </tr>
            <tr>
                <td colspan="3">
                    <textarea cols="40" rows="7" name="sadrzaj">
                    
                    </textarea> 
                </td>
            </tr>
            <tr>
                <td colspan="3">
            <center>
                <input type="submit" value="Posalji"></center>
                </td>
            </tr>
            
      
        
           </table>
    </form>
    
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
 