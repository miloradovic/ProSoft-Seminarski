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
    private Klijent klijent;
    private Vozilo vozilo;
    private Referent referentUgovaranje;
    private Referent referentRaskidanje;
    private List<StavkaPolise> listaStavki;

    public Polisa() {
        listaStavki = new ArrayList<>();
    }

    public Polisa(int polisaId, double ukupno, int premijskiStepen, Date datumUgovaranja, Date datumRaskidanja, Klijent klijent, Vozilo vozilo, Referent referentUgovaranje, Referent referentRaskidanje) {
        this.polisaId = polisaId;
        this.ukupno = ukupno;
        this.premijskiStepen = premijskiStepen;
        this.datumUgovaranja = datumUgovaranja;
        this.datumRaskidanja = datumRaskidanja;
        this.klijent = klijent;
        this.vozilo = vozilo;
        this.referentUgovaranje = referentUgovaranje;
        this.referentRaskidanje = referentRaskidanje;
        listaStavki = new ArrayList<>();
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

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Referent getReferentUgovaranje() {
        return referentUgovaranje;
    }

    public void setReferentUgovaranje(Referent referentUgovaranje) {
        this.referentUgovaranje = referentUgovaranje;
    }

    public Referent getReferentRaskidanje() {
        return referentRaskidanje;
    }

    public void setReferentRaskidanje(Referent referentRaskidanje) {
        this.referentRaskidanje = referentRaskidanje;
    }

    public List<StavkaPolise> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaPolise> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public void pripremiPolisu() {
        double ukupanIznos = 0;
        int rb = 1;
        for (StavkaPolise stavka : getListaStavki()) {
            ukupanIznos += stavka.getCena();
            stavka.setRb(rb);
            stavka.setPolisaId(polisaId);
            rb++;
        }
        setUkupno(ukupanIznos);
    }

    @Override
    public String unos() {
        return String.format(
                "INSERT INTO polisa(Ukupno, PremijskiStepen, DatumUgovaranja, KlijentID, VoziloID, ReferentUgovarao) "
                + "VALUES (%f, %d, '%tF', %d, %d, %d)",
                ukupno,
                premijskiStepen,
                new java.sql.Date(datumUgovaranja.getTime()),
                klijent.getKlijentId(),
                vozilo.getVoziloId(),
                referentUgovaranje.getReferentId());
    }

    @Override
    public String izmena() {
        return String.format(
                "UPDATE polisa SET DatumRaskidanja = '%tF', ReferentRaskidao = %d WHERE PolisaID = %d",
                new java.sql.Date(datumRaskidanja.getTime()),
                referentRaskidanje.getReferentId(),
                polisaId);
    }

    @Override
    public String brisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pretraga() {
        return String.format(
                "SELECT p.*, k.*, v.*, ru.*, rr.* "
                + "FROM polisa p "
                + "JOIN klijent k ON p.KlijentID = k.KlijentID "
                + "JOIN vozilo v ON p.VoziloID = v.VoziloID "
                + "JOIN referent ru ON p.ReferentUgovarao = ru.ReferentID "
                + "LEFT JOIN referent rr ON p.ReferentRaskidao = rr.ReferentID");
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Klijent k = new Klijent(
                        rs.getInt("k.KlijentID"),
                        rs.getString("k.Ime"),
                        rs.getString("k.Prezime"), null, null, new Mesto());
                Vozilo v = new Vozilo(
                        rs.getInt("v.VoziloID"),
                        rs.getString("v.RegTablice"),
                        rs.getString("v.Marka"),
                        rs.getString("v.Model"), -1, null);
                Referent rUgov = new Referent(
                        rs.getInt("ru.ReferentID"),
                        rs.getString("ru.Ime"),
                        rs.getString("ru.Prezime"), null, null);
                Referent rRask = new Referent(
                        rs.getInt("rr.ReferentID"),
                        rs.getString("rr.Ime"),
                        rs.getString("rr.Prezime"), null, null);

                lista.add(
                        new Polisa(
                                rs.getInt("PolisaID"),
                                rs.getDouble("Ukupno"),
                                rs.getInt("PremijskiStepen"),
                                rs.getDate("DatumUgovaranja"),
                                rs.getDate("DatumRaskidanja"),
                                k,
                                v,
                                rUgov,
                                rRask));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }

}
