package so.vozilo;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class VratiVozilaSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaVozila;

    public VratiVozilaSO(Object obj) {
        super(obj);
    }
    
    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaVozila = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public List<OpstiDomenskiObjekat> getListaVozila() {
        return listaVozila;
    }
}
