package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Polisa implements OpstiDomenskiObjekat {

    private int polisaId;
    private int ukupno;
    private int premijskiStepen;
    private Date datumUgovaranja;
    private Date datumRaskidanja;

    public Polisa() {
    }

    public Polisa(int polisaId, int ukupno, int premijskiStepen, Date datumUgovaranja) {
        this.polisaId = polisaId;
        this.ukupno = ukupno;
        this.premijskiStepen = premijskiStepen;
        this.datumUgovaranja = datumUgovaranja;
    }

    public int getPolisaId() {
        return polisaId;
    }

    public void setPolisaId(int polisaId) {
        this.polisaId = polisaId;
    }

    public int getUkupno() {
        return ukupno;
    }

    public void setUkupno(int ukupno) {
        this.ukupno = ukupno;
    }

    public int getPremijskiStepen() {
        return premijskiStepen;
    }

    public void setPremijskiStepen(int premijskiStepen) {
        this.premijskiStepen = premijskiStepen;
    }

    public Date getDatumUgovaranja() {
        return datumUgovaranja;
    }

    public void setDatumUgovaranja(Date datumUgovaranja) {
        this.datumUgovaranja = datumUgovaranja;
    }

    public Date getDatumRaskidanja() {
        return datumRaskidanja;
    }

    public void setDatumRaskidanja(Date datumRaskidanja) {
        this.datumRaskidanja = datumRaskidanja;
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
