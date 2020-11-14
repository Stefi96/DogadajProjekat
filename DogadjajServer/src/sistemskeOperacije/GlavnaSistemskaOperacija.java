package sistemskeOperacije;

import db.DBBroker;
import domen.DomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

public abstract class GlavnaSistemskaOperacija {

    public DBBroker db;
 
    public GlavnaSistemskaOperacija() {
        db=new DBBroker();
    }
    

    public ServerskiOdgovor procesTransakcije(DomenskiObjekat dom) {

        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            db.loadDrive();
            db.openConnection();
            so = commitOperation(dom);
            db.commit();

        } catch (Exception ex) {
            Logger.getLogger(GlavnaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
            db.rollback();
            so.setFleg(false);
            so.setPoruka(ex.getMessage());
        } finally {
            db.closeConnection();

        }

        return so;
    }

    protected abstract ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception;

}
