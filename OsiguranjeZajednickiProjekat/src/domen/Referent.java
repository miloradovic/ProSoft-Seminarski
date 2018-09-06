package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Referent implements OpstiDomenskiObjekat {

    private int referentId;
    private String ime;
    private String prezime;
    private String user;
    private String pass;

    public Referent() {
    }

    public Referent(int referentId, String ime, String prezime, String user, String pass) {
        this.referentId = referentId;
        this.ime = ime;
        this.prezime = prezime;
        this.user = user;
        this.pass = pass;
    }

    public int getReferentId() {
        return referentId;
    }

    public void setReferentId(int referentId) {
        this.referentId = referentId;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        if (user != null && pass != null) {
            return "SELECT * FROM Referent WHERE KorisnickoIme = '" + user + "' AND KorisnickaSifra = '" + pass + "'";
        }
        return "SELECT * FROM Referent";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new Referent(
                        rs.getInt("referentID"), 
                        rs.getString("Ime"), 
                        rs.getString("Prezime"), 
                        rs.getString("KorisnickoIme"), 
                        rs.getString("KorisnickaSifra")));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }

}
