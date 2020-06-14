
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="pomocni.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="KlijentLista.jsp"%>
<%@include file="banner.jsp"%>


<div id="container" style="overflow: hidden; min-height: 900px;">
     <%
        Nekretnina nek=(Nekretnina)request.getAttribute("nekretnina");
        
        int nekid=0;String tip="";String tipnek="";String grad="";
        String ulica="";int velicina=0;String struktura="";Double cijena=0.0;String sprat="";
        int godizg=0;int brojsoba=0;Double daljina=0.0;String garaza="";String lift="";String parking="";
        String terasa="";String podrum="";String kreiran="";int vlasnikid=0;String status="";
    
         if(nek!=null){
               nekid=nek.getNekretninaId();  
              tip=nek.getTip();
               tipnek=nek.getEstateType();
               grad=nek.getGrad();
               ulica=nek.getUlica();
              velicina=nek.getVelicina();
               struktura=nek.getStruktura();
               cijena=nek.getCijena();              
               sprat=nek.getSprat();
              godizg=nek.getGodinaIzgradnje();
              brojsoba=nek.getBrojSoba();
               daljina=nek.getDaljinaOdCentra();
               garaza=nek.getGaraza();
              lift=nek.getElevator();
              parking=nek.getParking();
               terasa=nek.getTerasa();
               podrum=nek.getPodrum();
              kreiran=nek.getKreiran();
              vlasnikid=nek.getVlasnikId();              
              status=nek.getStatus();            
        }

            
     %>
    
    
    
    <center> <div style="background-color:#ceeced; min-height: 1000px;oveflow:hidden;width: 1200px;margin: 50px;" class="container pt-lg-3 pb-md-5" >
           
            <div style="height: 150px;">
                <div style="height:100%;width:30%;background-color: darkorange;float:left;padding:20px;border-radius: 25px;">
                    
                 <h2 style="float:left;"><b>Apartman:<%=nekid%>|<span style="color:red;font-size: 22px;"><%=cijena%>€</span></b></h3> <br><br>
                 <h4 style="float:left;"><b><%=grad%>,<%=ulica%> <span style="color:#00c389;font-size:14px;">ulica</span></b></h4><br><br><br>
                
                </div>
               <div style="height:20%;width:25%;background-color:#093145;float:right;">
                     
                     <% int broj=0;  broj=Pogledan.getPogledan(nekid); %>
                       <h3><b>Ovaj oglas je vidjen: <%=broj%>x</b></h3>
                         
          
                    
                </div>
                <br><br>
                
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
            
    </div>
    </center>

</div>        
 <%@include  file="footer.jsp" %>