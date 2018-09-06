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
                    case Operacija.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> lm = Kontroler.getInstance().vratiMesta();
                        toOdgovor.setRezultat(lm);
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
                        break;
                    case Operacija.UCITAJ_KLIJENTA:
                        break;
                    case Operacija.OBRISI_KLIJENTA:
                        break;
                    case Operacija.PRETRAZI_VOZILA:
                        break;
                    case Operacija.UCITAJ_VOZILO:
                        break;
                    case Operacija.KREIRAJ_NOVU_POLISU:
                        break;
                    case Operacija.ZAPAMTI_POLISU:
                        break;
                    case Operacija.PRETRAZI_POLISE:
                        break;
                    case Operacija.UCITAJ_POLISU:
                        break;
                    case Operacija.VRATI_KLIJENTE:
                        break;
                    case Operacija.VRATI_CENOVNIK:
                        break;
                    case Operacija.VRATI_VOZILA:
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
