package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class VratiListuDrzava extends GlavnaSistemskaOperacija {

    public VratiListuDrzava() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
            so.setOdgovor(lista);
            so.setOperacija(Operacija.VRATI_DRZAVE);
            so.setPoruka("Uspesno vraćene države!");
            so.setFleg(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sistem nije mogao da pronađe države!");
            so.setOperacija(Operacija.VRATI_DRZAVE);
            so.setPoruka("Sistem nije mogao da pronađe države!");
            so.setFleg(false);
        }
       return so;
    }
    
}
