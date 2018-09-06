package komunikacija;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Darko
 */
public class Server extends Thread {

    public Server() {
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            while (true) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao");
                NitKlijent nit = new NitKlijent(socket);
                nit.start();
            }
        } catch (IOException ex) {
            System.out.println("Greska: " + ex);
        }
    }
    
    
}
