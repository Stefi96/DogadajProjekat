package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Dogadjaj;
import domen.Clan;
import java.util.ArrayList;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class PronadjiClana extends GlavnaSistemskaOperacija {

    public PronadjiClana() {
        super();
    }

    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Clan c = (Clan) dom;
        List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
        List<DomenskiObjekat> listaPronadjenih = new ArrayList<>();
        
        
        for(DomenskiObjekat domenski : lista){
           if(domenski.equals(dom)){
           listaPronadjenih.add(domenski);
           }
        }
        try {

            if (!listaPronadjenih.isEmpty()) {

                so.setOperacija(Operacija.NADJI_CLANA);
                so.setOdgovor(listaPronadjenih);
                so.setFleg(true);
                so.setPoruka("Sistem je našao clana po zadatoj vrednosti!");

            } else {

                so.setOperacija(Operacija.NADJI_CLANA);
                so.setOdgovor(listaPronadjenih);
                so.setFleg(false);
                so.setPoruka("Clanovi nisu pronađeni!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    
}
