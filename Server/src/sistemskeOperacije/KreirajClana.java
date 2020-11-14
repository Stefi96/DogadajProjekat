package sistemskeOperacije;

import domen.Clan;
import domen.DomenskiObjekat;
import domen.Korisnik;
import java.sql.SQLException;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class KreirajClana extends GlavnaSistemskaOperacija {

    public KreirajClana() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            int id = db.getID(new Korisnik());
            ((Clan) dom).setIdClana(id+1);
            db.insertObject(dom);
            
            so.setOperacija(Operacija.DODAJ_CLANA);
            so.setPoruka("SIstem je zapamtio clana!");
            so.setFleg(true);
            
        } catch (SQLException e) {
            e.printStackTrace();
            so.setPoruka("Sistem ne moze da zapamti clana!");
            so.setFleg(false);
            so.setOperacija(Operacija.DODAJ_CLANA);
        }
        return so;
    }
    
}
