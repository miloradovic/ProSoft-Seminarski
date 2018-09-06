package kontroler;

import db.DbKomunikacija;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;
import so.klijent.KreirajNovogKlijentaSO;
import so.klijent.ZapamtiKlijentaSO;
import so.mesto.VratiMestaSO;
import so.referent.NadjiReferentaSO;

/**
 *
 * @author Darko
 */
public class Kontroler {

    private static Kontroler instance;

    private final DbKomunikacija db = new DbKomunikacija();

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
    
    public OpstiDomenskiObjekat nadjiReferenta(OpstiDomenskiObjekat login) throws Exception {
        OpstaSO nadjiReferentaSO = new NadjiReferentaSO(login);
        nadjiReferentaSO.izvrsenjeSO();
        return ((NadjiReferentaSO) nadjiReferentaSO).getReferenta();        
    }

    public int kreirajNovogKlijenta() throws Exception {
        OpstaSO kreirajNovogKlijenta = new KreirajNovogKlijentaSO();
        kreirajNovogKlijenta.izvrsenjeSO();
        return ((KreirajNovogKlijentaSO) kreirajNovogKlijenta).getNovogKlijenta();
    }

    public void zapamtiKlijenta(Klijent k) throws Exception {
        OpstaSO zapamtiKlijenta = new ZapamtiKlijentaSO(k);
        zapamtiKlijenta.izvrsenjeSO();
    }
}
