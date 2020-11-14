package modeli;

import domen.Prijava;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelePrijava extends AbstractTableModel {
    ArrayList<Prijava> listaPrijava;

    public ModelTabelePrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
    @Override
    public int getRowCount() {
        return listaPrijava.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Prijava a = listaPrijava.get(i);
        switch(i1) {
            case 0: 
                if(a.getClan().getIme() == null || a.getClan().getPrezime() == null){
                    return "";
                }
                return a.getClan().getIme()+" "+a.getClan().getPrezime();
            case 1:
                if(a.getDogadaj().getNaziv() == null){
                    return "";
                }
                return a.getDogadaj().getNaziv();
            case 2: 
                if(a.getMotivaciono() == null)
                    return "";
                return a.getMotivaciono();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i) {
            case 0: return "Clan";
            case 1: return "Dogadjaj";
            case 2: return "Motivaciono pismo";
            default: return "";
        }
    }  

    public Prijava vratiRed(int red) {
        return listaPrijava.get(red);
    }

    public ArrayList<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
}
