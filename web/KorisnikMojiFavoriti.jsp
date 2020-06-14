
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

    
    
<center>
    <section class="portfolio-flyer py-5">
    
        <div style="background-color:#ceeced;" class="container pt-lg-3 pb-md-5" >
           <div class="tab">
            <button class="tablinks" ><a href="KorisnikRezervacije">Rezervacije</a></button>
            <button class="tablinks" ><a href="KorisnikPisiRecenzije.jsp">Pisi recenzije &#x270D;</a></button>
            <button class="tablinks" ><a style="color:red;" href="KorisnikMojiFavoriti">Moji favoriti &#x2764;</a></button>
            <button class="tablinks" ><a href="PorukeKorisnika">Poruke &#x2709;</a></button>
        </div>
             <center> <h1 style="color:darkcyan;">Moji favoriti &#x2764;</h1> </center>
             <% String poruka=(String)request.getAttribute("poruka");
    
    if(poruka!=null){
    %>
    <h3 style="color:red;"><%=poruka%></h3>
    <% } %>
   <div class="row news-grids pb-lg-5 mt-3" style="">
       
        <% ArrayList<Nekretnina> lista=(ArrayList<Nekretnina>)request.getAttribute("prodaja"); 
                         int brojredova=0;
                         
                         if(lista!=null)
                         {
                         
                         for(Nekretnina nek:lista){     
                         brojredova++;
                         %>
       
        <div class="col-lg-4 gal-img">
           
                    <div class="gal-info">              
         
                
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
                                        <span class="fa fa-bed"></span> Soba: <%=nek.getBrojSoba()%>
                                    </li>
                                    <li>
                                        <span class="fa fa-shower"></span> Gradnja: <%=nek.getGodinaIzgradnje()%>
                                    </li>
                                    <li>
                                        <span class="fa fa-building-o"></span> <%=nek.getVelicina()%> m2
                                    </li>
                                    <li>
                                        <span class="fa fa-building-o"></span> Garaza:<%=nek.getGaraza()%>
                                    </li>
                                </ul>
                            </div>
                            <div class="footer-properties" style="color:red; font-size: 17px; font-weight: 500;">
                                <%=nek.getTip()%> 
                          
                              <%     
                            
                             HttpSession ses=request.getSession();    
                             Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                             int korid=kor.getKorisnikID();
                            
                             
                             String omiljeni=Omiljeni.getOmiljeni(nek.getNekretninaId(), korid); 
                             
                              
                            if(omiljeni.equals("ne")){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="DodajUFavorite?nekid=<%=nek.getNekretninaId()%>&tip=FAV"> <span style="color:#edcee2;">&#10084;</span></a>
                             <%   } %>
                             <% if(omiljeni.equals("da")){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="DodajUFavorite?nekid=<%=nek.getNekretninaId()%>&tip=FAV"> <span style="color:red;">&#10084;</span>     </a>
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