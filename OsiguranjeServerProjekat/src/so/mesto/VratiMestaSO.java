package so.mesto;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class VratiMestaSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaMesta;

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaMesta = db.pretrazi((OpstiDomenskiObjekat) obj);
    }

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }
}
