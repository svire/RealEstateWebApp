
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@page import="pomocni.*"%>
<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="MenadzerLista.jsp"%>
<%@include file="banner.jsp"%>

<script>
     function validacija()
        {
            
            greska=document.getElementById("greska1");
            godina=document.getElementById("godinaizgradnje").value;
            grad=document.getElementById("grad").value;
            ulica=document.getElementById("ulica").value;
            cijena=document.getElementById("cijena1").value;         
            kvadratura=document.getElementById("kvadratura").value;    
            sprat=document.getElementById("sprat").value;
            brojsoba=document.getElementById("brojsoba").value;
            
            daljina=document.getElementById("daljina").value;
            
            testpassword=/^[a-zA-Z0-9]{8,16}$/;
            testgodizg=/19|20[0-9]{2}/; //malo urednije
            
            
            var testrez1=godina.match(testgodizg);
            
            if(grad==null||grad==""||isNaN(grad)==false)
            {
                alert('aloo');
                document.getElementById("grad").focus();
                greska.innerHTML="Unesite naziv grada";
                return false;
            }
            if(ulica==null||ulica==""||isNaN(ulica)==false)
            {
                document.getElementById("ulica").focus();
                greska.innerHTML="Unesi naziv ulice";
                return false;
            }
            if(cijena==null||cijena==""||!cijena.match(/^\d+$/)){
                document.getElementById("cijena1").focus();
                greska.innerHTML="Unesi cijenu(brojevi) ";
                return false;
                
            }
                     
            if(sprat==null||sprat==""||!sprat.match(/^\d{1,3}$/))
            {
                document.getElementById("sprat").focus();
                greska.innerHTML="Sprat(broj)?";              
                return false;
            }  
            
            if(godina==null||godina==""||!testrez1)
            {                
                document.getElementById("godinaizgradnje").focus();
                greska.innerHTML="Godina izgradnje?";                
                return false;
            }  
                      
            if(kvadratura==null||kvadratura==""||!kvadratura.match(/^\d{1,3}$/))
            {
                document.getElementById("kvadratura").focus();
                greska.innerHTML="Unesi broj kvadrata prostora";
                return false;
            } 
            
            if(brojsoba==null||brojsoba==""||!brojsoba.match(/^\d{1,2}$/)){
                document.getElementById("brojsoba").focus();
                greska.innerHTML="Unesi broj soba";
                return false;
            }
            if(daljina==null||daljina==""){
                document.getElementById("daljina").focus();
                greska.innerHTML="Unesi udaljenost od centra";
                return false;
            }
            
            
            return true;
        }  
    
    
</script>


<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; height: 1100px;" class="container pt-lg-3 pb-md-5" >
        <h1><b>PROMJENI NEKRETNINU</b></h1>
         <center> <div style="color:red;font-size:25px;" id="greska1"></div></center>
        
         <% String poruka=(String)request.getAttribute("poruka");
         if(poruka!=null){
         %>
         <h3 style="color:darkred;"><%=poruka%></h3>
         <% } %>
         <%
             
             String poruka1=(String)sesija.getAttribute("porukas");
         if(poruka1!=null){
         %>
         <h3 style="color:darkred;"><%=poruka1%></h3>
         <% } %>
         
         
         
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
       
     
           
          
           <form action="PromjeniNekretninuM" method="post" id="stan">
           <div style="width:100%;height: 400px;margin-top: 40px;">
               <input type="hidden" name="id" value="<%=nekid%>">
              
               <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Grad:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="grad" value="<%=grad%>" placeholder="Unesi naziv grada" id="grad">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Ulica:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="ulica" value="<%=ulica%>" placeholder="Unesi naziv ulice" id="ulica">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Cijena:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="cijena" value="<%=cijena%>" placeholder="Cijena" id="cijena1" size="12">
                        </div>
                   </div>
                   
               </div>
               <div id="red_dodatno" style="background-color:#ceeced; ">
                  <div id="kolona" >
                    
                     <div id="red_mali">
                         <div id="red_pola"  >
                             Struktura:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                            <select name="struktura">
                            <option value="<%=struktura%>"><%=struktura%></option>
                            <option>JEDNOSOBAN</option>
                            <option>DVOSOBAN</option>
                            <option>TROSOBAN</option>
                            <option>CETVOROSOBAN</option>
                            <option>VISESOBAN</option>
                            <option>STUDIO</option>
                            <option>OSTALO</option>
                        </select>
                         </div>
                     </div>
                     <div id="red_mali">
                         <div id="red_pola">
                             Tip:
                         </div>
                            <div id="red_pola" style="font-size:16px; text-align: left;">
                                <input type="text" readonly name="tip" value="SALE" size="12">
                            </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                             Tip nekretnine:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                            <select name="vrstanekretnine">
                                <option value="<%=tipnek%>"><%=tipnek%></option>
                                <option>APARTMENT</option>
                                <option>HOUSE</option>
                                <option>BUSINESS</option>
                             </select>
                         </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Kvadratura:
                         </div>
                     <div id="red_pola" style="font-size:16px; text-align: left;">
                                <input type="text" id="kvadratura" value="<%=velicina%>" name="kvadratura" placeholder="Broj kvadrata" size="12">
                     </div>
                          
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Izgradnja(god.):
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                               <input type="text" name="godinaizgradnje" value="<%=godizg%>" placeholder="God izgradnje(1900-2010)" id="godinaizgradnje" size="12">
                        </div>
                     </div> 
                     
                    
                 </div>
                 <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola" >
                             Daljina(centar):
                         </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="daljina" value="<%=daljina%>" id='daljina' placeholder="Daljina od centra grada" size="12">
                        </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Broj soba:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                               <input type="text" name="brojsoba" id='brojsoba' value="<%=brojsoba%>" placeholder="Broj soba" size="12">
                        </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Sprat:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                             <input type="text" name="sprat" size="5" value="<%=sprat%>" placeholder="Sprat" id="sprat" size="12">
                        </div>
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                            -:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" size='4' readonly>
                        </div>
                         
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola" style="font-size:18px; text-align: center;color:red;">
                             STATUS:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                               <select name="status">
                                <option value="<%=status%>"><%=status%></option>
                                <option value="AKTIVAN">AKTIVAN</option>  
                                <option value="ODOBRI">ODOBRI</option>
                                <option value="BLOKIRAN">BLOKIRAN</option>
                                <option value="OBRISAN">OBRISAN</option>
                                
                             </select>
                        </div>
                     </div> 
                    
                 </div>
                  <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola" >
                             Garaza:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                           <select name="garaza">
                              <option value="<%=garaza%>"><%=garaza%></option>
                              <option>NE</option>
                              <option>DA</option>
                            
                           </select>
                         </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                            Podrum:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                           <select name="podrum">
                            <option value="<%=podrum%>"><%=podrum%></option>
                            <option>NE</option>
                            <option>DA</option>
                            
                        </select>
                         </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Parking:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                           <select name="parking">
                            <option value="<%=parking%>"><%=parking%></option>
                            <option>NE</option>
                            <option>DA</option>
                            
                        </select>
                         </div>
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                            Terasa:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                           <select name="terasa">
                            <option value="<%=terasa%>"><%=terasa%></option>   
                            <option>NE</option>
                            <option>DA</option>                            
                           </select>
                          </div>  
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                            Lift:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                           <select name="lift">
                            <option value="<%=lift%>"><%=lift%></option>
                            <option>NE</option>
                            <option>DA</option>                            
                           </select>
                          </div>  
                     </div> 
                    
                 </div>
                    
               
                 
                 
            </div>
               <div style="width: 100%;height: 50px;margin-bottom:10px;">
               <button class="button1 button2">SUBMIT</button>
               </div>
               
           </div>
           </form>
                            
                            
            <%
                        ArrayList<NekretnineSlike> slike=Slike.getSlike(nekid); 
                
                        String poruka2="Nema slika za ovu nekretninu...";
                        int brslika=0;
                        %>       
                        
                        
                        
                        
         <form action="PromjeniNekretninuM" method="get">  
              <input type="hidden" name="nekid" value="<%=nekid%>">
         <div  style="background-color: darkcyan; border-radius: 15px; width:100%;height: 120px;margin-top:  40px;">
                     <% for(NekretnineSlike pom:slike){ brslika++;
                         %>
                    <div style=" border-radius: 15px; float:left;width:100px;height:100px; background-color: #EBF4cc; margin: 5px;padding:5px; border:2px solid; display:inline-block;" >
                        <div style="height:80%; width:80%;"><img src="Slike/<%=pom.getNaziv()%>" height="80%" width="80%">
                            
                        </div>  
                          <% if(pom.getTitle().equals("profile")){ %>
                         <input type="checkbox" checked name="profile" value="<%=pom.getId()%>">
                      <% }  else{%>
                      <input type="checkbox"  name="profile" value="<%=pom.getId()%>">
                      <% } %>
                    </div> 
                        <% }  if(brslika==0){ %>
                        <br>   <h3 style="color:white; font-size:25px;"><%=poruka2%><a style="color:red;" href="KlijentSamoSlike.jsp?id=<%=nekid%>">Dodaj nove</a></h3>
                      <%  }  %>
                       
                                 
             
         </div>    
                        <center><input type="submit" id="hide" value="Promjeni profilnu" class="button1 button2 "></center>        
         </form>  
         
                      
                      <form action="DodajOpis" method="post">
                          <input type="hidden" name="id" value="<%=nekid%>">
                          <div style="background-color: darkcyan;width: 60%;height: 250px;margin-top: 20px;">
                              <h2 style="color:white;">Dodatne info</h2>
                              <div style="background-color: white;width: 100%;height: 60%;">
                                
                                    <%
                                        
                                      String opis="";  opis=Opis.getOpis(nekid);
                                      String opomena="Trenutno nema dodatnog opisa.";
                                    
                                    %>
                                     
                                  
                                    <textarea style="height: 100%;width:100%;" name="opis"><% if(opis.equals("")){%><%=opomena%><% } else{ %><%=opis%> <% } %></textarea>
                                                                        
                                     
                                 
                                  
                                   
                              </div>
                              <div style="height: 10%;">
                                  <input type="submit" value="Dodaj" class="button1 button2 ">
                              </div>
                          </div>
                          
                      </form>
        
</div>
  
        

</center>
</div>        
 <%@include  file="footer.jsp" %>
