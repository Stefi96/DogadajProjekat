package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Dogadjaj;
import domen.Clan;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class AzuriranjeClana extends GlavnaSistemskaOperacija {

    public AzuriranjeClana() {
        super();
    }
      
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();       
        try {
            int id = db.getID(dom);
            ((Clan) dom).setIdClana(id);
             db.updateObject(dom);
            so.setFleg(true);
            so.setPoruka("Uspešna izmena clana!");
            so.setOperacija(Operacija.IZMENI_CLANA);            
        } catch (Exception e) {
            e.printStackTrace();
            so.setOperacija(Operacija.IZMENI_CLANA);
            so.setPoruka("Neuspešna izmena clana!");
            so.setFleg(false);           
        }       
        return so;
    }
    
}
