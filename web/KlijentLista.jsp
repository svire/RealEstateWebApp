<header>
    <div class="nav">
        <img src="Slike/estates.png" alt="logo" style="margin-left: 30px;float:left;max-height: 130px; max-width: 180px;border: 4px solid white;" >
        
        
        <nav>
            <ul>
              
                <li><a href="KlijentNoveNekretnine.jsp">Dodaj nekretninu</a></li>
                <li><a href="KlijentMojeNekretnine1?biraj=SALE">Moje nekretnine</a></li>                             
                <li><a href="PorukeKorisnika">Poruke</a></li>
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
    