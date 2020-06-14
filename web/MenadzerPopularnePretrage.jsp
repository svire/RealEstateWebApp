
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
    <div style="background-color:#ceeced;margin:50px; min-height: 700px;" class="" >
        <%  String poruka=(String)request.getAttribute("poruka");
        if(poruka!=null){%>
        <h1><%=poruka%></h1>
        
        <% } %>
        
        <div class="tab">
            <button class="tablinks" ><a href="MenadzerIstaknuti">Istaknuti oglasi &#x261D;</a></button>
            <button class="tablinks" ><a href="MenadzerPopularnePretrage.jsp">Popularne pretrage &#x26B2;</a></button>
            <button class="tablinks" ><a href="MenadzerNajgledanije.jsp">Najjgledanije nekretnine &#x2686;</a></button>
            <button class="tablinks" ><a href="MenadzerOmiljene.jsp">Omiljene &#x2764;</a></button>
             <button class="tablinks" ><a href="MenadzerPretrazi">Pretrazi nekretnine &#x26B2;</a></button>
        </div>
        
        
        
        <p>3 kveria :
        1.Grad 5 gradova koji su najtipovaniji
        2.AVG CIJENA PO PRETRAGAMA MIN MAX CIJENA
        3.AVG KVADRATURA PO MAX KVADRATA
        </p>
        
    </div>
    
  

</center>
</div>        
 <%@include  file="footer.jsp" %>