package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.SettingsLoader;

/**
 *
 * @author Darko
 */
public class Komunikacija {

    private Socket socket;
    private static Komunikacija instance;

    private Komunikacija() throws IOException {
        String ip = SettingsLoader.getInstance().getValue("ip");
        String port = SettingsLoader.getInstance().getValue("port");
        socket = new Socket(ip, Integer.parseInt(port));
    }

    public static Komunikacija getInstance() throws IOException {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void posalji(TransferObjekatZahtev toZahtev) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(toZahtev);
    }

    public TransferObjekatOdgovor procitaj() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (TransferObjekatOdgovor) in.readObject();
    }
    
}
