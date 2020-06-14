
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
             
              String nekid="";
              nekid=request.getParameter("id");
              
              ArrayList<String> slibe=new ArrayList<String>();
             HttpSession s=request.getSession();
         
                 
         if((ArrayList<String>)s.getAttribute("nizslika")!=null){
             slibe=(ArrayList<String>)s.getAttribute("nizslika");
         }
           
                %>
                    
        
           <%     if(slibe.size()==0){
                %>
                
                <h2 style="color:darkred;">Niste dodali slike jos!</h2>
               <% }  %>
           
           <center> <div style="color:red;font-size:25px;" id="greska1"></div></center>
           
           
          
           <h1 style="color:blue;"><%=nekid%></h1>
            <form action="FileUploadServlet3" method="POST" name="file" enctype="multipart/form-data" >
                <input type="hidden" name="nekid" value="<%=nekid%>">
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
                    <td colspan='2'><input type="submit" value="Dodaj sliku"></td>
                </tr>
            </table>
            
        </form>
                  
           
           <div  style="background-color: darkcyan; border-radius: 15px; width:100%;height: 120px;margin-top:  40px;">
            <%     if(slibe.size()>0){
                        for(int i=0;i<slibe.size();i++){
               %>
               <div style=" border-radius: 15px; float:left;width:100px;height:100px; background-color: #EBF4cc; margin: 5px;padding:5px; border:2px solid; display:inline-block;" >
                   <div style="height:80%; width:80%;"><img src="Slike/<%=slibe.get(i)%>" style="height: 100%;width: 100%;">
                       <a href="FileUploadServlet3?id=<%=i%>">X<%=i%></a>     
                        </div>  
                        
               </div>
               <% }%>
</div>
         <% } %>  
            <form action="DodajSliku" method="post">
               <div style="width:100%;height: 50px;margin-top:10px;"> 
               <input type="hidden" name="id" value="<%=nekid%>">
               <input type="submit" class="button1 button2" value="Potvrdi">
               </div>
           </form> 
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
