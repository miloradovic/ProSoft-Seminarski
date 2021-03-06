package so.vozilo;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class UcitajVoziloSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaVozila;

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaVozila = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public OpstiDomenskiObjekat ucitajVozilo() {
        return listaVozila.get(0);
    }
}
