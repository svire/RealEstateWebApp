<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="AdminLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden;min-height: 500px;">
     <center>
    <div style="background-color:#ceeced;margin:40px;width: 1300px; min-height: 1000px;" >
       <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Admin korisnici</h1> </center>
      
      <% String poruka=(String)request.getAttribute("poruka");
      if(poruka!=null){
                        %>
      <center>  <h3 style="background-color:darkred; width: 30%;"><%=poruka%></h3></center>
                 
      <% }%>
         <% String poruka1=(String)request.getAttribute("poruka1");
      if(poruka1!=null){
                        %>
      <center>  <h3 style="background-color:darkred; width: 30%;"><%=poruka1%></h3></center>
                 
      <% }%>
        <table id="tablica">
            <tr id="header">
            <td><b>Ime</b></td>
            <td><b>Prezime</b></td>
            <td><b>Korisnicko ime</b></td>
            <td><b>Adresa</b></td>
            <td><b>Email</b></td>
            <td><b>Telefon</b></td>           
            <td><b>Pozicija</b></td>            
            <td><b>Promjeni</b></td>
            <td><b>Blokiraj</b></td>
            </tr>
            <% ArrayList<Korisnik> lista=(ArrayList<Korisnik>)request.getAttribute("korisnici"); 
            for(Korisnik kor:lista){
            %>
            <tr align="center">
                <td><%=kor.getIme()%></td>
                <td><%=kor.getPrezime()%></td>
                <td><%=kor.getUsername()%></td>
                <td><%=kor.getAdresa()%></td>
                <td><%=kor.getEmail()%></td>
                <td><%=kor.getTelefon()%></td>
                <td><%=kor.getPozicija()%></td>
                <td style="background-color: #ffbf00;"><a href="AdminPromjeniKorisnika?korid=<%=kor.getKorisnikID()%>">Promjeni</a></td>
                <td style="background-color: #ffbf00;"><a href="BlokirajKorisnika?korid=<%=kor.getKorisnikID()%>">BLOKIRAJ</a></td>
                
            </tr>
          <% } %>
        
        </table>
    </div>
</center>
</div>        
 <%@include  file="footer.jsp" %>        