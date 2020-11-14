/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author xMx
 */
public class VratiListuDogadjajaZaFormu extends GlavnaSistemskaOperacija {

    public VratiListuDogadjajaZaFormu() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
         ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
            so.setOdgovor(lista);
            so.setOperacija(Operacija.VRATI_DOGAJAJE_ZA_UNOS_FORMU);
            so.setPoruka("Uspesno vraćeni dogadjaji!");
            so.setFleg(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sistem nije mogao da pronađe dogadjaje!");
            so.setOperacija(Operacija.VRATI_DOGAJAJE_ZA_UNOS_FORMU);
            so.setPoruka("Sistem nije mogao da pronađe dogadjaje!");
            so.setFleg(false);
        }
       return so;
    }
    
}
