package komunikacija;

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
import domen.Referent;

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
            try {
                switch (toZahtev.getOperacija()) {
                    case Operacija.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> lm = Kontroler.getInstance().vratiMesta();                        
                        toOdgovor.setRezultat(lm);
                        break;
                    case Operacija.NADJI_REFERENTA:
                        OpstiDomenskiObjekat r = Kontroler.getInstance().nadjiReferenta((OpstiDomenskiObjekat) toZahtev);
                        toOdgovor.setRezultat(r);
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
