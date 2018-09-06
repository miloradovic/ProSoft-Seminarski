package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Darko
 */
public class CenovnikOsiguranja implements OpstiDomenskiObjekat {

    private int cenovnikId;
    private String kategorija;
    private double cena;

    public CenovnikOsiguranja() {
    }

    public CenovnikOsiguranja(int cenovnikId, String kategorija, double cena) {
        this.cenovnikId = cenovnikId;
        this.kategorija = kategorija;
        this.cena = cena;
    }

    public int getCenovnikId() {
        return cenovnikId;
    }

    public void setCenovnikId(int cenovnikId) {
        this.cenovnikId = cenovnikId;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return kategorija;
    }

    @Override
    public String unos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String izmena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String brisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pretraga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
