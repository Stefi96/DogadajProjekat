package sistemskeOperacije;

import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class ObrisiClana extends GlavnaSistemskaOperacija {

    public ObrisiClana() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            Korisnik k = (Korisnik) dom;
            for(Prijava p : k.getClan().getListaPrijava()) {
                db.deleteObject(p);
                db.updateObject(p.getDogadaj());
            }     
            db.deleteObject(k.getClan());
            db.deleteObject(dom);
        
            
            so.setOperacija(Operacija.OBRISI_CLANA);
            so.setPoruka("Sistem je obrisao clana");          
            so.setFleg(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Sistem ne moze da obrise clana");
        }

        return so;
    }
}
    

