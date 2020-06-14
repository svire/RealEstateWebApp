


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="PosjetilacLista.jsp"%>
<%@include file="banner.jsp"%>

<script>
     function validacija()
        {
            
            greska=document.getElementById("greska1");    
            username=document.getElementById("username").value;
            pass=document.getElementById("password").value;
            
            
            
            if(username==null||username==""){
                document.getElementById("username").focus();
                greska.innerHTML="Unesite username...";
                return false;
            }
            
            
            if(pass==null||pass==""||!pass.match(/^.{8,12}$/)){
                document.getElementById("password").focus();
                greska.innerHTML="Password mora da sadrzi od 8 do 16 karaktera...";
                return false;
            }
            
            
            return true;
        }  
    
    
</script>
<div id="container"  style="min-height: 300px;">
    
    
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced; min-height: 400px;" class="container pt-lg-3 pb-md-5" >
            <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Ulogujte se</h1> </center>
        <center> <div style="color:red;font-size:25px;" id="greska1"></div></center>
       <center>
            <%  String poruka=(String)request.getAttribute("poruka");
            if(poruka!=null){
            %> 
            <h3 style="color:darkred; width: 30%;"><%=poruka%></h3>
            <% } %>
            
            
       <div id="forma">            
            
            <form action="Prijava" method="post" onsubmit="return validacija()">             
                <table cellpadding="4" style="margin:100px;font-size:20px;">
                    <tr>
                        <td>Korisnicko ime:</td>
                        <td><input type="text" name="username" id="username"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" id="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                    <center>   <input type="submit" value="Login">     <input type="reset" value="Reset">      </center>    
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><center><a style="color:red;font-size:20px;" href="Registracija.jsp">Registrujte se</a></center></td>
                    </tr>
                    
                    
                </table>
                
                
            </form>
    
    
    
</div>  
       </center>
       
       
       
       
       
   </div>
    </section>
        
     
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
