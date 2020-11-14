package sistemskeOperacije;

import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Korisnik;
import domen.Dogadjaj;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class ObrisiDogadjaj extends GlavnaSistemskaOperacija {

    public ObrisiDogadjaj() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {

            db.deleteObject(dom); 
            Dogadjaj p = (Dogadjaj) dom;

        for(Prijava a : p.getListaPrijava()) {
            db.deleteObject(a);
            db.updateObject(a.getClan());
        }
            
            so.setOperacija(Operacija.OBRISI_DOGADJAJ);
            so.setPoruka("Sistem je obrisao dogadjaj");          
            so.setFleg(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Sistem ne moze da obrise dogadjaj");
        }

        return so;
    }
}
    
