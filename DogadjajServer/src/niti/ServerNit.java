package niti;

import forme.FormaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Komunikacija;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class ServerNit extends Thread {

    ServerSocket ss;
    FormaServer fs;
    public static List<KlijentNit> klijenti;
    private static int port = 9000;

    public ServerNit(FormaServer fs) {
        klijenti = new ArrayList<KlijentNit>();
        this.fs = fs;
    }

    public static void proveriPort(int port) throws IOException {

        try {
            ServerSocket so = new ServerSocket(port);
            ServerNit.port = port;
            so.close();

        } catch (IOException e) {
            throw new IOException("Port nije slobodan");
        }

    }

    @Override
    public void run() {
        try {

            ss = new ServerSocket(port);
            fs.pokreniServer();
            System.out.println("Server je pokrenut");
            ZaustaviNit zn = new ZaustaviNit(ss, this);
            zn.start();

            while (!isInterrupted()) {
                Socket s = ss.accept();
                System.out.println("Klijent se povezao");
                KlijentNit kn = new KlijentNit(s, this);
                klijenti.add(kn);
                kn.start();

            }

        } catch (IOException e) {
            System.out.println("Server je prekinut");

            interrupt();
            fs.ugasiServer();

            if (!klijenti.isEmpty()) {

                ServerskiOdgovor so = new ServerskiOdgovor();
               // so.setOperacija(Operacija.ODJAVA_SERVERA);
                so.setPoruka("Ugasen je server");
                for (KlijentNit klijentNit : klijenti) {

                    Komunikacija.getInstance().posaljiOdgovor(so, klijentNit.getS());
                    klijentNit.interrupt();

                }

            }

        }
    }

    void odjava(KlijentNit aThis) {

        try {
            klijenti.remove(aThis);
            aThis.interrupt();
            System.out.println("Korisnik se odjavio");
        } catch (Exception e) {
        }

    }

}
