package komunikacija;

import domen.Klijent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import kontroler.Kontroler;
import transfer.Operacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import domen.Vozilo;

/**
 *
 * @author Darko
 */
public class NitKlijent extends Thread {

    private Socket socket;
    private boolean aktivan;

    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivan = true;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (IOException | ClassNotFoundException ex) {
            aktivan = false;
        }
        System.out.println("NitKlijent - kraj rada.");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivan) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            System.out.println("Operacija: " + toZahtev.getOperacija());
            try {
                switch (toZahtev.getOperacija()) {
                    case Operacija.NADJI_REFERENTA:
                        OpstiDomenskiObjekat r = Kontroler.getInstance().nadjiReferenta((OpstiDomenskiObjekat) toZahtev.getParametar());
                        toOdgovor.setRezultat(r);
                        break;
                    case Operacija.KREIRAJ_NOVOG_KLIJENTA:
                        int i = Kontroler.getInstance().kreirajNovogKlijenta();
                        toOdgovor.setRezultat(i);
                        break;
                    case Operacija.ZAPAMTI_KLIJENTA:
                        Klijent k = (Klijent) toZahtev.getParametar();
                        Kontroler.getInstance().zapamtiKlijenta(k);
                        toOdgovor.setPoruka("Ok");
                        break;
                    case Operacija.PRETRAZI_KLIJENTE:
                        Klijent klijent = (Klijent) toZahtev.getParametar();
                        OpstiDomenskiObjekat odo = Kontroler.getInstance().pretraziKlijente(klijent);
                        toOdgovor.setRezultat(odo);
                        break;
                    case Operacija.UCITAJ_KLIJENTA:
                        Klijent klijentUcitaj = Kontroler.getInstance().ucitajKlijenta((Klijent) toZahtev.getParametar());
                        toOdgovor.setRezultat(klijentUcitaj);
                        break;
                    case Operacija.OBRISI_KLIJENTA:
                        Kontroler.getInstance().obrisiKlijenta((Klijent) toZahtev.getParametar());
                        toOdgovor.setPoruka("Klijent je obrisan.");
                        break;
                    case Operacija.PRETRAZI_VOZILA:
                        Vozilo v = (Vozilo) toZahtev.getParametar();
                        OpstiDomenskiObjekat odoVozilo = Kontroler.getInstance().pretraziVozila(v);
                        toOdgovor.setRezultat(odoVozilo);
                        break;
                    case Operacija.UCITAJ_VOZILO:
                        Vozilo vozilo = (Vozilo) toZahtev.getParametar();
                        OpstiDomenskiObjekat odoUcitaj = Kontroler.getInstance().ucitajVozilo(vozilo);
                        break;
                    case Operacija.KREIRAJ_NOVU_POLISU:
                        int j = Kontroler.getInstance().kreirajNovuPolisu();
                        toOdgovor.setRezultat(j);
                        break;
                    case Operacija.ZAPAMTI_POLISU:
                        Polisa p = (Polisa) toZahtev.getParametar();
                        Kontroler.getInstance().zapamtiPolisu(p);
                        toOdgovor.setPoruka("Polisa je sacuvana.");
                        break;
                    case Operacija.PRETRAZI_POLISE:
                        break;
                    case Operacija.UCITAJ_POLISU:
                        break;
                    case Operacija.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> lm = Kontroler.getInstance().vratiMesta();
                        toOdgovor.setRezultat(lm);
                        toOdgovor.setPoruka("Ucitana su mesta");
                        break;
                    case Operacija.VRATI_KLIJENTE:
                        List<OpstiDomenskiObjekat> lk = Kontroler.getInstance().vratiKlijente();
                        toOdgovor.setRezultat(lk);
                        break;
                    case Operacija.VRATI_CENOVNIK:
                        List<OpstiDomenskiObjekat> lc = Kontroler.getInstance().vratiCenovnik();
                        toOdgovor.setRezultat(lc);
                        break;
                    case Operacija.VRATI_VOZILA:
                        List<OpstiDomenskiObjekat> lv = Kontroler.getInstance().vratiVozila();
                        toOdgovor.setRezultat(lv);
                        break;
                }
            } catch (Exception ex) {
                toOdgovor.setIzuzetak(ex);
                toOdgovor.setPoruka(ex.getMessage());
            }
            posalji(toOdgovor);
        }
    }

    private void posalji(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }
}
