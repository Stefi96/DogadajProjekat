package modeli;

import domen.Dogadjaj;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleDogadjaj extends AbstractTableModel {
    
    ArrayList<Dogadjaj> listaDogadjaja = new ArrayList<>();

    public ModelTabeleDogadjaj(ArrayList<Dogadjaj> listaDogadjaja) {
        this.listaDogadjaja = listaDogadjaja;
    }
   
    
    @Override
    public int getRowCount() {
        return listaDogadjaja.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Dogadjaj p = listaDogadjaja.get(i);
        switch(i1) {
            case 0: return p.getNaziv();
            case 1: return p.getBrojPrijava();
            case 2: return p.getDatumPocetka();
            case 3: return p.getDatumZavrsetka();
            case 4: return p.getDrzava().getNaziv();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
         switch(i) {
            case 0: return "Naziv";
            case 1: return "Broj prijava";
            case 2: return "Datum početka";
            case 3: return "Datum završetka";
            case 4: return "Država";
            default: return "";
        }
    }

    public Dogadjaj vratiRed(int red) {
        return listaDogadjaja.get(red);
    }

    public void izmeniDogadjaj(Dogadjaj p, int red) {
        Dogadjaj dog = (Dogadjaj) listaDogadjaja.get(red);
        dog.setDatumPocetka(p.getDatumPocetka());
        dog.setDatumZavrsetka(p.getDatumZavrsetka());
        dog.setDrzava(p.getDrzava());
        dog.setNaziv(p.getNaziv());
        fireTableDataChanged();
    }

    public Dogadjaj dajSelektovanu(int red) {
        return listaDogadjaja.get(red);
    }

    public boolean daLiPostoji(Dogadjaj p) {
        for(Dogadjaj pr : listaDogadjaja) {
            if(pr.getNaziv().equals(p.getNaziv()) && pr.getDatumPocetka().equals(p.getDatumPocetka())
                    && pr.getDatumZavrsetka().equals(p.getDatumZavrsetka()) && pr.getDrzava().equals(p.getDrzava())) {
                return true;
            }
        }
        return false;
    }
}
