
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
        
        <h1><b>DODAJ SLIKE</b></h1>
         <%
             String poruka=(String)request.getAttribute("poruka");
             if(poruka!=null){             
             %>
             <h3 style="color:darkred;"><%=poruka%></h3>
             
             <% } %>
        
        
           
          <%
              ArrayList<String> slibe=new ArrayList<String>();
         HttpSession s=request.getSession();
         if((ArrayList<String>)s.getAttribute("nizslika")!=null){
             slibe=(ArrayList<String>)s.getAttribute("nizslika");
         }
           
            if(slibe!=null){ %>
                <h3 style="color:red;"><%=slibe%></h3>
            
            <%
            }           %>
            
            
         
        
        <div class="tab" style="margin:35px;">
            <button class="tablinks"><a href="KlijentNoveNekretnine.jsp">Prodaja</a></button>
            <button class="tablinks"><a href="KlijentNoveNekretnineRenta.jsp">Renta</a></button>
            <button class="tablinks"><a href="KlijentNoveNekretnineStan.jsp">Stan na dan</a></button>
            <button class="tablinks"><a href="KlijentDodajSlike.jsp">Dodaj slike</a></button>
        </div>
           <%     if(slibe.size()==0){
                %>
                
                <h2 style="color:darkred;">Niste dodali slike jos!</h2>
               <% }  %>
           
           <center> <div style="color:red;font-size:25px;" id="greska1"></div></center>
           
           
          
           
           <div style="height: 100px;width: 100%;background-color: #f1f1f1;margin:10px;">
               <%     if(slibe.size()>0){
                        for(int i=0;i<slibe.size();i++){
               %>
               <div style="margin:10px;height: 80px;;width: 80px;background-color: darkgoldenrod;float:left;">
                   
                   
                   <img src="Slike/<%=slibe.get(i)%>" style="height: 100%;width: 100%;">
                   <a href="FileUploadServlet2?id=<%=i%>">X<%=i%></a>
               </div>
                <% } %>
              
           </div>
           <% }%>
            
            
           
            <form action="FileUploadServlet2" method="POST" name="file" enctype="multipart/form-data" >
            <table id='tablica'>
                <tr id='header'>
                    <td>File:</td>
                    <td>Destination:</td>
                   
                </tr>
                <tr>
                     <td><input type="file" name="file" id="file" placeholder="jpg/png/gif"></td>
                    <td><input type="text" readonly value="C:\Users\Djole\Documents\NetBeansProjects\ZavrsniRad9a\web\Slike" name="destination"></td>
                </tr>                                   
                <tr>
                    <td colspan='2'><input type="submit" name="submit"></td>
                </tr>
            </table>
            
        </form>
        

 
        
</div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
