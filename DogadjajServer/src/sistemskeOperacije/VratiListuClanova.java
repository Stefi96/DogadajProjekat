package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class VratiListuClanova extends GlavnaSistemskaOperacija {

    public VratiListuClanova() {
        super();
    }

    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
            so.setOdgovor(lista);
            so.setOperacija(Operacija.VRATI_CLANOVE);
            so.setPoruka("Uspešno vraćeni clanovi!");
            so.setFleg(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sistem nije mogao da pronađe clanove!");
            so.setOperacija(Operacija.VRATI_CLANOVE);
            so.setPoruka("Sistem nije mogao da pronađe clanove!");
            so.setFleg(false);
        }
       return so;
    }
    
}
