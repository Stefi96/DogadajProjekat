package sistemskeOperacije;

import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Dogadjaj;
import java.sql.SQLException;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class KreirajPrijavu extends GlavnaSistemskaOperacija {

    public KreirajPrijavu() {
        super();
    }

    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
      try {
        
        int id = db.getID(dom);
        ((Prijava) dom).setIdPrijave(id+1);
        db.insertObject(dom);
        db.updateObject(((Prijava)dom).getClan());
        db.updateObject(((Prijava)dom).getDogadaj());
        
        ((Prijava)dom).setIdPrijave(id);
        so.setOperacija(Operacija.DODAJ_PRIJAVU);
        so.setPoruka("Sistem je zapamtio prijavu.");
        so.setFleg(true);
        
        }
      catch(SQLException e) {
        e.printStackTrace();
        so.setPoruka("Sistem ne moze da zapamti prijavu");
        so.setFleg(false);
        so.setOperacija(Operacija.DODAJ_PRIJAVU);
        }
      return so;
    }
    
}
