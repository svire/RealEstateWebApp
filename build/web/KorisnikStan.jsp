
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@page import="pomocni.*"%>
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="KorisnikLista.jsp"%>
<%@include file="banner.jsp"%>

<div id="container">
    
   
    <form action="PretraziNekretnineS" method="get">
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
    </form>
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced;" class="container pt-lg-3 pb-md-5" >
             <center> <h1 style="color:darkcyan;border: 1px #007bff dotted;">Stan na dan </h1> </center>
              <% String poruka=(String)request.getAttribute("poruka");
    
    if(poruka!=null){
    %>
    <h3 style="color:red;"><%=poruka%></h3>
    <% } %>
   <div class="row news-grids pb-lg-5 mt-3" style="">
        <% ArrayList<Stannadan> lista=(ArrayList<Stannadan>)request.getAttribute("stan"); 
                         int brojredova=0;
                         
                         if(lista!=null)
                         {
                         
                         for(Stannadan nek:lista){     
                         brojredova++;
                         %>
       
        <div class="col-lg-4 gal-img">
           
                    <div class="gal-info">              
          <%   
                               // Profilna pro=new Profilna(); 
                                //String link=pro.profilna(nek.getNekretninaId());
          %>
                
                        <jsp:useBean id="profile" class="pomocni.Profilna1" scope="request"></jsp:useBean>
                        <jsp:setProperty property="id" name="profile" value="<%=nek.getNekretninaId()%>" ></jsp:setProperty>
          
                        <a href="DodatneInfo1?id=<%=nek.getNekretninaId()%>"><img src="Slike/<%=profile.getLink()%>" alt="news image" class="img-fluid"></a>
                        
                        <div class="property-info-list">
                            <div class="detail">
                                <h4 class="title">
                                    <a href="DodatneInfo1?id=<%=nek.getNekretninaId()%>"><b><%=nek.getGrad()%></b></a>
                                </h4>
                                <div class="location mt-2">
                                    <a href="DodatneInfo1?id=<%=nek.getNekretninaId()%>">
                                        <span class="fa fa-map-marker"></span> <b><%=nek.getUlica()%></b>
                                </a>
                                </div>
                                <ul class="facilities-list clearfix">
                                    <li>
                                        <span class="fa fa-bed"></span> Gost(min): <%=nek.getMinGost()%>
                                    </li>
                                    <li> 
                                        <span class="fa fa-shower"></span> Gost(max): <%=nek.getMaxGost()%>
                                    </li>
                                    <li>
                                        <span class="fa fa-building-o"></span> <%=nek.getVelicina()%> m2
                                    </li>
                                    <li>
                                        <span class="fa fa-building-o"></span> Ljubimci:<%=nek.getPets()%>
                                    </li>
                                </ul>
                            </div>
                            <div class="footer-properties" style="color:red; font-size: 17px; font-weight: 500;">
                                
                              <%=nek.getNocenjeCijena()%>$
                              
                              
                          <%     
                            
                             HttpSession ses=request.getSession();    
                             Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                             int korid=kor.getKorisnikID();
                            
                             
                             String omiljeni=Omiljeni.getOmiljeni(nek.getNekretninaId(), korid); 
                             
                              
                            if(omiljeni.equals("ne")){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="DodajUFavorite?nekid=<%=nek.getNekretninaId()%>&tip=DAILY"> <span style="color:#edcee2;">&#10084;</span></a>
                             <%   } %>
                             <% if(omiljeni.equals("da")){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="DodajUFavorite?nekid=<%=nek.getNekretninaId()%>&tip=DAILY"> <span style="color:red;">&#10084;</span>     </a>
                             <% } %>   
                            </div>
                        </div>
                    </div>
                            
                </div>
        <% } %>
        <% }%>
     
       
  </div>
         </div>
    </section>
     
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
