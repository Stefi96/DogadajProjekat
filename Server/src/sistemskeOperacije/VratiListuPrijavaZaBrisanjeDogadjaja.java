package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class VratiListuPrijavaZaBrisanjeDogadjaja extends GlavnaSistemskaOperacija{

    public VratiListuPrijavaZaBrisanjeDogadjaja() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
            so.setOdgovor(lista);
            so.setOperacija(Operacija.VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA);
            so.setPoruka("Uspešno vraćene prijave!");
            so.setFleg(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sistem nije mogao da pronađe prijave!");
            so.setOperacija(Operacija.VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA);
            so.setFleg(false);
        }
       return so;
    }
    
}
