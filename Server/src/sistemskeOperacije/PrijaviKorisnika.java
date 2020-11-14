package sistemskeOperacije;

import domen.DomenskiObjekat;
import java.util.List;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class PrijaviKorisnika extends GlavnaSistemskaOperacija {

    public PrijaviKorisnika() {
        super();
    }

    @Override
    protected ServerskiOdgovor commitOperation(DomenskiObjekat dom) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        List<DomenskiObjekat> lista = dom.vratiListuPoRS(db.selectObject(dom));

        try {

            if (!lista.isEmpty()) {

                so.setOperacija(Operacija.LOGIN);
                so.setOdgovor(lista);
                so.setFleg(true);

            } else {

                so.setOperacija(Operacija.LOGIN);
                so.setOdgovor(lista);
                so.setFleg(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;

    }

}
