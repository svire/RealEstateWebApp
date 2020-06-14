<header>
    <div class="nav">
        <img src="Slike/estates.png" alt="logo" style="margin-left: 30px;float:left;max-height: 130px; max-width: 180px;border: 4px solid white;" >
        
        
        <nav>
            <ul>
                <li><a href="KorisnikPocetna">Pocetna</a></li>
                <li><a href="PretraziNekretnineP">Prodaja</a></li>
                <li><a href="PretraziNekretnineR">Renta</a></li>
                <li><a href="PretraziNekretnineS">Stan na dan</a></li>                
                <li><a href="KorisnikKontakt.jsp">Kontakt</a></li>
                <li><a href="KorisnikDodatno.jsp">Dodatno</a></li>
                
                 <%
            HttpSession sesija=request.getSession();
            if(sesija!=null && sesija.getAttribute("korisnik")!=null)
            {
                out.println("<li style='border:3px solid #DB7093; border-radius: 9px; '><a href='logout.jsp'>Odjavi se</a></li>");
 
            
            }
            else{
                         out.println("<li style='border:3px solid #DB7093; border-radius: 9px; '><a href='login.jsp'>Uloguj se</a></li>");
            }
            
            %>
            </ul>
            
        </nav>
    
    </div>
</header>     
    