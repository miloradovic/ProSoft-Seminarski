package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
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
    private Year godinaProizvodnje;

    public Vozilo() {
    }

    public Vozilo(int voziloId, String regTablice, String marka, String model, int snagaMotora, Year godinaProizvodnje) {
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

    public Year getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Year godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    @Override
    public String toString() {
        return marka + " - " + model + " [" + regTablice + "]";
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
        if (regTablice != null) {
            return "SELECT * FROM Vozilo WHERE RegTablice = '" + regTablice + "'";
        }
        if (model != null) {
            return "SELECT * FROM Vozilo WHERE Model = '" + model + "'";
        }
        return "SELECT * FROM Vozilo";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new Vozilo(
                        rs.getInt("VoziloID"), 
                        rs.getString("RegTablice"), 
                        rs.getString("Marka"), 
                        rs.getString("Model"), 
                        rs.getInt("SnagaMotora"),
                        Year.parse(rs.getString("GodinaProizvodnje"), DateTimeFormatter.ISO_DATE)));
            }
        } catch (SQLException e) {
            System.out.println("Greska prilikom ucitavanja: " + e);
        }
        return lista;
    }
    
}
