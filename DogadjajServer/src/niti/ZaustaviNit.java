package niti;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZaustaviNit extends Thread {

    ServerSocket ss;
    ServerNit sn;
    boolean kraj = false;

    public ZaustaviNit(ServerSocket ss, ServerNit sn) {
        this.ss = ss;
        this.sn = sn;
    }

    @Override
    public void run() {

        while (!kraj) {

            if (sn.isInterrupted()) {
                kraj = true;
                try {
                    ss.close();
                } catch (IOException ex) {
                    Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

}
