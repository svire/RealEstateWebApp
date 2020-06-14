package beans;
import java.util.*;
/**
 *
 * @author Djole
 */
public class Rentanje extends Nekretnina { 
   
     private Integer nekretninaId;
     
    private String klima;
   
    private String vesMasina;
    
    private String internet;
   
    private String tv;
 
    private double struja;
   
    private double dodatneRezije;

    private double grijanje;
   
    private String periodPlacanja;
   
    private String minRenta;
   
    private String useljiv;
    public Rentanje() {
    }
    
    
      public Integer getNekretninaId() {
        return nekretninaId;
    }

    public void setNekretninaId(Integer nekretninaId) {
        this.nekretninaId = nekretninaId;
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

    public double getStruja() {
        return struja;
    }

    public void setStruja(double struja) {
        this.struja = struja;
    }

    public double getDodatneRezije() {
        return dodatneRezije;
    }

    public void setDodatneRezije(double dodatneRezije) {
        this.dodatneRezije = dodatneRezije;
    }

    public double getGrijanje() {
        return grijanje;
    }

    public void setGrijanje(double grijanje) {
        this.grijanje = grijanje;
    }

    public String getPeriodPlacanja() {
        return periodPlacanja;
    }

    public void setPeriodPlacanja(String periodPlacanja) {
        this.periodPlacanja = periodPlacanja;
    }

    public String getMinRenta() {
        return minRenta;
    }

    public void setMinRenta(String minRenta) {
        this.minRenta = minRenta;
    }

    public String getUseljiv() {
        return useljiv;
    }

    public void setUseljiv(String useljiv) {
        this.useljiv = useljiv;
    }
    
}
