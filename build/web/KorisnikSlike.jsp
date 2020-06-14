
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
        <div style="background-color:#ceeced;min-height: 1600px;" class="container pt-lg-3 pb-md-5" >
            <h1 style="color:darkcyan;">Slike</h1>
            <div style="width: 1000px;min-height: 1600px;margin-top: 50px;">
                
                <%
                    
                    ArrayList<NekretnineSlike> slike=(ArrayList<NekretnineSlike>)request.getAttribute("slibe");
                     
                    for(NekretnineSlike pom:slike){
                %>
                <div id="expand">
                    <img style="height: 100%;width: 100%;" src="Slike/<%=pom.getNaziv()%>">
                </div>
                <%  } %>
                <%if(slike.isEmpty()){%>
                <h2 style="color:red;">Ne postoje slike za ovu nekretninu!</h2>
                <% } %>
            </div>
  
        
        
         </div>
    </section>        
</center>
</div>        
 <%@include  file="footer.jsp" %>