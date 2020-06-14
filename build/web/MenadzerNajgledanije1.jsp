
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@page import="pomocni.*"%>
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="MenadzerLista.jsp"%>
<%@include file="banner.jsp"%>

<div id="container">
   
    
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced;min-height: 1200px;" class="container pt-lg-3 pb-md-5" >
        <div class="tab">
            <button class="tablinks" ><a href="MenadzerIstaknuti">Istaknuti oglasi &#x261D;</a></button>
             
            <button class="tablinks" ><a href="MenadzerNajgledanije">Najjgledanije nekretnine &#x2686;</a></button>
            <button class="tablinks" ><a href="MenadzerOmiljene">Omiljene &#x2764;</a></button>
            <button class="tablinks" ><a href="MenadzerPretrazi">Pretrazi nekretnine &#x26B2;</a></button>
        </div>
           
            <%  ResultSet rs32;
                              
                
                %>
                <h2 style="color:darkcyan;margin: 20px;">NAJGLEDANIJE NEKRETNINE</h2>
         <table id="tablica" style="background-color: #093145;">
            <tr id="header">
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Cijena</b></td><td><b>Tip</b></td><td><b>Pogledano</b></td>  </td><td><b>X</b></td>  
            </tr>
              <%   

                    ArrayList<Nekretnina> nekretnine=(ArrayList<Nekretnina>)request.getAttribute("najgledanije");
                    
                    int broj=1;
                        %>
                    
                    <% for(Nekretnina pom:nekretnine){
                   %>
                 
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=broj%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getGrad()%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getCijena()%>$</a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=pom.getNekretninaId()%>"><%=pom.getTip()%></a></td>
                <td style="background-color: #c69500;font-size: 23px;"><%=pom.getGodinaIzgradnje()%>x</td>
                <td>
                     <%    
                             HttpSession ses=request.getSession();    
                             Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                             int korid=kor.getKorisnikID();
                            
                             
                             String omiljeni=Omiljeni.getOmiljeni(pom.getNekretninaId(), korid); 
                             
                              
                            if(omiljeni.equals("ne")){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=pom.getNekretninaId()%>&tip=NAJ">&#x261F;</a>
                             <%   } %>
                             <% if(omiljeni.equals("da")){%>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=pom.getNekretninaId()%>&tip=NAJ">&#x261D;</a>
                             <% } %>      
                    
                </td>
            </tr>
            
            <%  broj++;  } %>
            </table>
            
            
            
          
            
           
        </div>       
                    
    </section>
        
     
</center>
</div>        
 <%@include  file="footer.jsp" %>