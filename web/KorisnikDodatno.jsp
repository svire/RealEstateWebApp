
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="KorisnikLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container">
  
    <%String poruka=(String)request.getAttribute("poruka");
    if(poruka!=null){
        %>
    <h3> <%=poruka%>  </h3>
    <%}%>
   
   
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced;min-height: 600px;" class="container pt-lg-3 pb-md-5" >
            
            
       <div class="tab">
            <button class="tablinks" ><a href="KorisnikRezervacije">Rezervacije</a></button>
            <button class="tablinks" ><a href="KorisnikPisiRecenzije.jsp">Pisi recenzije &#x270D;</a></button>
            <button class="tablinks" ><a style="color:red;" href="KorisnikMojiFavoriti">Moji favoriti &#x2764;</a></button>
            <button class="tablinks" ><a href="PorukeKorisnika">Poruke &#x2709;</a></button>
        </div>
            
            
            
         </div>
    </section>
        
     
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>