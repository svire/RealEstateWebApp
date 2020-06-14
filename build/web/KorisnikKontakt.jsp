
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
        <div style="background-color:#ceeced;min-height: 800px;" class="container pt-lg-3 pb-md-5" >
            <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Kontakt</h1> </center>
            
            <p style="font-size:20px;">Adresa:Kralja Petra I Karadjordjevica 85.</p>
            <p style="font-size:20px;">Telefon:051-933-393</p>
            <p style="font-size:20px;">Email:nekretninezavrsni@gmail.com</p>
           

            <p style="margin:50px;"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d842.1391534263636!2d17.187563851657355!3d44.76842541827212!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475e0318d76d4b0f%3A0xe3735bbf2427d0d6!2sKralja+Petra+I+Kara%C4%91or%C4%91evi%C4%87a+85%2C+Banja+Luka+78000%2C+Bosnia+and+Herzegovina!5e0!3m2!1sen!2srs!4v1550849280180" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe></p>
  
        
        
         </div>
    </section>        
</center>
</div>        
 <%@include  file="footer.jsp" %>