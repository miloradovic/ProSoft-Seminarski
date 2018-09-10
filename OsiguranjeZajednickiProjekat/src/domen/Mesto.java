package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Mesto implements OpstiDomenskiObjekat {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
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
        return "SELECT * FROM Mesto";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lo = new ArrayList<>();
        try {
            while (rs.next()) {
                int pttLocal = rs.getInt("Ptt");
                String nazivLocal = rs.getString("Naziv");
                lo.add(new Mesto(pttLocal, nazivLocal));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return lo;
    }
}
