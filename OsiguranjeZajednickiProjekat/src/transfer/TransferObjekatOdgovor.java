package transfer;

import java.io.Serializable;

/**
 *
 * @author Darko
 */
public class TransferObjekatOdgovor implements Serializable {

    private Object rezultat;
    private Exception izuzetak;
    private String poruka;

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

}
