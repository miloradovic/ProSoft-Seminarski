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
        if (p.getReferentRaskidanje() != null) {
            db.izmeni(p);
        } else {
            int i = db.sacuvaj(p);
            for (StavkaPolise stavka : p.getListaStavki()) {
                stavka.setPolisaId(i);
                db.sacuvaj(stavka);
            }
        }
    }

}
