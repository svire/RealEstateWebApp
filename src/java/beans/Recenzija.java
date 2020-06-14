package beans;


/**
 *
 * @author Djole
 */

public class Recenzija{

   
    private Integer recenzijeId;
    
    private Integer nekretninaId;
    
    private Integer korisnikId;
   
    private String naslov;
   
    private int ocjena;
    
    private String pozitivno;
  
    private String negativno;
    
    private String datum;
   
    

    public Recenzija() {
    }

    

    public Integer getRecenzijeId() {
        return recenzijeId;
    }

    public void setRecenzijeId(Integer recenzijeId) {
        this.recenzijeId = recenzijeId;
    }
    // private Integer nekretninaId;    private Integer korisnikId;
    
    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }
    
    
     public Integer getNekretninaId() {
        return nekretninaId;
    }

    public void setNekretninaId(Integer nekretninaId) {
        this.nekretninaId = nekretninaId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public String getPozitivno() {
        return pozitivno;
    }

    public void setPozitivno(String pozitivno) {
        this.pozitivno = pozitivno;
    }

    public String getNegativno() {
        return negativno;
    }

    public void setNegativno(String negativno) {
        this.negativno = negativno;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

   
  
    @Override
    public String toString() {
        return "beans.Recenzije[ recenzijeId=" + recenzijeId + " ]";
    }
    
}
