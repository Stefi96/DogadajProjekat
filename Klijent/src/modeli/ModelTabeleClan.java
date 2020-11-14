package modeli;

import domen.Clan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleClan extends AbstractTableModel {

    ArrayList<Clan> listaClanova;

    public ModelTabeleClan(ArrayList<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }
        
    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Clan p = listaClanova.get(i);
        switch(i1) {
            case 0: return p.getIme() == null ? "" : p.getIme();
            case 1: return p.getPrezime() == null ? "" : p.getPrezime();
            case 2: return p.getStatus() == null ? "" : p.getStatus();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i) {
            case 0: return "Ime";
            case 1: return "Prezime";
            case 2: return "Status";
            default: return "";
        }
    }

    public Clan vratiSelektovanog(int red) {
        return listaClanova.get(red);
    }

    public Clan vratiRed(int red) {
        return listaClanova.get(red);
    }

    public void izmeniClana(Clan p, int red) {
        Clan clan = listaClanova.get(red);
        clan.setIme(p.getIme());
        clan.setPrezime(p.getPrezime());
        clan.setStatus(p.getStatus());
        fireTableDataChanged();
    }

    public boolean daLiPostoji(Clan p) {
         for(Clan pr : listaClanova) {
           if(pr.getJmbg()==p.getJmbg()) {
               return true;
           }
         }
        return false;
        }
         
}
