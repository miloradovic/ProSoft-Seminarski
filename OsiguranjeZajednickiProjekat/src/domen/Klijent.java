package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Darko
 */
public class Klijent implements OpstiDomenskiObjekat {

    private int klijentId;
    private String ime;
    private String prezime;
    private String jmbg;
    private String ulicaBroj;
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(int klijentId, String ime, String prezime, String jmbg, String ulicaBroj, Mesto mesto) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return true;
    }

    @Override
    public String unos() {
        return String.format(
                "INSERT INTO klijent(Ime, Prezime, JMBG, UlicaBroj, Ptt) VALUES ('%s', '%s', '%s', '%s', %d)",
                ime, prezime, jmbg, ulicaBroj, mesto.getPtt());
    }

    @Override
    public String izmena() {
        return String.format(
                "UPDATE klijent SET Ime = '%s', Prezime = '%s', JMBG = '%s', UlicaBroj = '%s', Ptt = %d WHERE KlijentID = %d",
                ime, prezime, jmbg, ulicaBroj, mesto.getPtt(), klijentId);
    }

    @Override
    public String brisanje() {
        return String.format("DELETE FROM klijent WHERE KlijentID = %d", klijentId);
    }

    @Override
    public String pretraga() {
        return "SELECT * FROM Klijent k JOIN Mesto m on k.ptt = m.ptt";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new Klijent(
                        rs.getInt("KlijentID"),
                        rs.getString("Ime"),
                        rs.getString("Prezime"),
                        rs.getString("JMBG"),
                        rs.getString("UlicaBroj"),
                        new Mesto(rs.getInt("m.Ptt"), rs.getString("m.Naziv"))));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }

}
