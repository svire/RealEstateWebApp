
<%@page import="pomocni.Slike"%>
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
        
        <h1><b>BRISANJE SLIKA klijent moje nekretnine get prazan</b></h1>
      
        <% String poruka=(String)request.getAttribute("poruka");  
            if(poruka!=null) {%>
        
            <h3 style="color:red;"> <%=poruka%> </h3>
            <% } %>
            <%
                        String nekid="";
                        nekid=request.getParameter("id");
                        int nekidint=Integer.parseInt(nekid);
                        
                      
                        ArrayList<NekretnineSlike> slike=Slike.getSlike(nekidint); 
                        
                        
                        String poruka1="Nema slika za ovu nekretninu...";
                        int brslika=0;
                        %>                
         <form action="ObrisiSliku" method="get">  
         <input type="hidden" name="nekid" value="<%=nekid%>">
         <div  style="background-color: darkcyan; border-radius: 15px; width:100%;height: 120px;margin-top:  40px;">
                     <% for(NekretnineSlike pom:slike){
                         
                         
                         brslika++;
                         %>
                    <div style=" border-radius: 15px; float:left;width:100px;height:100px; background-color: #EBF4cc; margin: 5px;padding:5px; border:2px solid; display:inline-block;" >
                        <div style="height:80%; width:80%;"><img src="Slike/<%=pom.getNaziv()%>" height="80%" width="80%">
                            
                        </div>  
                       
                         <input type="checkbox"  name="brisi" value="<%=pom.getId()%>">
                  
                    </div> 
                        <% }  if(brslika==0){ %>                                                           
                        <br>   <h3 style="color:white; font-size:25px;"><%=poruka1%><a style="color:red;" href="KlijentSamoSlike.jsp?id=<%=nekid%>">Dodaj nove</a></h3>
                      <%  }   %>
                       
                               
             
         </div>    
                        <center><input type="submit" id="hide" value="Obrisi sliku" class="button1 button2 "></center>        
         </form>   
        
</div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
