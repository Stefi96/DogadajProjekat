package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drzava implements DomenskiObjekat {
    private int idDrzave;
    private String naziv;
    private String kontinent;

    public Drzava() {
    }

    public Drzava(int idDrzave, String naziv, String kontinent) {
        this.idDrzave = idDrzave;
        this.naziv = naziv;
        this.kontinent = kontinent;
    }
    
    private static final String IDDRZAVE = "idDrzave";
    private static final String NAZIV = "naziv";
    private static final String KONTINENT = "kontinent";
    
    @Override
    public String vratiImeTabele() {
        return "drzava";
    }

    @Override
    public String vratiPoljaZaInsert() {
        return " (" + IDDRZAVE + "," + NAZIV + "," + KONTINENT + ") ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return idDrzave+",'" + naziv + "','" + kontinent + "'";
    }

    @Override
    public List<DomenskiObjekat> vratiListuPoRS(ResultSet rs) {
        List<DomenskiObjekat> listaDrzava = new ArrayList<>();
        
        try {
            while(rs.next()) {
                int id = rs.getInt(IDDRZAVE);
                String naziv = rs.getString(NAZIV);
                String kontinent = rs.getString(KONTINENT);
                Drzava d = new Drzava(id, naziv, kontinent);
                listaDrzava.add(d);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaDrzava;
    }

    @Override
    public String vratiTabelaID() {
        return "idDrzave";
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPoRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaPromenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoin() {
        return "";
    }

    @Override
    public String vratiAlias() {
        return " d ";
    }

    @Override
    public String whereConn() {
        return "";
    }

    public int getIdDrzave() {
        return idDrzave;
    }

    public void setIdDrzave(int idDrzave) {
        this.idDrzave = idDrzave;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String kontinent) {
        this.kontinent = kontinent;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drzava other = (Drzava) obj;
        if (this.idDrzave != other.idDrzave) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.kontinent, other.kontinent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv; 
    }
    
    
    
}
