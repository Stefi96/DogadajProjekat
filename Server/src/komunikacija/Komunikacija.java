package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class Komunikacija {

    private static Komunikacija instance;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }

        return instance;
    }

    public void posaljiOdgovor(ServerskiOdgovor so, Socket s) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(s.getOutputStream());
            ous.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public KlijentskiZahtev prihvatiZahtev(Socket s) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;

    }

}
