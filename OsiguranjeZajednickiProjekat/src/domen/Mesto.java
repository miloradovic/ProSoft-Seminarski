package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
        return ptt + ", " + naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "Mesto";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "Ptt, Naziv";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ptt + ",'" + naziv + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                int pttLocal = rs.getInt("Ptt");
                String nazivLocal = rs.getString("Naziv");
                Mesto m = new Mesto(pttLocal, nazivLocal);
                lo.add(m);
            }
            return lo;
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
