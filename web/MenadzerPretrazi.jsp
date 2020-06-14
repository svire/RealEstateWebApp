
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
    
  
    <form action="MenadzerPretrazi" method="get">
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
            <div class="tab">
            <button class="tablinks" ><a href="MenadzerIstaknuti">Istaknuti oglasi &#x261D;</a></button>
           
            <button class="tablinks" ><a href="MenadzerNajgledanije">Najjgledanije nekretnine &#x2686;</a></button>
            <button class="tablinks" ><a href="MenadzerOmiljene">Omiljene &#x2764;</a></button> 
             <button class="tablinks" ><a href="MenadzerPretrazi">Pretrazi nekretnine &#x26B2;</a></button>
        </div>
             <center> <h1 style="color:darkcyan;">Menadzer pretrazi</h1> </center>
               <% String poruka=(String)request.getAttribute("poruka");
    
    if(poruka!=null){
    %>
    <h3 style="color:black;"><%=poruka%></h3>
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
                                   Konekcija kon=new Konekcija();
                             ResultSet rs32;
                             HttpSession ses=request.getSession();    
                             Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                             int korid=kor.getKorisnikID();
                             String fav="select * from favourites where nekretnina_id='"+nek.getNekretninaId()+"' and korisnik_id='"+korid+"'";
                             int red=0;                              
                             rs32=kon.query(fav);
                             while(rs32.next())     {     red++;   }                            
                            
                              if(red==0){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=nek.getNekretninaId()%>&tip=PRE">&#x261F;</a>
                             <%   } %>
                             <% if(red>0){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=nek.getNekretninaId()%>&tip=PRE">&#x261D;</a>
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