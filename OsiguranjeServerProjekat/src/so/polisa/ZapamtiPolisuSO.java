package so.polisa;

import domen.Polisa;
import domen.StavkaPolise;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class ZapamtiPolisuSO extends OpstaSO {

    public ZapamtiPolisuSO(Object obj) {
        super(obj);
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        Polisa p = (Polisa) obj;
        db.sacuvaj(p);
        for (StavkaPolise stavka : p.getListaStavki()) {
            db.sacuvaj(stavka);
        }
    }
    
}
