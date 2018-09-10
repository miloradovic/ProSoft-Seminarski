package so.klijent;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class VratiKlijenteSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaKlijenata;
    
    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaKlijenata = db.pretrazi(new Klijent());
    }
    
    public List<OpstiDomenskiObjekat> getListaKlijenata() {
        return listaKlijenata;
    }
}
