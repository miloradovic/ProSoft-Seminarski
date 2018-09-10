package kontroler;

import db.DbKomunikacija;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.Vozilo;
import java.util.List;
import so.OpstaSO;
import so.klijent.KreirajNovogKlijentaSO;
import so.klijent.VratiKlijenteSO;
import so.klijent.ZapamtiKlijentaSO;
import so.mesto.VratiMestaSO;
import so.referent.NadjiReferentaSO;
import so.vozilo.VratiVozilaSO;

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

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new VratiMestaSO();
        vratiMestaSO.izvrsenjeSO();
        return ((VratiMestaSO) vratiMestaSO).getListaMesta();
    }

    public List<OpstiDomenskiObjekat> vratiKlijente() throws Exception {
        OpstaSO vratiKlijenteSO = new VratiKlijenteSO();
        vratiKlijenteSO.izvrsenjeSO();
        return ((VratiKlijenteSO) vratiKlijenteSO).getListaKlijenata();
    }

    public List<OpstiDomenskiObjekat> vratiCenovnik() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<OpstiDomenskiObjekat> vratiVozila() throws Exception {
        OpstaSO vratiVozilaSO = new VratiVozilaSO(new Vozilo());
        vratiVozilaSO.izvrsenjeSO();
        return ((VratiVozilaSO) vratiVozilaSO).getListaVozila();
    }

    public OpstiDomenskiObjekat pretraziKlijente(Klijent klijent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void obrisiKlijenta(Klijent klijent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Klijent ucitajKlijenta(Klijent klijent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OpstiDomenskiObjekat pretraziVozila(Vozilo v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OpstiDomenskiObjekat ucitajVozilo(Vozilo vozilo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
