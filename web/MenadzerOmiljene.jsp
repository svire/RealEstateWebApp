
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

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
                 <td><b>Rang</b></td><td><b>Grad</b></td><td><b>Ulica</b></td><td><b>Lajkovano</b></td><td><b>Istakni</b></td>  
            </tr>
              <%  String query="select nek.nekretnina_id,nek.grad,nek.ulica,COUNT(fav.nekretnina_id) from nekretnina nek INNER join favourites fav on fav.nekretnina_id=nek.nekretnina_id GROUP by (fav.nekretnina_id) ORDER by count(nek.nekretnina_id) desc limit 10";
                        Konekcija kon=new Konekcija();
                        ResultSet rs,rs1,rs2;
                        rs=kon.query(query);
                        int broj=1;
                        %>
                    
                    <% while(rs.next()){%>
                    
            <tr>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=broj%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=rs.getString(2)%></a></td>
                <td><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=rs.getString(3)%></a></td>
                <td style="background-color: #c69500;font-size: 23px;"><a style="color: white;" href="DodatneInfo1?id=<%=rs.getInt(1)%>"><%=rs.getInt(4)%>x</a></td>
              
                <td>
                     <%        
                             String fav="select * from favourites where nekretnina_id='"+rs.getInt(1)+"' and korisnik_id='"+korid+"'";
                             int red=0;                              
                             rs32=kon.query(fav);
                             while(rs32.next())     {     red++;   }                           
                             if(red==0){   %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs.getInt(1)%>&tip=GLEDANO">&#x261F;</a>
                             <%   } %>
                             <% if(red>0){ %>
                             <a style="font-size:30px;text-decoration: none;float:right;" href="MenadzerFavourites?nekid=<%=rs.getInt(1)%>&tip=GLEDANO">&#x261D;</a>
                             <% } %>     
                    
                </td>
            </tr>
            
            <%  broj++;  } %>
            </table>
        
        
        
        
        
        
        
       </div>
    
  

</center>
</div>        
 <%@include  file="footer.jsp" %>
 