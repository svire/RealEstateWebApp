
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
    <div style="background-color:#ceeced;margin:50px; height: 700px;" class="container pt-lg-3 pb-md-5" >
        <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Admin dodaj korisnika</h1> </center>
         <%           String poruka=(String)request.getAttribute("poruka");   
                        if(poruka!=null&&poruka.length()>0){  %>
                 <h3 style="background-color:darkred; width: 30%;"><%=poruka%></h3>
                 
            <% } %>
                     
                        
        
        
      <center> <div id="greska1"></div></center>
        <center>
        <form action="KreirajKorisnika" method="post" class="prijava" style="margin:50px;" onsubmit="return validacija()">             
                <table id="table" cellpadding="3">
               
                    <tr>
                        <td>Ime</td>
                        <td><input type="text" name="ime" id="ime"></td>
                    </tr>
                     <tr>
                        <td>Prezime</td>
                        <td><input type="text" name="prezime" id="prezime"></td>
                    </tr>
                    
                    <tr>
                        <td>Korisnicko ime:</td>
                        <td><input type="text" name="username" id="username"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" id="password"></td>
                    </tr>
                     <tr>
                        <td>Ponovi Password:</td>
                        <td><input type="text" name="password1" id="password1"></td>
                    </tr>
                     <tr>
                        <td>Adresa:</td>
                        <td><input type="text" name="adresa" id="adresa"></td>
                    </tr>
                     <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" id="email"></td>
                    </tr>
                     <tr>
                        <td>Telefon:</td>
                        <td><input type="text" name="telefon" id="telefon"></td>
                    </tr>
                     <tr>
                        <td>Izaberi poziciju:</td>
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
 <%@include  file="footer.jsp" %>
 <script type="text/javascript">
        function validacija()
        {
            greska=document.getElementById("greska1");
            ime=document.getElementById("ime").value;
            prezime=document.getElementById("prezime").value;
            username=document.getElementById("username").value;
            password=document.getElementById("password").value;
            password1=document.getElementById("password1").value;
            adresa=document.getElementById("adresa").value;
            email=document.getElementById("email").value;
            telefon=document.getElementById("telefon").value;
            
            
            
            testpassword=/^[a-zA-Z0-9]{8,16}$/;
            if(ime==null||ime==""||isNaN(ime)==false)
            {
                document.getElementById("ime").focus();
                greska.innerHTML="Unesi ime";
                return false;
            }
             if(prezime==null||prezime==""||isNaN(prezime)==false)
            {
                document.getElementById("prezime").focus();
                greska.innerHTML="Unesi prezime";
                return false;
            }
             if(username==null||username=="")
            {
                document.getElementById("username").focus();
                greska.innerHTML="Unesi username";
                return false;
            }
            var rezultat=password.match(testpassword);
            if(!rezultat)
            {
                 document.getElementById("password").focus();
                 greska.innerHTML="Password treba biti od 8 do 16 karaktera";
            return false;
            }
            var rezultat1=password1.match(testpassword);
            if(!rezultat1)
            {
                 document.getElementById("password1").focus();
                 greska.innerHTML="Password treba biti od 8 do 16 karaktera";
            return false;
            }
            if(password!=password1){
                 document.getElementById("password1").focus();
                 greska.innerHTML="Passwordi se ne poklapaju";
            return false;
            }
            
           
            if(adresa==null||adresa=="")
            {
                 document.getElementById("adresa").focus();
                 greska.innerHTML="Unesite adresu sa brojem";
            return false;
            }
            
            var testemail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            var rezultat2=email.match(testemail);
            if(!rezultat2)
            {
                 document.getElementById("email").focus();
                 greska.innerHTML="Nepravilan forma emaila! Primjer : nesto@gmail.com, nesto1.neso@yahoo.rs";
            return false;
            }
            var testbroj=/^[0-9]{3}\-[0-9]{3}\-[0-9]{3}$/
            var rezultat3=telefon.match(testbroj);
            if(!rezultat3)
            {
                 document.getElementById("telefon").focus();
                 greska.innerHTML="Nepravilan format telefona: Primjer: 065-262-262";
            return false;
            }
            
            
            return true;
        }
         </script>