package kontroler;

import db.DbKomunikacija;
import domen.OpstiDomenskiObjekat;
import domen.Referent;
import java.util.List;
import so.OpstaSO;
import so.mesto.VratiMestaSO;

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
        vratiMestaSO.izvrsenjeSO();
        return ((VratiMestaSO) vratiMestaSO).getListaMesta();
    }
    
    public Referent nadjiReferenta(Referent login) throws Exception {
        db.ucitajDriver();
        db.otvoriKonekciju();
        Referent r = db.nadjiReferenta(login);
        db.zatvoriKonekciju();
        return r;
    }
}
