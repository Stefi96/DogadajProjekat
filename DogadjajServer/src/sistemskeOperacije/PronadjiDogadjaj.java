package sistemskeOperacije;

import domen.DomenskiObjekat;
import domen.Dogadjaj;
import java.util.ArrayList;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class PronadjiDogadjaj extends GlavnaSistemskaOperacija {

    public PronadjiDogadjaj() {
        super();
    }

    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        Dogadjaj d = (Dogadjaj) dom;
        List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));
        List<DomenskiObjekat> listaPronadjenih = new ArrayList<>();
        
        
        for(DomenskiObjekat domenski : lista){
           if(domenski.equals(dom)){
           listaPronadjenih.add(domenski);
           }
        }
        try {

            if (!listaPronadjenih.isEmpty()) {

                so.setOperacija(Operacija.NADJI_DOGADJAJ);
                so.setOdgovor(listaPronadjenih);
                so.setFleg(true);
                so.setPoruka("Sistem je našao dogadjaje po zadatoj vrednosti!");

            } else {

                so.setOperacija(Operacija.NADJI_DOGADJAJ);
                so.setOdgovor(listaPronadjenih);
                so.setFleg(false);
                so.setPoruka("Dogadjaji nisu pronađeni!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    
}
