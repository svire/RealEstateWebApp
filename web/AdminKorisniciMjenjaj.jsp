<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@include file="AdminLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:40px;width: 1300px; height: 1000px;" >
        <h1><b>Promjeni podatke</b></h1>
       
    <center>
    <div style="background-color:#ceeced;margin:50px; height: 700px;" class="container pt-lg-3 pb-md-5" >
       
         <%           String poruka=(String)request.getAttribute("poruka");   
                        if(poruka!=null&&poruka.length()>0){  %>
                 <h3 style="background-color:darkred; width: 30%;"><%=poruka%></h3>
                 
            <% } %>
                     
                        
        
        
      <center> <div id="greska1"></div></center>
        <center>
              <form action="PromjeniKorisnika" method="post" style="margin:50px;" onsubmit="return validacija()">
                   <% 
                       HttpSession ses=request.getSession();
                       Korisnik korisnik=(Korisnik)ses.getAttribute("korisnik");             
                   %>
               <table id="table" cellpadding="3">
                    <tr>
                        <td>Korisnik ID:</td>
                        <td><input type="text" name="id"  readonly value="<%=korisnik.getKorisnikID()%>"></td>
                    </tr>
                    <tr>
                        <td>Ime:</td>
                        <td><input type="text" name="ime" id="ime" value="<%=korisnik.getIme()%>"></td>
                    </tr>
                     <tr>
                        <td>Prezime:</td>
                        <td><input type="text" name="prezime" id="prezime" value="<%=korisnik.getPrezime()%>"></td>
                    </tr>
                    
                    <tr>
                        <td>Korisnicko ime:</td>
                        <td><input type="text" name="username" readonly id="username" value="<%=korisnik.getUsername()%>"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" id="password" value="<%=korisnik.getPassword()%>"></td>
                    </tr>                   
                     <tr>
                        <td>Adresa:</td>
                        <td><input type="text" name="adresa" id="adresa" value="<%=korisnik.getAdresa()%>"></td>
                    </tr>
                     <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" id="email" value="<%=korisnik.getEmail()%>"></td>
                    </tr>
                     <tr>
                        <td>Telefon:</td>
                        <td><input type="text" name="telefon" id="telefon" value="<%=korisnik.getTelefon()%>"></td>
                    </tr>
                     <tr>
                        <td style="color:blueviolet;">Stara Pozicija:</td>
                        <td><input type="text" name="stara" value="<%=korisnik.getPozicija()%>" readonly style="background-color: yellow;"></td>
                    </tr>
                    <tr>
                        <td style="color:blueviolet;">Nova pozicija:</td>
                        <td>
                            <select name="pozicija">
                                <option value="admin">Admin</option>
                                <option value="menadzer">Menadzer</option>
                                <option value="klijent">Klijent</option>
                                <option value="korisnik">Korisnik</option>
                            </select>
                         </td>
                        
                    </tr>
                    <tr>
                        <td colspan="2">
                    <center>    <input type="submit" value="Submit">     <input type="reset" value="Reset">      </center>        
                        </td>
                    </tr>                   
                  </table>       
            </form>   
    </div>
  
        

</center>
      
        
        
    </div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>