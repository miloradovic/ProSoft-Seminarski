package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class StavkaPolise implements OpstiDomenskiObjekat {

    private int polisaId;
    private int rb;
    private String naziv;
    private double cena;
    private CenovnikOsiguranja cenovnik;

    public StavkaPolise() {
    }

    public StavkaPolise(int polisaId, int rb, String naziv, double cena, CenovnikOsiguranja cenovnik) {
        this.polisaId = polisaId;
        this.rb = rb;
        this.naziv = naziv;
        this.cena = cena;
        this.cenovnik = cenovnik;
    }

    public int getPolisaId() {
        return polisaId;
    }

    public void setPolisaId(int polisaId) {
        this.polisaId = polisaId;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public CenovnikOsiguranja getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(CenovnikOsiguranja cenovnik) {
        this.cenovnik = cenovnik;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public double getKoeficijent(int i) {
        switch (i) {
            case 1:
                return 0.85;
            case 2:
                return 0.90;
            case 3:
                return 0.95;
            case 4:
                return 1;
            case 5:
                return 1.15;
            case 6:
                return 1.30;
            case 7:
                return 1.50;
            case 8:
                return 1.70;
            case 9:
                return 1.90;
            case 10:
                return 2.10;
            case 11:
                return 2.30;
            case 12:
                return 2.50;
            default:
                return 0.0;
        }
    }

    @Override
    public String unos() {
        if (cenovnik == null) {
            return String.format(
                    "INSERT INTO stavka_polise(PolisaID, RB, Naziv, Cena) VALUES (%d, %d, '%s', %f)", 
                    polisaId, rb, naziv, cena);
        }
        return String.format(
                "INSERT INTO stavka_polise VALUES (%d, %d, '%s', %f, %d)",
                polisaId, rb, naziv, cena, cenovnik.getCenovnikId());
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
        return "SELECT * FROM stavka_polise sp LEFT JOIN cenovnik_osiguranja co ON sp.CenovnikID = co.CenovnikID "
                + "ORDER BY PolisaID, RB ASC";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new StavkaPolise(
                        rs.getInt("PolisaID"),
                        rs.getInt("RB"),
                        rs.getString("Naziv"),
                        rs.getDouble("Cena"),
                        new CenovnikOsiguranja(
                                rs.getInt("CenovnikID"), 
                                rs.getString("Kategorija"), 
                                rs.getDouble("co.Cena"))));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }

}
