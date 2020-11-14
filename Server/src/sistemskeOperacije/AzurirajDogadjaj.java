package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Dogadjaj;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class AzurirajDogadjaj extends GlavnaSistemskaOperacija {

    public AzurirajDogadjaj() {
        super();
    }

    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();       
        try {
            int id = db.getID(dom);
            ((Dogadjaj) dom).setIdDogadjaja(id);
            db.updateObject(dom);
            so.setFleg(true);
            so.setPoruka("Sistem je zapamtio dogadjaj.");
            so.setOperacija(Operacija.IZMENI_DOGADJAJ);  
           
        } catch (Exception e) {
            e.printStackTrace();
            so.setOperacija(Operacija.IZMENI_DOGADJAJ);
            so.setPoruka("Sistem ne moze da zapamti dogadjaj.");
            so.setFleg(false);           
        }       
        return so;
    }
    
}
