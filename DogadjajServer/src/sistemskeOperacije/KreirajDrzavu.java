package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Drzava;
import domen.Dogadjaj;
import java.sql.SQLException;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class KreirajDrzavu extends GlavnaSistemskaOperacija {

    public KreirajDrzavu() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            int id = db.getID(dom);
            ((Drzava) dom).setIdDrzave(id+1);
            db.insertObject(dom);
            
        so.setOperacija(Operacija.DODAJ_DRZAVU);
        so.setPoruka("Sistem je zapamtio drzavu");
        so.setFleg(true);
        }
      catch(SQLException e) {
        e.printStackTrace();
        so.setPoruka("Sistem ne moze da zapamti drzavu");
        so.setFleg(false);
        so.setOperacija(Operacija.DODAJ_DRZAVU);
        }
      return so;
    }
    
}
