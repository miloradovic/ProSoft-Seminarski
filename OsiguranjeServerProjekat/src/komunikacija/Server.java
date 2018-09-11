package komunikacija;

import forme.FrmGlavna;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Darko
 */
public class Server extends Thread {

    FrmGlavna forma;

    public Server(FrmGlavna forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            forma.serverPokrenut();
            System.out.println("Server je pokrenut");
            NitZaustavljanje nz = new NitZaustavljanje(ss, this);
            nz.start();
            while (!isInterrupted()) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao");
                NitKlijent nit = new NitKlijent(socket);
                nit.start();
            }
        } catch (IOException ex) {
            System.out.println("Zaustavljen server.");
            forma.serverNijePokrenut();
        }
    }

}
