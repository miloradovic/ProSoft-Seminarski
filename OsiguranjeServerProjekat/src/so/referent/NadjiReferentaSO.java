package so.referent;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class NadjiReferentaSO extends OpstaSO {
    
    List<OpstiDomenskiObjekat> referent;

    public NadjiReferentaSO(Object obj) {
        super(obj);
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        referent = db.pretrazi((OpstiDomenskiObjekat) obj);
    }
    
    public OpstiDomenskiObjekat getReferenta() {
        if (referent.isEmpty()) {
            return null;
        }
        return referent.get(0);
    }
}
