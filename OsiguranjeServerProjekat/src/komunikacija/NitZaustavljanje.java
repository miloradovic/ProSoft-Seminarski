package komunikacija;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;

/**
 *
 * @author Darko
 */
public class NitZaustavljanje extends Thread {

    private ServerSocket ss;
    private Server s;
    private boolean kraj = false;

    public NitZaustavljanje(ServerSocket ss, Server s) {
        this.ss = ss;
        this.s = s;
    }

    @Override
    public void run() {
        while (!kraj) {
            if (s.isInterrupted()) {
                try {
                    ss.close();
                    kraj = true;
                } catch (IOException ex) {
                    System.out.println("Greska prilikom zatvaranja soketa: " + ex);
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("Greska: " + ex);
            }
        }
    }

}
