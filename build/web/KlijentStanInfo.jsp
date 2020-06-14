<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         
        <link href="dizajn.css" rel="stylesheet" type="text/css">  
        <link href="bootstrap.css" rel="stylesheet" type="text/css">  
         
       
       
    </head>
    <style>
          <%@ include file="dizajn.css"%>
    </style>
 
<body>
<%@page import="beans.*"%>
<%@page import="pomocni.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@page import="java.text.*"%>
<%@include file="KlijentLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden; min-height: 900px;">
    
     <%
        
        
        int nekid=0;String tip="";String tipnek="";String grad="";
        String ulica="";int velicina=0;String struktura="";Double cijena=0.0;String sprat="";
        int godizg=0;int brojsoba=0;Double daljina=0.0;String garaza="";String lift="";String parking="";
        String terasa="";String podrum="";String kreiran="";int vlasnikid=0;String status="";
    
        //daily
          //daily
         int mingost=0;   int maxgost=0;Double nocenjecijena=0.0; String tv="";
         String klima="";   String vesmasina=""; String internet="";
         String fen="";   String posteljina=""; String pusenje=""; String pets="";
        
        
          Stannadan nek2=(Stannadan)request.getAttribute("daily");
        if(nek2!=null){
             nekid=nek2.getNekretninaId();  
              tip=nek2.getTip();
               tipnek=nek2.getEstateType();
               grad=nek2.getGrad();
               ulica=nek2.getUlica();
              velicina=nek2.getVelicina();
               struktura=nek2.getStruktura();
               cijena=nek2.getCijena();              
               sprat=nek2.getSprat();
              godizg=nek2.getGodinaIzgradnje();
              brojsoba=nek2.getBrojSoba();
               daljina=nek2.getDaljinaOdCentra();
               garaza=nek2.getGaraza();
              lift=nek2.getElevator();
              parking=nek2.getParking();
               terasa=nek2.getTerasa();
               podrum=nek2.getPodrum();
              kreiran=nek2.getKreiran();
              vlasnikid=nek2.getVlasnikId();              
              status=nek2.getStatus();          
                     
                 mingost=nek2.getMinGost();
                 maxgost=nek2.getMaxGost();
                 nocenjecijena=nek2.getNocenjeCijena();
                 klima=nek2.getKlima();
                 vesmasina=nek2.getVesMasina();
                 internet=nek2.getInternet();
                 fen=nek2.getFen();
                 posteljina=nek2.getPosteljina();
                 pusenje=nek2.getPusenjeDozv();
                 pets=nek2.getPets();
                 tv=nek2.getTv();
                 
                
        }
            
     %>
 
    <center> <div style="background-color:#ceeced; min-height: 1400px;oveflow:hidden;width: 1200px;margin: 50px;" class="container pt-lg-3 pb-md-5" >
           
            <div style="height: 180px;">
                <div style="height:100%;width:30%;background-color: darkorange;float:left;padding:20px;border-radius: 25px;">
                    
                 <h2 style="float:left;"><b>Apartman:<%=nekid%>|<span style="color:red;font-size: 22px;"><%=nocenjecijena%>€</span></b></h3> <br><br>
                 <h4 style="float:left;"><b><%=grad%>,<%=ulica%> <span style="color:#007bff;font-size:14px;">ulica</span></b></h4><br><br><br>
                
                </div>
              <div style="height:100%;width:25%;background-color:darkslateblue; border-radius: 25px;float:right;">
                     <center>
           <%              
           
            String[] rez=Prosjecna.getProsjecna(nekid);
            
  
 %>
                        <h3>Prosjecna ocjena</h3>
                        <a href="Recenzije?id=<%=nekid%>">
                            <div style="background-color: darkorange;width: 100px;height: 90px;border-radius: 30px 30px 30px 0;">
                            <span style="color:white;font-size: 50px;">
                           <%=rez[0]%>
                            </span>                            
                        </div>
                        </a>
                        <br>
                         <h3>Na osnovu: <%=rez[1]%> recenzija</h3>
                    </center>
                    
                </div>
               
            </div>
             <div id="red_dodatno">
                  <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola">
                             Struktura:
                         </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=struktura%>
                         </div>
                        
                     </div>
                     <div id="red_mali">
                         <div id="red_pola" >
                             Tip:
                         </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=tip%>
                         </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                             Tip nekretnine:
                         </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=tipnek%>
                         </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Kvadratura:
                         </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=velicina%>
                         </div>
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Izgradnja(god.)
                         </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=godizg%>
                         </div>
                     </div> 
                     
                    
                 </div>
                 <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola" >
                             Daljina od centra:
                         </div>
                          <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=daljina%>
                         </div>
                        
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Broj soba:
                         </div>
                          <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=brojsoba%>
                         </div>
                        
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Sprat:
                         </div>
                          <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=sprat%>
                         </div>
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Cijena:
                         </div>
                          <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=cijena%>
                         </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                             Lift:
                         </div>
                          <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=lift%>
                         </div>
                     </div> 
                    
                 </div>
                  <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola" >
                             Garaza:
                         </div>
                         <div id="red_pola" >
                             <%=garaza%>
                         </div>
                     </div>
                     
                                         
                     <div id="red_mali">
                         <div id="red_pola">
                             Parking:
                         </div>
                          <div id="red_pola" >
                             <%=parking%>
                         </div>
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                            Terasa:
                         </div>
                         <div id="red_pola" >
                             <%=terasa%>
                         </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                            Kreiran:
                         </div>
                         <div id="red_pola" style="font-size:16px;" >
                             <%=kreiran%>
                         </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                            -:
                         </div>
                          <div id="red_pola">
                            -:
                         </div>
                        
                        
                   
                     </div>   
                    
                 </div>
                         
                    
               
                 
                 
            </div>
              
             <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Cijena nocenja:
                       </div>
                        <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=nocenjecijena%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Min. gostiju:
                       </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=mingost%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Max. gostiju:
                       </div>
                           <div id="red_pola">
                             <%=maxgost%>
                         </div>
                   </div>                   
               </div>   
                           
                <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Klima:
                       </div>
                        <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=klima%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                          Ves masina:
                       </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=vesmasina%>
                         </div>
                   </div> 
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Internet:
                       </div> 
                          <div id="red_pola">
                             <%=internet%>
                         </div>
                              
                          
                   </div>      
                    
                </div>
                <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                          TV:
                       </div>
                         <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=tv%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                          Fen:
                       </div>
                       <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=fen%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Posteljina:
                       </div>
                           <div id="red_pola">
                             <%=posteljina%>
                         </div>
                   </div>
                </div>
                <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                          Pusenje:
                       </div>
                        <div id="red_pola" style="border-right: 3px solid darkcyan;">
                             <%=pusenje%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                          Ljubimci:
                       </div>
                        <div id="red_pola" style="border-right: 3px solid darkcyan;" >
                             <%=pets%>
                         </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           -:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="input" size="4" readonly>
                              
                              
                          </div>
                   </div>   
               </div>  
                         
              <div id="red_dodatno">
                 <% 
                        Connection kon=null;
                        Statement stmt=null;
                        ResultSet rs=null;
                        int count=0;                        
                        String[] linkovi=new String[10];
                        int lin=0;
                        
                        String slike="select * from nekretnine_slike where nekretnina_id='"+nekid+"'";
                        try{
                            kon=Konekcija2.getConnection();
                            stmt=kon.createStatement(); 
                            rs=stmt.executeQuery(slike);
                            while (rs.next()) {
                            count++;
                            linkovi[lin]=rs.getString(3);
                            lin++;
                            }
                         }
                        catch(SQLException ex){                            
                            
                            
                        }
                        finally{
                             if(kon!=null) { try{ kon.close(); } catch(SQLException ex){}   }
                             if(stmt!=null) { try{ stmt.close(); } catch(SQLException ex){}   }
                             if(rs!=null) { try{ rs.close(); } catch(SQLException ex){}  }
                        }
                        
                        
                       String[] niz={"i1","i2","i3","i4","i5","i6","i7","i8","i9","i10"};
                       String[] dotovi={"dot1","dot2","dot3","dot4","dot5","dot6","dot7","dot8","dot9","dot10"};
                       String[] numbers={"one","two","three","four","five","six","seven","eight","nine","ten"};
                        %> 
                        <%if(count==0){
                            %>
                            <div style='float:right;'> <h3 style='color:darkred;'>Nema slika za nekretninu</h2>      </div>
                        <%  }%>    
                
                
                
                
                
             <div id="contslike" style="margin:40px;">
               <%
                  for(int r=0;r<lin;r++){   %>                      
                    <input type="radio" name="images" id="<%=niz[r]%>">                        
                     <% }%>
            
            <% 
                
                for(int i=0;i<lin;i++){   %>
                            
            <div class="slider_img" id="<%=numbers[i]%>">
                
                <img src="Slike/<%=linkovi[i]%>">
                
                 <% if(i==0){ %>
                <label for="<%=niz[lin-1]%>"  class="pre"></label>
                <label for="<%=niz[i+1]%>"  class="nxt"></label>
                <% } if(i!=0){ %>
                   <label for="<%=niz[i-1]%>"  class="pre"></label>
                    <label for="<%=niz[i+1]%>"  class="nxt"></label>
                <% }%>
                
            </div>
           <% } %>
            
              <div class="navi">                
               <% for(int d=0;d<lin;d++){    %>
                     <label class="dots" id="<%=dotovi[d]%>" for="<%=niz[d]%>"></label>    
                 <% }%>
            </div> 
             </div>
                
                
            </div>   
            
            <div id="red_dodatno">       
                <div style="height: 12%;width: 100%;background-color: #004085;">
                    <div style="height: 100%;width:20%;float:left;">
                        <h3>Dodatne informacije:</h3>
                    </div>                      
                </div>
                  <% String opis="";  opis=Opis.getOpis(nekid);
                   String opomena="Trenutno nema dodatnog opisa.";%>
                                     
                
                <div style="height: 40%;width:100%;float:left;background-color:khaki;font-size:19px;">
               
                      <p>
                       <% if(opis.equals("")){ %>
                       <%=opomena%>
                       <% } else{ %>
                       <%=opis%>
                       <% } %>
                    </p>   
                      
                      
                        
                   
                             
                </div> 
                 <div style="height: 12%;width: 100%;background-color: darkred;">
                    <div style="height: 100%;width:20%;float:left; background-color: green;">
                        <h3>Recenzije:</h3>
                    </div>                      
                </div>      
            </div>  
                 
                         
           
    </center>

</div>        
 <%@include  file="footer.jsp" %>