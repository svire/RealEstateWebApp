package beans;
import java.util.*;
/**
 *
 * @author Djole
 */
public class Stannadan extends Nekretnina {
     private Integer nekretninaId;
   //ocemo ovo mjenjati
    private String checkIn;
 
    private String checkOut;
   
    private int brojKreveta;
   
    private int minGost;
   
    private Integer maxGost;
 
    private String pets;

    private double nocenjeCijena;
 
    private String pegla;
    
    private String posteljina;

    private String fen;
    
    private String klima;
  
    private String vesMasina;
    
    private String internet;
   
    private String tv;
  
    private String peskiri;
   
    private String pusenjeDozv;
    
    
    
     public Stannadan() {
    }
      
        public Integer getNekretninaId() {
        return nekretninaId;
    }

    public void setNekretninaId(Integer nekretninaId) {
        this.nekretninaId = nekretninaId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public int getMinGost() {
        return minGost;
    }

    public void setMinGost(int minGost) {
        this.minGost = minGost;
    }

    public Integer getMaxGost() {
        return maxGost;
    }

    public void setMaxGost(Integer maxGost) {
        this.maxGost = maxGost;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public double getNocenjeCijena() {
        return nocenjeCijena;
    }

    public void setNocenjeCijena(double nocenjeCijena) {
        this.nocenjeCijena = nocenjeCijena;
    }

    public String getPegla() {
        return pegla;
    }

    public void setPegla(String pegla) {
        this.pegla = pegla;
    }

    public String getPosteljina() {
        return posteljina;
    }

    public void setPosteljina(String posteljina) {
        this.posteljina = posteljina;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public String getKlima() {
        return klima;
    }

    public void setKlima(String klima) {
        this.klima = klima;
    }

    public String getVesMasina() {
        return vesMasina;
    }

    public void setVesMasina(String vesMasina) {
        this.vesMasina = vesMasina;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getPeskiri() {
        return peskiri;
    }

    public void setPeskiri(String peskiri) {
        this.peskiri = peskiri;
    }

    public String getPusenjeDozv() {
        return pusenjeDozv;
    }

    public void setPusenjeDozv(String pusenjeDozv) {
        this.pusenjeDozv = pusenjeDozv;
    }
    
}
