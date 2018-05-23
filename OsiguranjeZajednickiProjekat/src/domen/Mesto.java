package domen;

/**
 *
 * @author Darko
 */
public class Mesto {

    private int MestoId;
    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int MestoId, int ptt, String naziv) {
        this.MestoId = MestoId;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getMestoId() {
        return MestoId;
    }

    public void setMestoId(int MestoId) {
        this.MestoId = MestoId;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return ptt + ", " + naziv;
    }
}
