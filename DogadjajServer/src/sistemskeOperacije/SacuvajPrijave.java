package sistemskeOperacije;

import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Clan;
import java.sql.SQLException;
import java.util.ArrayList;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class SacuvajPrijave extends GlavnaSistemskaOperacija{

    public SacuvajPrijave() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
         ServerskiOdgovor so = new ServerskiOdgovor();
      try {         
        int id = db.getID(dom);
       
        Clan c = (Clan) dom;
        for(Prijava p : c.getListaPrijava()) {
            if(p.getStatus().equals("D")) {
            db.deleteObject(p);
            db.updateObject(p.getClan());
            db.updateObject(p.getDogadaj());
            }
            if(p.getStatus().equals("U")) {
            p.setIdPrijave(db.getID(p)+1);
            db.insertObject(p);
            db.updateObject(p.getClan());
            db.updateObject(p.getDogadaj());
            }
        }
        
        so.setOperacija(Operacija.SACUVAJ_SVE);
        so.setPoruka("Sistem je zapamtio izmene");
        so.setFleg(true);
        
        }
      catch(SQLException e) {
        e.printStackTrace();
        so.setPoruka("Sistem ne moze da zapamti izmene");
        so.setFleg(false);
        so.setOperacija(Operacija.SACUVAJ_SVE);
        }
      return so;
    }
    
}
