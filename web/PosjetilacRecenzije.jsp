
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="java.text.*"%>
<%@include file="PosjetilacLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden; min-height: 900px;">
    
    <center> <div style="background-color:#ceeced; min-height: 1200px;oveflow:hidden;width: 1200px;margin: 50px;padding-top:0px;" class="container pt-lg-3 pb-md-5" >
                  <%              
           String nekid=request.getParameter("id");
           int nekidint=Integer.parseInt(nekid);
            Konekcija kon=new Konekcija();                        
            ResultSet rs7;
           
            int brojev=0;
            int suma=0;
            String prosjecna="select recenzije.ocjena from recenzije where nekretnina_id='"+nekid+"'";
            rs7=kon.query(prosjecna);
            while(rs7.next()){
               suma+=rs7.getInt(1);
               brojev++;
                }
             Double ocjena=0.0;   
             if(brojev!=0){
            Double fsuma=Double.parseDouble(String.valueOf(suma));
            Double fcount=Double.parseDouble(String.valueOf(brojev));
            ocjena=fsuma/fcount;
                 }
  
 %>
            
            <div style="height: 100%;width:25%;float:left;margin: 0 auto">
                <div style="background-color: darkmagenta;height: 30%;width:100%; border-radius: 25px; color:white;">
                    <center>
                        <br>
                        <h2>Prosjecna ocjena</h2>
                           <div style="background-color: darkorange;width: 100px;height: 90px;border-radius: 30px 30px 30px 0;">
                            <span style="color:white;font-size: 50px;">
                               <%
                DecimalFormat dec = new DecimalFormat("#0.0");
                
            %>
            
            <%=dec.format(ocjena)%>
                            </span>                            
                        </div>
                        <br>
                               <h3>Na osnovu: <%=brojev%> recenzija</h3>
                    </center>
                </div>
            </div>
            <%
                ResultSet rs;
                String qvery="SELECT * from recenzije where nekretnina_id='"+nekidint+"'";            
                rs=kon.query(qvery); 
                
                %>
           
            <div style="width:73%;min-height: 850px;float:right;">
       
                <center>
                    <h1><b>Recenzije</b></h1>
                     <% String poruka="Nema recenzija za ovaj stan.";
                     if(brojev==0){
                     %>
                    <h1><%=poruka%></h1>     
                     <%   } %>
        
                       <%
                        while(rs.next()){               
         
                          %>
                    
                    <div style="background-color: white;width: 500px;height: 300px;margin:25px;border-radius: 25px;">
                        <div style="padding:5px;width:100%;height: 10%;background-color: darkorange;border-radius: 25px 25px 0 0;font-size:20px;">
                            <p> Korisnik:<%=rs.getInt(3)%> </p>
                        </div>
                        <div style="padding-top:5px;width:100%;height: 10%;background-color: darkgoldenrod;font-size:20px;">
                            <div style='background-color: white;height: 100%;width:50%;float:left;'>
                               Naslov:<%=rs.getString(4)%>
                            </div>
                            <div style='background-color: white;height: 100%;width:50%;float:left;'>
                               Ocjena:<%=rs.getInt(5)%>
                            </div>
                           
                        </div>
                        <div style="width:100%;height: 35%;background-color: #53ff1a;font-size:20px;">
                            <div style='width:10%;height: 100%;float:left;'>
                                <img src='Slike/plus2020.jpg'>
                            </div>
                            <div style='width: 90%;min-height: 100%;font-size:16px;'>
                                    <%=rs.getString(6)%>
                            </div>
                            
                        </div>
                         <div style="width:100%;height: 35%;background-color: #ff471a;font-size:20px;">
                            <div style='width:10%;height: 100%;float:left;'>
                                <img src='Slike/minus2020.png'>
                            </div>
                             <div style='width: 90%;min-height: 100%;color:white;font-size:16px;'>
                                    <%=rs.getString(7)%>
                             </div>
                        </div>
                        <div style="padding:5px;width:100%;height: 10%;color:white;background-color: darkorange;border-radius: 0 0 25px 25px;font-size:20px;">
                            <p> Datum:<%=rs.getString(8)%> </p>
                        </div>
                        
                    </div>
                        <%}%>
                      
                 
                </center>
                
                
            </div>
              
          
    </div>
    </center>

</div>        
 <%@include  file="footer.jsp" %>
