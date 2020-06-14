
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="pomocni.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="javax.servlet.*"%>
<%@include file="AdminLista.jsp"%>
<%@include file="banner.jsp"%>



<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; min-height: 750px;" class="container pt-lg-3 pb-md-5" >
         <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Poruka</h1> </center>
          <% 
         String poruka=(String)request.getAttribute("poruka");         
         if(poruka!=null)
         {      
        %>
        <h3 style="color:red;"><%=poruka%></h3>        
        <% }%>
        
     
        <% Poruka por=(Poruka)request.getAttribute("citaj");
           
        %>
            
        
        <div style="height: 200px;width: 400px;background-color: #008CBA;">
            <div style="height:20%;width:100%;background-color: darkcyan;font-size: 22px; color:white;">Tema:<%=por.getTema()%></div>
            <div style="height:20%;width:100%;background-color: darkcyan;font-size: 22px; color:white;">
                <div style="height:100%;width:50%;background-color: darkcyan;;float:left;font-size: 22px; color:white;">
                    Od:<%=Username.getUsername(por.getOdId())%>
                </div>
                <div style="height:100%;width:50%;background-color: darkcyan;float:left;">
                    Vrijeme:<%=por.getVrijeme()%>
                </div>
            </div>
              <div style="height:70%;width:100%;background-color: #00c389;float:left;">
                    <textarea readonly style="width: 100%;height: 100%;"><%=por.getSadrzaj()%></textarea>
                </div>
                    
            </div>
            
                <form action="PosaljiPoruku" method="post">
                    <input type="hidden" name="za" value="<%=por.getOdId()%>">
                <div style="height: 150px;width: 400px;background-color: #008CBA; margin-top: 100px;">
                    <div style="height:20%;width:100%;background-color: darkcyan;font-size: 22px; color:white;">
                        Tema:
                        <select name="tema">
                            <option value="pitanje">Pitanje</option>
                            <option value="reklamacija">Reklamacija</option>
                            <option value="drugo">Drugo</option> 
                        </select> 
                    
                    </div>
                    <div style="height:80%;width:100%;background-color: #00c389;float:left;">
                    <textarea name="sadrzaj" style="width: 100%;height: 100%;">Unesite poruku:</textarea>
                </div>
                </div>  
                <input type="submit" value="Odgovori"></center>
                </form>
                
                
                
        </div>
      
    
</div>
        
        
        
        
        
        
        
        
    </div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>