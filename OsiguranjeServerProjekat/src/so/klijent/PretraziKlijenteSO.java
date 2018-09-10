package so.klijent;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class PretraziKlijenteSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaKlijenata;

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaKlijenata = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public List<OpstiDomenskiObjekat> getListaKlijenata() {
        return listaKlijenata;
    }
}
