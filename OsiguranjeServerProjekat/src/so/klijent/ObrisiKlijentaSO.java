package so.klijent;

import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class ObrisiKlijentaSO extends OpstaSO {

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        db.obrisi((OpstiDomenskiObjekat) obj);
    }

}
