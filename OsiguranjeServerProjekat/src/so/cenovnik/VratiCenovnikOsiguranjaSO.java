package so.cenovnik;

import domen.CenovnikOsiguranja;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class VratiCenovnikOsiguranjaSO extends OpstaSO {

    List<OpstiDomenskiObjekat> listaCenovnik;

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        listaCenovnik = db.pretrazi(new CenovnikOsiguranja());
    }

    public List<OpstiDomenskiObjekat> getCenovnik() {
        return listaCenovnik;
    }
}
