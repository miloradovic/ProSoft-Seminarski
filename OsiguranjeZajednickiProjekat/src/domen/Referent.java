package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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

    public Referent(String user, String pass) {
        this.user = user;
        this.pass = pass;
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
    public String vratiNazivTabele() {
        return "Referent";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "ReferentID, Ime, Prezime, KorisnickoIme, KorisnickaSifra";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return referentId + ",'" + ime + ",'" + prezime + ",'" 
                + user + ",'" + pass + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String imeLocal = rs.getString(2);
                String prezimeLocal = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                Referent r = new Referent(id, imeLocal, prezimeLocal, username, password);
                
                lo.add(r);
            }
            return lo;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzResultSeta(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
