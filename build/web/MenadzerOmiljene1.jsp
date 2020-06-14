 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@page import="pomocni.*"%>
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="MenadzerLista.jsp"%>
<%@include file="banner.jsp"%>




<div id="container" style="overflow: hidden;min-height: 1000px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; min-height: 1000px;" class="" >
        <%  String poruka=(String)request.getAttribute("poruka");
        if(poruka!=null){%>
        <h1><%=poruka%></h1>
        
        <% } %>
        
        <div class="tab">
            <button class="tablinks" ><a href="MenadzerIstaknuti">Istaknuti oglasi &#x261D;</a></button>
          
            <button class="tablinks" ><a href="MenadzerNajgledanije">Najjgledanije nekretnine &#x2686;</a></button>
            <button class="tablinks" ><a href="MenadzerOmiljene">Omiljene &#x2764;</a></button>
             <button class="tablinks" ><a href="MenadzerPretrazi">Pretrazi nekretnine &#x26B2;</a></button>
        </div>
        
        
          
                <h2 style="color:darkcyan;margin: 20px;">PO BROJU LAJKOVA</h2>
         <table id="tablica" style="background-color: #093145;">
            <tr id="header">
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Ulica</b></td><td><b>Tip</b></td><td><b>Lajkovano</b></td>  <td><b>Istakni</b></td> 
            </tr>
              <%   

                ArrayList<Nekretnina> lista=(ArrayList<Nekretnina>)request.getAttribute("omiljene");
                    
                 int broj=1;
                 for(Nekretnina pom:lista){
                 %>
                    
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=broj%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getGrad()%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getUlica()%></a></td> 
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getTip()%></a></td> 
                <td style="background-color: #c69500;font-size: 23px;"><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getGodinaIzgradnje()%>x</a></td>
                  <td>
                     <%    
                             HttpSession ses=request.getSession();    
                             Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                             int korid=kor.getKorisnikID();
                            
                             
                             String omiljeni=Omiljeni.getOmiljeni(pom.getNekretninaId(), korid); 
                             
                              
                            if(omiljeni.equals("ne")){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=pom.getNekretninaId()%>&tip=OMI">&#x261F;</a>
                             <%   } %>
                             <% if(omiljeni.equals("da")){%>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=pom.getNekretninaId()%>&tip=OMI">&#x261D;</a>
                             <% } %>      
                    
                </td>
               
            </tr>
            
            <%  broj++;  } %>
            </table>
        
        
        
        
        
        
        
       </div>
    
  

</center>
</div>        
 <%@include  file="footer.jsp" %>
 