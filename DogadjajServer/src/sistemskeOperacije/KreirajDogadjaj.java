package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import java.sql.SQLException;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class KreirajDogadjaj extends GlavnaSistemskaOperacija {

    public KreirajDogadjaj() {
        super();
    }

    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            int id = db.getID(dom);
            ((Dogadjaj) dom).setIdDogadjaja(id+1);
            db.insertObject(dom);
            
        so.setOperacija(Operacija.DODAJ_DOGADJAJ);
        so.setPoruka("Sistem je zapamtio dogadjaj.");
        so.setFleg(true);
      
        }
      catch(SQLException e) {
          e.printStackTrace();
        so.setPoruka("Sistem ne moze da zapamti dogadjaj.");
        so.setFleg(false);
        so.setOperacija(Operacija.DODAJ_DOGADJAJ);
        }
      return so;
    }
    
}
