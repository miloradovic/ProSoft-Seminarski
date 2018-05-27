package domen;

/**
 *
 * @author Darko
 */
public class Referent {
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
    
    
}
