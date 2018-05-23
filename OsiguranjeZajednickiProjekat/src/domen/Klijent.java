package domen;

/**
 *
 * @author Darko
 */
public class Klijent {
    private int klijentId;
    private String ime;
    private String prezime;
    private String jbmg;
    private String ulicaBroj;
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(int klijentId, String ime, String prezime, String jbmg, String ulicaBroj, Mesto mesto) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.jbmg = jbmg;
        this.ulicaBroj = ulicaBroj;
        this.mesto = mesto;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJbmg() {
        return jbmg;
    }

    public void setJbmg(String jbmg) {
        this.jbmg = jbmg;
    }

    public String getUlicaBroj() {
        return ulicaBroj;
    }

    public void setUlicaBroj(String ulicaBroj) {
        this.ulicaBroj = ulicaBroj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
}
