package so.klijent;

import domen.Klijent;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class ZapamtiKlijentaSO extends OpstaSO {

    public ZapamtiKlijentaSO(Object obj) {
        super(obj);
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        Klijent k = (Klijent) obj;
        if (k.getKlijentId() > 0) {
            db.izmeni(k);
        } else {
            db.sacuvaj(k);
        }
    }

}
