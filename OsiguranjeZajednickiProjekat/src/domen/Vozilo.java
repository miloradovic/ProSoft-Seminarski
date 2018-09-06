package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Vozilo implements OpstiDomenskiObjekat{
    
    private int voziloId;
    private String regTablice;
    private String marka;
    private String model;
    private int snagaMotora;
    private Date godinaProizvodnje;

    public Vozilo() {
    }

    public Vozilo(int voziloId, String regTablice, String marka, String model, int snagaMotora, Date godinaProizvodnje) {
        this.voziloId = voziloId;
        this.regTablice = regTablice;
        this.marka = marka;
        this.model = model;
        this.snagaMotora = snagaMotora;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public int getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(int voziloId) {
        this.voziloId = voziloId;
    }

    public String getRegTablice() {
        return regTablice;
    }

    public void setRegTablice(String regTablice) {
        this.regTablice = regTablice;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(int snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public Date getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Date godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    @Override
    public String toString() {
        return marka + " - " + model + "(" + godinaProizvodnje + ")";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
