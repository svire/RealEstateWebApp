
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
        <center> <h1 style="color:darkcyan;">Istaknuti oglasi</h1> </center>
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
               <%       
             Konekcija kon=new Konekcija();
    
             ResultSet rs,rs1;
            
             String podaci="select * from rezervacije where booking_status='CEKANJE'";
             rs1=kon.query(podaci);
      

             
         
        while(rs1.next())
        {
            int bookid=rs1.getInt(1);
            int nekid=rs1.getInt(2);
            int korid=rs1.getInt(3);
            String booking_status=rs1.getString(4);
            String checkin=rs1.getString(5);
            String checkout=rs1.getString(6);
            String detalji=rs1.getString(7);
           
             %>
        <tr align="center">
            <td><a href="DodatneInfo1?id=<%=nekid%>"><%=nekid%></a></td>
            <td><%=korid%></td>
            <td style="background-color: orange;"><%=booking_status%></td>
            <td><%=checkin%></td>
            <td><%=checkout%></td>
            <td><%=detalji%></td>
           
          
          <td style="background-color: green;"><a style="color:white;text-decoration: none;"href="MenadzerRezervacije?id=<%=bookid%>&korid=<%=korid%>&da=da">Odobri</a></td>
            <td style="background-color: red;"><a style="color:white;text-decoration: none;" href="MenadzerRezervacije?id=<%=bookid%>&korid=<%=korid%>&da=ne">Odbij</a></td>
        </tr>
        
        <% } %>
            
            
        </table>
           
       
       </div>
     
       <div id="Outbox" class="tabcontent">
           <center><h3 style="color:red;">Odobrene</h3></center>
           
            <div style='margin:25px;'> 
        <form action="MenadzerRezervacije.jsp" method="post">
            <center>    <p style="font-size:17px;">NekretninaID:           
                    <% ResultSet rs5;
                    String stan="select nekretnina_id from stannadan";
                    rs5=kon.query(stan);
                    String se="asd";
                    %>
                    
         <select name="biraj">
             <option value="<%=se%>">SVE</option>  
           <%  while(rs5.next()){  %>
           <option value="<%=rs5.getInt(1)%>"><%=rs5.getInt(1)%></option>    
           <% }%>
        </select>
        </p></center>
             <center> <input type="submit" value="Ucitaj stavke"></center>
        </div> 
            
           <%
               
           String param=request.getParameter("biraj");
           
           ResultSet rs3;
           String blage="";
          
           if(param!=null){
                blage="select * from rezervacije where booking_status='ODOBREN' and nekretnina_id='"+param+"'";
           }//ne radi param..
            else{
               blage="select * from rezervacije where booking_status='ODOBREN'";
           }
           
            %>
           
         <table id="tablica">
            <tr id="header">
                 <td><b>Nekretnina_id:</b></td><td><b>Korisnik_id:</b></td><td><b>STATUS:</b></td><td><b>CHECK IN:</b></td><td><b>CHECK OUT:</b></td><td><b>Detalji:</b></td>  
                
            </tr>
               <%       
            
             rs1=kon.query(blage);
      

             
         
        while(rs1.next())
        {
            int bookid=rs1.getInt(1);
            int nekid=rs1.getInt(2);
            int korid=rs1.getInt(3);
            String booking_status=rs1.getString(4);
            String checkin=rs1.getString(5);
            String checkout=rs1.getString(6);
            String detalji=rs1.getString(7);
           
             %>
        <tr align="center">
            <td><a href="DodatneInfo1?id=<%=nekid%>"><%=nekid%></a></td>
            <td><%=korid%></td>
            <td style="background-color: orange;"><%=booking_status%></td>
            <td><%=checkin%></td>
            <td><%=checkout%></td>
            <td><%=detalji%></td>
           
          
           </tr>
        
        <% } %>
            
        </table>
      </div> 
        
        
        
        
        
        
        
        
        
        
        
        
        
           <div id="New" class="tabcontent">
                <center><h3 style="color:red;">Odbijene</h3></center>
        <%
               
           ResultSet rs4;
                  
         String blage1="select * from rezervacije where booking_status='ODBIJEN'";
          
            %>           
         <table id="tablica">
            <tr id="header">
                 <td><b>Nekretnina_id:</b></td><td><b>Korisnik_id:</b></td><td><b>STATUS:</b></td><td><b>CHECK IN:</b></td><td><b>CHECK OUT:</b></td><td><b>Detalji:</b></td>  
                             
            </tr>
               <%                   
             rs4=kon.query(blage1);
             String por="Nema odbijenih rezervacija";            
        while(rs4.next())
        {           
            
            int bookid=rs4.getInt(1);
            int nekid=rs4.getInt(2);
            int korid=rs4.getInt(3);
            String booking_status=rs4.getString(4);
            String checkin=rs4.getString(5);
            String checkout=rs4.getString(6);
            String detalji=rs4.getString(7);          
             %>
        <tr align="center">
            <td><a href="DodatneInfo1?id=<%=nekid%>"><%=nekid%></a></td>
            <td><%=korid%></td>
            <td style="background-color: orange;"><%=booking_status%></td>
            <td><%=checkin%></td>
            <td><%=checkout%></td>
            <td><%=detalji%></td>
           
             </tr>        
        <% } %>            
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
 