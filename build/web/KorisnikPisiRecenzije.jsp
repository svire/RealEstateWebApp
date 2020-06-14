<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <link href="dizajn.css" rel="stylesheet" type="text/css">  
        <link href="bootstrap.css" rel="stylesheet" type="text/css">  
        
    </head>
    <style>
          <%@ include file="dizajn.css"%>
    </style> 
        <script>
          
        
       function provjeri(){
             var tip=document.getElementById('id').value;             
            
            
            switch(tip){
                case "":             
                    document.getElementById("formica").style.visibility="hidden";
                    break;
               
                default:
                    
                    break;
            }
              
               
            }   
        </script>
        
        
    </head>      
</html>
<body onload="provjeri()">
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="javax.servlet.*"%>
<%@include file="KorisnikLista.jsp"%>
<%@include file="banner.jsp"%>




<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
         <form action="PisiRecenziju" method="post" id="formica">
    <div style="background-color:#ceeced;margin:50px; height: 700px;" class="container pt-lg-3 pb-md-5" >
       
        <div class="tab">
            <button class="tablinks" ><a href="KorisnikRezervacije">Rezervacije</a></button>
            <button class="tablinks" ><a href="KorisnikPisiRecenzije.jsp">Pisi recenzije &#x270D;</a></button>
            <button class="tablinks" ><a style="color:red;" href="KorisnikMojiFavoriti">Moji favoriti &#x2764;</a></button>
            <button class="tablinks" ><a href="PorukeKorisnika">Poruke &#x2709;</a></button>
        </div>
        <center> <h1 style="color:darkcyan;">Pisi recenzije</h1> </center>
        <% String porukica=(String)request.getAttribute("poruka");
        if(porukica!=null)
        {
        %>
        <h3 style="color:darkred;"><%=porukica%></h3>
        <% } %>
         <% 
        HttpSession ses=request.getSession();
        Korisnik kor=new Korisnik();
        kor=(Korisnik)ses.getAttribute("korisnik");
        int zaid=kor.getKorisnikID();
            
        Konekcija kon=new Konekcija(); 
        ResultSet rs;
        
        String query="select rezervacije.nekretnina_id from rezervacije where rezervacije.korisnik_id='"+zaid+"'";
        rs=kon.query(query);
        
        
        %>
        
       
        <div style="width: 40%;height: 50%;background-color: darkorange; margin-top: 25px; border-radius: 25px;">
            
            <div style="border-radius: 25px 25px 0 0;width: 100%;height: 12%;background-color: darkcyan; padding:5px;font-size: 19px;">
                <i> Nekretnina:</i>  
                <select name="id" id="id">
                     <% while(rs.next()){
                            
                        %>
                    <option value="<%=rs.getInt(1)%>"><%=rs.getInt(1)%></option>
                        <% } %>
                </select>
            </div>    
       
            <div style="width: 100%;height: 12%;background-color: darkcyan;padding: 5px;">
                <div style="width: 50%;height: 100%;float:left;font-size:19px;">
                    <i> Ocjena:</i>    
                    <select name="ocjena">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select> 
                </div>
                <div style="width: 50%;height: 100%;float:left;font-size: 14px;">
                     <input type="text" name="naslov" placeholder="Naslov" size="15">  
                </div>  
               
            </div>   
            <div style="height: 31%;width: 100%;background-color: #34ce57;">
                <div style="width:7%;height: 31%;background-color: yellow;float:left;">
                    <img src="Slike/plus2020.jpg">
                </div>
                <div style="width:93%;height: 100%;background-color: white;float:left;">
                    <textarea name="pozitivno" style="background-color: #34ce57; box-sizing:border-box;height: 100%;width:100%;">
                        
                    </textarea>
                </div>
            </div>
            <div style="height: 31%;width: 100%;background-color: #dd4b39;">
                 <div style="width:7%;height: 30%;background-color: yellow;float:left;">
                    <img src="Slike/minus2020.png">
                </div>
                 <div style="width:93%;height: 100%;background-color: white;float:left;">
                    <textarea style="box-sizing:border-box;height: 100%;width:100%;background-color: #dd4b39;" name="negativno" >
                        
                    </textarea>
                </div>
                
            </div> 
            <div style="height: 14%;width: 100%;background-color: darkcyan;border-radius: 0 0 25px 25px;padding:10px;">
                <center>
                    <input type="submit" value="Posalji"style="margin-right: 10px;"><input type="reset">
                </center>
                
            </div>
                
                
        </div>
            
            
            
        </div>
            
        
        
        </center>
                        </form>
    </div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
 