package beans;

/**
 *
 * @author Djole
 */
public class Korisnik {
    private int korisnikID;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String adresa;    
    private String email;
    private String pozicija;
   
    private String telefon;

    public Korisnik(){
    
    }
       
    
    /**
     * @return the korisnikID
     */
    public int getKorisnikID() {
        return korisnikID;
    }

    /**
     * @param korisnikID the korisnikID to set
     */
    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pozicija
     */
    public String getPozicija() {
        return pozicija;
    }

    /**
     * @param pozicija the pozicija to set
     */
    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

 
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

   
    
    
    
}
