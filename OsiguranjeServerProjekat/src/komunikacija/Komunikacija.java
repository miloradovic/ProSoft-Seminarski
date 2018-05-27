package komunikacija;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Darko
 */
public class Komunikacija {

    List<NitKlijent> klijenti = new LinkedList<>();

    public void pokreniServer() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut");
        while (true) {
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao");
            NitKlijent nit = new NitKlijent(socket);
            nit.start();
            klijenti.add(nit);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Komunikacija k = new Komunikacija();
        k.pokreniServer();        
    }
}
