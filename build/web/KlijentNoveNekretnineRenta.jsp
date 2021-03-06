
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@page import="beans.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*"%>
<%@include file="KlijentLista.jsp"%>
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
            struja=document.getElementById("struja").value;
            grijanje=document.getElementById("grijanje").value;
            periodplacanja=document.getElementById("periodplacanja").value;
            minrenta=document.getElementById("minrenta").value;
            useljiv=document.getElementById("useljiv").value;
           
            
            
            testpassword=/^[a-zA-Z0-9]{8,16}$/;
            testgodizg=/19|20[0-9]{2}/; //malo urednije
            
            
            var testrez1=godina.match(testgodizg);
            
            if(grad==null||grad==""||isNaN(grad)==false)
            {
               
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
             if(struja==null||struja==""||!struja.match(/^\d+$/)){
                document.getElementById("struja").focus();
                greska.innerHTML="Cijena struje?";
                return false;                
            }
            if(grijanje==null||grijanje==""||!grijanje.match(/^\d+$/)){
                document.getElementById("grijanje").focus();
                greska.innerHTML="Unesi cijenu grijanja ";
                return false;
                
            }
          
            if(periodplacanja==null||periodplacanja==""){
                document.getElementById("periodplacanja").focus();
                greska.innerHTML="Period placanja? ";
                return false;              
            }
             if(minrenta==null||minrenta==""){
                document.getElementById("minrenta").focus();
                greska.innerHTML="Min. zakupnina mjeseci";
                return false;
                
            }
            if(useljiv==null||useljiv==""){
                document.getElementById("useljiv").focus();
                greska.innerHTML="Useljiv datuma";
                return false;
                
            }
            
            return true;
        }  
    
    
</script>


<div id="container" style="overflow: hidden;min-height: 500px;">
    
    <center>
    <div style="background-color:#ceeced;margin:50px; height: 1000px;" class="container pt-lg-3 pb-md-5" >
        <h1><b>RENTANJE NOVO</b></h1>
        <div style="color:red" id="greska1"></div>
        
        <% String poruka=(String)request.getAttribute("poruka"); 
        if(poruka!=null){%>
        <h3 style="color:darkred;"><%=poruka%></h3>
        <% }%>
        
        <div class="tab" style="margin:35px;">
            <button class="tablinks"><a href="KlijentNoveNekretnine.jsp">Prodaja</a></button>
            <button class="tablinks"><a href="KlijentNoveNekretnineRenta.jsp">Renta</a></button>
            <button class="tablinks"><a href="KlijentNoveNekretnineStan.jsp">Stan na dan</a></button>
            <button class="tablinks"><a style="color:#b21f2d;" href="KlijentDodajSlike.jsp"><span class="blink">Dodaj slike</span></a></button>
        </div>
     
           
          
           
           <form action="DodajNekretninu" method="post" id="stan"  onsubmit="return validacija()">
               
           <div style="width:100%;height: 600px;">
              <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Grad:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="grad" placeholder="Unesi naziv grada" id="grad">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Ulica:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="ulica" placeholder="Unesi naziv ulice" id="ulica">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Cijena:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="cijena" placeholder="Cijena" id="cijena1" size="12">
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
                                <input type="text" readonly name="tip" value="RENT" size="12">
                            </div>
                     </div> 
                     <div id="red_mali">
                         <div id="red_pola">
                             Tip nekretnine:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                            <select name="vrstanekretnine">
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
                                <input type="text" id="kvadratura" name="kvadratura" placeholder="Broj kvadrata" size="12">
                     </div>
                          
                     </div>  
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Izgradnja(god.):
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                               <input type="text" name="godinaizgradnje" placeholder="God izgradnje(1900-2010)" id="godinaizgradnje" size="12">
                        </div>
                     </div> 
                     
                    
                 </div>
                 <div id="kolona" >
                     <div id="red_mali">
                         <div id="red_pola" >
                             Daljina(centar):
                         </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="daljina" id='daljina' placeholder="Daljina od centra grada" size="12">
                        </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Broj soba:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                               <input type="text" name="brojsoba" id='brojsoba' placeholder="Broj soba" size="12">
                        </div>
                     </div>
                     
                     <div id="red_mali">
                         <div id="red_pola">
                             Sprat:
                         </div>
                         <div id="red_pola" style="font-size:16px; text-align: left;">
                             <input type="text" name="sprat" placeholder="Sprat" id="sprat" size="12">
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
                         <div id="red_pola">
                             -:
                         </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                               -:
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
                            <option>NE</option>
                            <option>DA</option>                            
                           </select>
                          </div>  
                     </div> 
                    
                 </div>
               
               <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Struja:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="struja" id="struja" placeholder="Cijena struje" size="12">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Grijanje:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="grijanje" placeholder="Cijena grijanja" id="grijanje" size="12">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Period placanja:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                               <input type="text" name="periodplacanja" id="periodplacanja" placeholder="Unesite period placanja" size="12">
                        </div>
                   </div>                   
               </div>
                <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                           Minimalan zakup:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                             <input type="text" name="minrenta" id='minrenta' placeholder="Min zakup(mjesecima)" size="12">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                          Useljiv:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <input type="text" name="useljiv" id='useljiv' placeholder="Datum kad je stan useljiv" size="12">
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           Klima:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                             <select name="klima">
                                <option>NE</option>
                                <option>DA</option>                            
                             </select>
                              
                              
                          </div>
                   </div>                   
               </div>
                 <div style="width:100%;height: 50px;">
                   <div style="width:33%;height: 50px;float:left; ">
                       <div id="red_pola">
                          Internet:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                             <select name="internet">
                                <option>NE</option>
                                <option>DA</option>                            
                             </select>
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                          Ves masina:
                       </div>
                        <div id="red_pola" style="font-size:16px; text-align: left;">
                              <select name="vesmasina">
                                <option>NE</option>
                                <option>DA</option>                            
                             </select>
                        </div>
                   </div>
                   <div style="width:33%;height: 50px;float:left;">
                       <div id="red_pola">
                           TV:
                       </div>
                          <div id="red_pola" style="font-size:16px; text-align: left;">
                              <select name="tv">
                                <option>NE</option>
                                <option>DA</option>                            
                             </select>
                              
                              
                          </div>
                   </div>                   
               </div>
               
               
               <div style="width: 100%;height: 50px;margin-top: 20px;margin-bottom:10px;">
               <button class="button1 button2">SUBMIT</button>
               </div>
               
           </div>
          
          
           

 
        
</div>
  </form>
          <%
           ArrayList<String> slibe=new ArrayList<String>();
           HttpSession s=request.getSession();
           if((ArrayList<String>)s.getAttribute("nizslika")!=null){
            slibe=(ArrayList<String>)s.getAttribute("nizslika");
           }  %>         
         
             <%     if(slibe.size()==0){
                %>
                
                <h2 style="color:darkred;">Niste dodali slike jos!</h2>
               <% }  %>
            <div style="height: 100px;width: 100%;background-color: #f1f1f1;margin-bottom: 0px;">
               <%     if(slibe.size()>0){
                        for(int i=0;i<slibe.size();i++){
               %>
               <div style="margin:10px;height: 80px;;width: 80px;background-color: darkgoldenrod;float:left;">
                   
                   
                   <img src="Slike/<%=slibe.get(i)%>" style="height: 100%;width: 100%;">
               </div>
                <% } %>
           </div>
           <% }%>

</center>
</div>        
 <%@include  file="footer.jsp" %>
