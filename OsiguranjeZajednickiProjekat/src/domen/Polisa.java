package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Polisa implements OpstiDomenskiObjekat {

    private int polisaId;
    private double ukupno;
    private int premijskiStepen;
    private Date datumUgovaranja;
    private Date datumRaskidanja;
    private String tip;
    private Klijent klijent;
    private Vozilo vozilo;
    private Referent referent;

    public Polisa() {
    }

    public Polisa(int polisaId, double ukupno, int premijskiStepen, Date datumUgovaranja, Date datumRaskidanja, String tip, Klijent klijent, Vozilo vozilo, Referent referent) {
        this.polisaId = polisaId;
        this.ukupno = ukupno;
        this.premijskiStepen = premijskiStepen;
        this.datumUgovaranja = datumUgovaranja;
        this.datumRaskidanja = datumRaskidanja;
        this.tip = tip;
        this.klijent = klijent;
        this.vozilo = vozilo;
        this.referent = referent;
    }

    public int getPolisaId() {
        return polisaId;
    }

    public void setPolisaId(int polisaId) {
        this.polisaId = polisaId;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
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
        return String.format(
                "INSERT INTO polisa VALUES (%d, %f, %d, '%date', '%date', '%s', %d, %d, %d)",
                polisaId, ukupno, premijskiStepen, datumUgovaranja, datumRaskidanja, tip,
                klijent.getKlijentId(),
                vozilo.getVoziloId(),
                referent.getReferentId());
    }

    @Override
    public String izmena() {
        return String.format(
                "UPDATE polisa SET DatumRaskidanja = '%date' WHERE PolisaID = %d",
                datumRaskidanja, polisaId);
    }

    @Override
    public String brisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pretraga() {
        if (polisaId == -1) {
            return "";
        }
        return "SELECT * FROM polisa";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new Polisa(
                        rs.getInt("PolisaID"),
                        rs.getDouble("Ukupno"),
                        rs.getInt("PremijskiStepen"),
                        rs.getDate("DatumUgovaranja"),
                        rs.getDate("DatumRaskidanja"),
                        rs.getString("Tip"),
                        new Klijent(),
                        new Vozilo(),
                        new Referent()));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }

}
