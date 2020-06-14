
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="KlijentLista.jsp"%>
<%@include file="banner.jsp"%>

<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; height: 800px;" class="container pt-lg-3 pb-md-5" >
        <h1>KLIJENT POCETNA</h1>
        <% String poruka=(String)request.getAttribute("poruka");
        if(poruka!=null){%>
        <h2><%=poruka%></h2>
        <% } %>
</div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
