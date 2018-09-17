package kontroler;

import db.DbKomunikacija;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import domen.Vozilo;
import java.util.List;
import so.OpstaSO;
import so.cenovnik.VratiCenovnikOsiguranjaSO;
import so.klijent.ObrisiKlijentaSO;
import so.klijent.VratiKlijenteSO;
import so.klijent.ZapamtiKlijentaSO;
import so.mesto.VratiMestaSO;
import so.polisa.PretraziPoliseSO;
import so.polisa.ZapamtiPolisuSO;
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

    public List<OpstiDomenskiObjekat> vratiCenovnik() throws Exception {
        OpstaSO vratiCenovnikSO = new VratiCenovnikOsiguranjaSO();
        vratiCenovnikSO.izvrsenjeSO();
        return ((VratiCenovnikOsiguranjaSO) vratiCenovnikSO).getCenovnik();
    }

    public List<OpstiDomenskiObjekat> vratiVozila() throws Exception {
        OpstaSO vratiVozilaSO = new VratiVozilaSO(new Vozilo());
        vratiVozilaSO.izvrsenjeSO();
        return ((VratiVozilaSO) vratiVozilaSO).getListaVozila();
    }

    public OpstiDomenskiObjekat pretraziKlijente(Klijent klijent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void obrisiKlijenta(Klijent klijent) throws Exception {
        OpstaSO obrisiKlijentaSO = new ObrisiKlijentaSO(klijent);
        obrisiKlijentaSO.izvrsenjeSO();
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

    public void zapamtiPolisu(Polisa p) throws Exception {
        OpstaSO zapamtiPolisuSO = new ZapamtiPolisuSO(p);
        zapamtiPolisuSO.izvrsenjeSO();
    }

    public List<OpstiDomenskiObjekat> pretraziPolise(Polisa p) throws Exception {
        OpstaSO pretraziPoliseSO = new PretraziPoliseSO(p);
        pretraziPoliseSO.izvrsenjeSO();
        return ((PretraziPoliseSO) pretraziPoliseSO).getListaPolisa();
    }
}
