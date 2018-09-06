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
        db.sacuvaj((Klijent) obj);
    }
    
}
