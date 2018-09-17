package kontroler;

import domen.CenovnikOsiguranja;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import domen.Referent;
import java.io.IOException;
import java.util.List;
import komunikacija.Komunikacija;
import transfer.Operacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Darko
 */
public class Kontroler {

    private static Kontroler instance;
    private TransferObjekatZahtev toZahtev;
    private TransferObjekatOdgovor toOdgovor;

    private Kontroler() {
        toZahtev = new TransferObjekatZahtev();
        toOdgovor = new TransferObjekatOdgovor();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Referent nadjiReferenta(Referent r) throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.NADJI_REFERENTA);
        toZahtev.setParametar((OpstiDomenskiObjekat) r);
        Komunikacija.getInstance().posalji(toZahtev);
        toOdgovor = Komunikacija.getInstance().procitaj();

        return (Referent) toOdgovor.getRezultat();
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.VRATI_MESTA);
        Komunikacija.getInstance().posalji(toZahtev);
        toOdgovor = Komunikacija.getInstance().procitaj();
        return (List<OpstiDomenskiObjekat>) toOdgovor.getRezultat();
    }

    public List vratiKlijente() throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.VRATI_KLIJENTE);
        Komunikacija.getInstance().posalji(toZahtev);

        toOdgovor = Komunikacija.getInstance().procitaj();
        return (List) toOdgovor.getRezultat();
    }

    public TransferObjekatOdgovor zapamtiKlijenta(Klijent k) throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.ZAPAMTI_KLIJENTA);
        toZahtev.setParametar(k);
        Komunikacija.getInstance().posalji(toZahtev);
        return Komunikacija.getInstance().procitaj();
    }

    public List vratiVozila() throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.VRATI_VOZILA);
        Komunikacija.getInstance().posalji(toZahtev);

        toOdgovor = Komunikacija.getInstance().procitaj();
        return (List) toOdgovor.getRezultat();
    }

    public List<CenovnikOsiguranja> vratiCenovnik() throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.VRATI_CENOVNIK);
        Komunikacija.getInstance().posalji(toZahtev);
        toOdgovor = Komunikacija.getInstance().procitaj();
        return (List<CenovnikOsiguranja>) toOdgovor.getRezultat();
    }

    public TransferObjekatOdgovor zapamtiPolisu(Polisa p) throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.ZAPAMTI_POLISU);
        toZahtev.setParametar(p);

        Komunikacija.getInstance().posalji(toZahtev);
        return Komunikacija.getInstance().procitaj();
    }

    public List<Polisa> pretraziPolise() throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.PRETRAZI_POLISE);
        toZahtev.setParametar(new Polisa());
        Komunikacija.getInstance().posalji(toZahtev);
        toOdgovor = Komunikacija.getInstance().procitaj();

        return (List<Polisa>) toOdgovor.getRezultat();
    }

    public TransferObjekatOdgovor obrisiKlijenta(Klijent k) throws IOException, ClassNotFoundException {
        toZahtev.setOperacija(Operacija.OBRISI_KLIJENTA);
        toZahtev.setParametar(k);
        Komunikacija.getInstance().posalji(toZahtev);
        return Komunikacija.getInstance().procitaj();
    }
}
