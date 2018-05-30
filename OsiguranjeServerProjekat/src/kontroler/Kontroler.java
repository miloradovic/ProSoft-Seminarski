package kontroler;

import db.DbKomunikacija;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;
import so.mesto.VratiMestaSO;
import so.referent.NadjiReferentaSO;

/**
 *
 * @author Darko
 */
public class Kontroler {

    private static Kontroler instance;

    private DbKomunikacija db = new DbKomunikacija();

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new VratiMestaSO();
        vratiMestaSO.opsteIzvrsenjeSO();
        return ((VratiMestaSO) vratiMestaSO).getListaMesta();
    }
    
    public OpstiDomenskiObjekat nadjiReferenta(OpstiDomenskiObjekat login) throws Exception {
        OpstaSO nadjiReferentaSO = new NadjiReferentaSO();
        nadjiReferentaSO.opsteIzvrsenjeSO();
        return ((NadjiReferentaSO) nadjiReferentaSO).getReferenta();        
    }
    
    // TODO
    // vratiKlijenta
    // sacuvajKlijenta
    // izbrisiKlijenta
    // vratiVozila
    // sacuvajPolisu
    // itd.
}
