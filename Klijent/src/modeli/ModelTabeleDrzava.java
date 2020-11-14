package modeli;

import domen.Drzava;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleDrzava extends AbstractTableModel{
    ArrayList<Drzava> listaDrzava;

    public ModelTabeleDrzava(ArrayList<Drzava> listaDrzava) {
        this.listaDrzava = listaDrzava;
    }

    @Override
    public int getRowCount() {
        return listaDrzava.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Drzava d = listaDrzava.get(i);
        switch(i1) {
            case 0: return d.getNaziv();
            case 1: return d.getKontinent();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i) {
            case 0: return "Naziv";
            case 1: return "Kontinent";
            default: return "";
        }
    }

    public boolean daLiPostoji(Drzava drzava) {
        for(Drzava d : listaDrzava) {
            if(d.getNaziv().equals(drzava.getNaziv()) && d.getKontinent().equals(drzava.getKontinent())) {
                return true;
            }
        } 
        return false;
    }
    
}
