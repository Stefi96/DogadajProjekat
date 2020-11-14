package sistemskeOperacije;

import domen.DomenskiObjekat;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class PromeniLozinku extends GlavnaSistemskaOperacija{

    public PromeniLozinku() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
         ServerskiOdgovor so = new ServerskiOdgovor();       
        try {
            db.updateObject(dom);
            so.setFleg(true);
            so.setPoruka("Sistem je promenio lozinku");
            so.setOperacija(Operacija.PROMENA_LOZINKE);
           
        } catch (Exception e) {
            e.printStackTrace();
            so.setOperacija(Operacija.PROMENA_LOZINKE);
            so.setPoruka("Sistem ne moze da promeni lozinku");
            so.setFleg(false);           
        }       
        return so;
    }
    
}
