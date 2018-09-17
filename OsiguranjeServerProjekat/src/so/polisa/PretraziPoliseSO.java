package so.polisa;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class PretraziPoliseSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaPolisa;

    public PretraziPoliseSO(Object obj) {
        super(obj);
    }
    
    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaPolisa = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public List<OpstiDomenskiObjekat> getListaPolisa() {
        return listaPolisa;
    }

}
