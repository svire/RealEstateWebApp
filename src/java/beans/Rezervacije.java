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

public class Rezervacije  {


    private int korisnikId;
    
    private int nekretninaId;
    
    private Integer rezervacijaId;
 
    private String bookingStatus;
    
    private String bookingStartDate;
   
    private String bokkingEndDate;
  
    private String detalji;
  
   

    public Rezervacije() {
    }

    public Rezervacije(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Rezervacije(Integer rezervacijaId, String bookingStartDate, String bokkingEndDate, String detalji) {
        this.rezervacijaId = rezervacijaId;
        this.bookingStartDate = bookingStartDate;
        this.bokkingEndDate = bokkingEndDate;
        this.detalji = detalji;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(String bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public String getBokkingEndDate() {
        return bokkingEndDate;
    }

    public void setBokkingEndDate(String bokkingEndDate) {
        this.bokkingEndDate = bokkingEndDate;
    }

    public String getDetalji() {
        return detalji;
    }

    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }

    public int getNekretninaId() {
        return nekretninaId;
    }

    public void setNekretninaId(int nekretninaId) {
        this.nekretninaId = nekretninaId;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }


    

    
}
