package so.klijent;

import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class ObrisiKlijentaSO extends OpstaSO {

    public ObrisiKlijentaSO(Object obj) {
        super(obj);
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        db.obrisi((OpstiDomenskiObjekat) obj);
    }

}
