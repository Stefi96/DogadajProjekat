package sistemskeOperacije;

import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Dogadjaj;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class ObrisiPrijavu extends GlavnaSistemskaOperacija{

    public ObrisiPrijavu() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {

            db.deleteObject(dom);
            db.updateObject(((Prijava)dom).getClan());
            db.updateObject(((Prijava)dom).getDogadaj());
            Prijava ap = (Prijava) dom;
            so.setPoruka("Sistem je obrisao prijavu");
            so.setFleg(true);
            so.setOperacija(Operacija.OBRISI_PRIJAVU);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Sistem ne moze da obrise prijavu");
        }

        return so;
    }
    
}
