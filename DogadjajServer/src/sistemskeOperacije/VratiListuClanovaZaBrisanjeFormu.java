package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class VratiListuClanovaZaBrisanjeFormu extends GlavnaSistemskaOperacija {

    public VratiListuClanovaZaBrisanjeFormu() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
            so.setOdgovor(lista);
            so.setOperacija(Operacija.VRATI_CLANOVE_ZA_BRISANJE_FORMU);
            so.setPoruka("Uspesno vraćeni clanovi!");
            so.setFleg(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sistem nije mogao da pronađe clanovi!");
            so.setOperacija(Operacija.VRATI_CLANOVE_ZA_BRISANJE_FORMU);
            so.setPoruka("Sistem nije mogao da pronađe clanovi!");
            so.setFleg(false);
        }
       return so;
    }
    
}
