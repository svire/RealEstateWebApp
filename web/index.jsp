


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="PosjetilacLista.jsp"%>
<%@include file="banner.jsp"%>

<div id="container">
    <div id="pretraga">
        <div id="red" style="margin-right: 5px;" >
            
            <h6>Grad:</h6>
            <input type="text" name="grad" placeholder="Grad" size="12">
        </div>
        <div id="red">
            
            <h6>Cijena(min):</h6>
            <input type="text" name="cijenamin" placeholder="Minimalna cijena" size="12">
        </div>
        <div id="red">
            
            <h6>Cijena(max):</h6>
            <input type="text" name="cijenamax" placeholder="Maxmalna cijena" size="12">
        </div>
        <div id="red">
            
            <h6>Min velicina:</h6>
            <input type="text" name="kvadraturamin" placeholder="Min. kvadrata" size="12" >
        </div>
        <div id="red">
            
            <h6>Max velicina:</h6>
            <input type="text" name="kvadraturamax" placeholder="Max. kvadrata" size="12">
        </div>
        <div id="red">
            
            <button class="button button2">Pronadji</button>
            
        </div>
    </div>
    
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced;" class="container pt-lg-3 pb-md-5" >
  
        </div>
    </section>
        
     
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>