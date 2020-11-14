/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import java.sql.SQLException;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Joka
 */
public class DodajKorisnika extends GlavnaSistemskaOperacija {

    public DodajKorisnika() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
      try {
            int id = db.getID(dom);
            ((Korisnik) dom).setIdKorisnika(id+1);
            db.insertObject(dom);
            Clan p=((Korisnik)dom).getClan();
            p.setIdClana(id+1);
            db.insertObject(p);
            
        so.setOperacija(Operacija.DODAJ_KORISNIKA);
        so.setPoruka("Sistem je zapamtio korisnika!");
        so.setFleg(true);
       
        }
      catch(SQLException e) {
          e.printStackTrace();
        so.setPoruka("Sistem ne moze da zapamti korisnika!");
        so.setFleg(false);
        so.setOperacija(Operacija.DODAJ_KORISNIKA);
        }
      return so;
    }
    
}
