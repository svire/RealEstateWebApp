package beans;
import java.util.Date;
/**
 *
 * @author Djole
 */
public class Poruka {
    
    
    private Integer porukaId;
   
    private int odId;
 
    private int zaId;
   
    private String tema;
  
    private String sadrzaj;
    
    private Date vrijeme;
   
    private boolean readd;
    
    public Poruka() {
    }
    
     public Integer getPorukaId() {
        return porukaId;
    }

    public void setPorukaId(Integer porukaId) {
        this.porukaId = porukaId;
    }

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public int getZaId() {
        return zaId;
    }

    public void setZaId(int zaId) {
        this.zaId = zaId;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public boolean getReadd() {
        return readd;
    }

    public void setReadd(boolean readd) {
        this.readd = readd;
    }
    
}
