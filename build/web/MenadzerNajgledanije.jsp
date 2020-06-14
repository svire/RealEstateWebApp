
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

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
           
            <button class="tablinks" ><a href="MenadzerNajgledanije.jsp">Najjgledanije nekretnine &#x2686;</a></button>
            <button class="tablinks" ><a href="MenadzerOmiljene">Omiljene &#x2764;</a></button>
            <button class="tablinks" ><a href="MenadzerPretrazi">Pretrazi nekretnine &#x26B2;</a></button>
        </div>
           
            <%  ResultSet rs32;
                HttpSession ses=request.getSession();    
                Korisnik kor=(Korisnik)ses.getAttribute("korisnik");
                int korid=kor.getKorisnikID();
                %>
                <h2 style="color:darkcyan;margin: 20px;">PRODAJA</h2>
         <table id="tablica" style="background-color: #093145;">
            <tr id="header">
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Cijena</b></td><td><b>Pogledano</b></td><td><b>Istakni</b></td>  
            </tr>
              <%  String query="SELECT nekretnina.nekretnina_id,nekretnina.grad,nekretnina.cijena,mostviewed.broj_posjeta from nekretnina inner join mostviewed on nekretnina.nekretnina_id=mostviewed.nekretnina_id where nekretnina.tip='SALE' order by mostviewed.broj_posjeta DESC limit 5";
                        Konekcija kon=new Konekcija();
                        ResultSet rs,rs1,rs2;
                        rs=kon.query(query);
                        int broj=1;
                        %>
                    
                    <% while(rs.next()){%>
                    
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=broj%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=rs.getString(2)%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=rs.getDouble(3)%>$</a></td>
                <td style="background-color: #c69500;font-size: 23px;"><%=rs.getInt(4)%>x</td>
                <td>
                     <%        
                             String fav="select * from favourites where nekretnina_id='"+rs.getInt(1)+"' and korisnik_id='"+korid+"'";
                             int red=0;                              
                             rs32=kon.query(fav);
                             while(rs32.next())     {     red++;   }                           
                             if(red==0){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=rs.getInt(1)%>&tip=GLEDANO">&#x261F;</a>
                             <%   } %>
                             <% if(red>0){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="IstakniOglas?nekid=<%=rs.getInt(1)%>&tip=GLEDANO">&#x261D;</a>
                             <% } %>     
                    
                </td>
            </tr>
            
            <%  broj++;  } %>
            </table>
            <h2 style="color:darkcyan;margin: 20px;">RENTA</h2>
            <table id="tablica" style="background-color: #093145;">
            <tr id="header">
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Cijena</b></td><td><b>Pogledano</b></td><td><b>Istakni</b></td>  
            </tr>
              <%   
                        String query1="SELECT nekretnina.nekretnina_id,nekretnina.grad,nekretnina.cijena,mostviewed.broj_posjeta from nekretnina inner join mostviewed on nekretnina.nekretnina_id=mostviewed.nekretnina_id where nekretnina.tip='RENT' order by mostviewed.broj_posjeta DESC limit 5";
                        rs1=kon.query(query1);                        
                        int broj1=1;
                        %>
                    
                    <% while(rs1.next()){%>
                    
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs1.getInt(1)%>"><%=broj1%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs1.getInt(1)%>"><%=rs1.getString(2)%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs1.getInt(1)%>"><%=rs1.getDouble(3)%>$</a></td>
                <td style="background-color: #c69500;font-size: 23px;"><%=rs1.getInt(4)%>x</td>
                <td>
                     <%        
                             String fav="select * from favourites where nekretnina_id='"+rs1.getInt(1)+"' and korisnik_id='"+korid+"'";
                             int red=0;                              
                             rs32=kon.query(fav);
                             while(rs32.next())     {     red++;   }                           
                             if(red==0){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs1.getInt(1)%>&tip=GLEDANO">&#x261F;</a>
                             <%   } %>
                             <% if(red>0){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs1.getInt(1)%>&tip=GLEDANO">&#x261D;</a>
                             <% } %>     
                    
                </td>
            </tr>
            
            <%  broj1++;  } %>
            </table>
            
             <h2 style="color:darkcyan;margin: 20px;">STAN NA DAN</h2>
            
             
             <table id="tablica" style="background-color: #093145;">
            <tr id="header">
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Cijena</b></td><td><b>Pogledano</b></td><td><b>Istakni</b></td>  
            </tr>
              <%  String query3="SELECT nekretnina.nekretnina_id,nekretnina.grad,nekretnina.cijena,mostviewed.broj_posjeta from nekretnina inner join mostviewed on nekretnina.nekretnina_id=mostviewed.nekretnina_id where nekretnina.tip='DAILY' order by mostviewed.broj_posjeta DESC limit 5";
                                ResultSet rs3;
                            rs3=kon.query(query3);
                        int broj3=1;
                        %>
                    
                    <% while(rs3.next()){%>
                    
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs3.getInt(1)%>"><%=broj3%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs3.getInt(1)%>"><%=rs3.getString(2)%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs3.getInt(1)%>"><%=rs3.getDouble(3)%>$</a></td>
                <td style="background-color: #c69500;font-size: 23px;"><%=rs3.getInt(4)%>x</td>
                <td>
                     <%        
                             String fav="select * from favourites where nekretnina_id='"+rs3.getInt(1)+"' and korisnik_id='"+korid+"'";
                             int red=0;                              
                             rs32=kon.query(fav);
                             while(rs32.next())     {     red++;   }                           
                             if(red==0){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs3.getInt(1)%>&tip=GLEDANO">&#x261F;</a>
                             <%   } %>
                             <% if(red>0){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs3.getInt(1)%>&tip=GLEDANO">&#x261D;</a>
                             <% } %>     
                    
                </td>
            </tr>
            
            <%  broj3++;  } %>
            </table>
        </div>       
                    
    </section>
        
     
</center>
</div>        
 <%@include  file="footer.jsp" %>