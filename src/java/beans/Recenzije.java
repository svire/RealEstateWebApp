/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


/**
 *
 * @author Djole
 */

public class Recenzije{

   
    private Integer recenzijeId;
   
    private String naslov;
   
    private int ocjena;
    
    private String pozitivno;
  
    private String negativno;
    
    private String datum;
   
    

    public Recenzije() {
    }

    

    public Integer getRecenzijeId() {
        return recenzijeId;
    }

    public void setRecenzijeId(Integer recenzijeId) {
        this.recenzijeId = recenzijeId;
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
