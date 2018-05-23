package transfer;

import java.io.Serializable;

/**
 *
 * @author Darko
 */
public class TransferObjekatZahtev implements Serializable {

    private int operacija;
    private Object parametar;

    public TransferObjekatZahtev() {
    }

    public TransferObjekatZahtev(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

}
