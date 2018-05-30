package so.referent;

import domen.OpstiDomenskiObjekat;
import domen.Referent;
import so.OpstaSO;

/**
 *
 * @author Darko
 */
public class NadjiReferentaSO extends OpstaSO {
    
    OpstiDomenskiObjekat referent;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {        
    }

    @Override
    protected void izvrsiOperaciju(Object obj) throws Exception {
        // referent = (OpstiDomenskiObjekat) db.nadjiReferenta((Referent) obj);
    }
    
    public OpstiDomenskiObjekat getReferenta() {
        return referent;
    }
}
