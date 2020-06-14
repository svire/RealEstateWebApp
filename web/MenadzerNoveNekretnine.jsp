
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
    <div style="background-color:#ceeced;margin:50px; min-height: 700px;"  >
          <center> <h1 style="color:darkcyan;border:1px #008CBA dotted;">Novi oglasi</h1> </center>
         <% String poruka=(String)request.getAttribute("poruka");
         if(poruka!=null){
         %>
         <h3 style="color:darkred;"><%=poruka%></h3>
         <% } %>
           <% 
              
         HttpSession ses=request.getSession();
         String porukas=(String)ses.getAttribute("porukas");
         if(porukas!=null){
         %>
         <h3 style="color:darkred;"><%=porukas%></h3>
         <% } %>
        <div style='margin:25px;'> 
       <form action="MenadzerNoveNekretnine" method="get">
            <center>    <p style="font-size:19px;font-weight: 600;">IZABERI TIP NEKRETNINE:               
         <select name="biraj">
             <option value="SVE">SVE</option> 
             <option value="SALE">SALE</option> 
             <option value="RENT">RENT</option> 
             <option value="DAILY">DAILY</option> 
        </select>
        </p></center>
             <center> <input type="submit" value="Ucitaj stavke"></center>
        </div> 
         
    </form>
        
         <table id="tablica">
       
        <tr id="header">
    
	

            <td><b>TIP</b></td>
            <td><b>Namjena</b></td>
            <td><b>Grad</b></td>
            <td><b>Ulica</b></td>            
            <td><b>Godina izgradnje</b></td>
            <td><b>Kreiran</b></td>  
            <td><b>Vlasnik</b></td>
            <td style="background-color: orange;"><b>STATUS</b></td>   
            
            <td><b style="font-size: 13px;">Odobri</b></td>
            <td><b style="font-size: 13px;">Odbij</b></td>
            <td><b>Dodatno</b></td>
        </tr>
        
        <% ArrayList<Nekretnina> lista=(ArrayList<Nekretnina>)request.getAttribute("lista");
          

        for(Nekretnina pom:lista){  %>
            
      
             
        <tr align="center">
            
            <td><%=pom.getTip()%></td>
            <td><%=pom.getEstateType()%></td>
            <td><%=pom.getGrad()%></td>
            <td><%=pom.getUlica()%></td>
            <td><%=pom.getGodinaIzgradnje()%></td>
            <td><%=pom.getKreiran()%></td>
            <td><%=pom.getVlasnikId()%></td>
            <td style="background-color: orange;"><%=pom.getStatus()%></td>
          
            <td style="background-color: green;"><a style="color:white;font-size: 27px;text-decoration: none;"href="OdobriNekretninu?id=<%=pom.getNekretninaId()%>&status=AKTIVAN">&#x2611;</a></td>
            <td style="background-color: red;"><a style="color:white;font-size: 27px;text-decoration: none;"href="OdobriNekretninu?id=<%=pom.getNekretninaId()%>&status=OBRISAN">&#x2612;</a></td>
            <td style="background-color: #ffbf00;"><a style="color:white;text-decoration: none;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>">Info</a></td>
        </tr>
         <%  }   %>
        
       
    </table> 
      
    </div>

        

</center>
</div>        
 <%@include  file="footer.jsp" %>