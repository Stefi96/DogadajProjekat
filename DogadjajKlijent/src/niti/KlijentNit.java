package niti;

import forme.FormaStart;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

public class KlijentNit extends Thread{

    private int port;
    private String adresa;
    private Socket s;
    private FormaStart fs;

    public KlijentNit(int port, String adresa, FormaStart fs) {
        this.port = port;
        this.adresa = adresa;
        this.fs = fs;
    }

    @Override
    public void run() {
        try {
            s=new Socket(adresa, port);
            KomunikacijaSaServerom.getInstanca().setS(s);
            System.out.println("Klijent se povezao na server");
            fs.pokreniLogIn();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unesite ispravno podatke");
            return;
        }
    }

    
    
    
    public FormaStart getFs() {
        return fs;
    }

    public void setFs(FormaStart fs) {
        this.fs = fs;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
    
     public boolean konektovan() {
        return s.isConnected();
    }
    

}
