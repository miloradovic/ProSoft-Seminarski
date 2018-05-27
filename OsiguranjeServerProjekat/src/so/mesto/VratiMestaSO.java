package so.mesto;

import domen.Mesto;
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
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaMesta = db.vratiSve(new Mesto());
    }

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }
}
