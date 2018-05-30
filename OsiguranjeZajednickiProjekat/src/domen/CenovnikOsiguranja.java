package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Darko
 */
public class CenovnikOsiguranja implements OpstiDomenskiObjekat {

    private int cenovnikId;
    private String kategorija;
    private int cena;

    public CenovnikOsiguranja() {
    }

    public CenovnikOsiguranja(int cenovnikId, String kategorija, int cena) {
        this.cenovnikId = cenovnikId;
        this.kategorija = kategorija;
        this.cena = cena;
    }

    public int getCenovnikId() {
        return cenovnikId;
    }

    public void setCenovnikId(int cenovnikId) {
        this.cenovnikId = cenovnikId;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return kategorija;
    }

    @Override
    public String vratiNazivTabele() {
        return "CenovnikOsiguranja";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSeta(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzResultSeta(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
