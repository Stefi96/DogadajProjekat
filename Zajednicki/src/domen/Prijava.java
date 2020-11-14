package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Prijava implements DomenskiObjekat{
    private int idPrijave;
    private Clan clan;
    private Dogadjaj dogadaj;
    private String motivaciono;
    private String status;
    
    public Prijava() {
    }

    public Prijava(int idPrijave, Clan clan, Dogadjaj dogadaj, String motivaciono, String status) {
        this.idPrijave = idPrijave;
        this.clan = clan;
        this.dogadaj = dogadaj;
        this.motivaciono = motivaciono;
        this.status = status;
    }

    private static final String IDPRIJAVE = "idPrijave";
    private static final String IDLCANA = "idClana";
    private static final String IDDOGADJAJA = "idDogadjaja";
    private static final String MOTIVACIONO = "motivaciono";
    
    @Override
    public String vratiImeTabele() {
        return "prijava";
    }

    @Override
    public String vratiPoljaZaInsert() {
        return " (" +IDPRIJAVE+ "," +IDLCANA + "," + IDDOGADJAJA + "," + MOTIVACIONO +  ") ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return IDPRIJAVE+"," + clan.getIdClana() + "," + dogadaj.getIdDogadjaja()+ ",'" + motivaciono + "'";
    }

    @Override
    public List<DomenskiObjekat> vratiListuPoRS(ResultSet rs) {
        List<DomenskiObjekat> listaPrijava = new ArrayList<>();
        try {
            while(rs.next()) {
                int id = rs.getInt(IDPRIJAVE);
                String motiv = rs.getString(MOTIVACIONO);
                
                Clan c = new Clan();
                Dogadjaj dog = new Dogadjaj();
                
                c.setIdClana(rs.getInt("c.idClana"));
                c.setIme(rs.getString("c.ime"));
                c.setPrezime(rs.getString("c.prezime"));
                c.setJmbg(rs.getString("c.jmbg"));
                c.setStatus(rs.getString("c.status"));
                
                dog.setIdDogadjaja(rs.getInt("dog.idDogadjaja"));
                dog.setNaziv(rs.getString("dog.naziv"));
                dog.setBrojPrijava(rs.getInt("dog.brojPrijava"));
                dog.setDrzava(new Drzava(rs.getInt("dog.idDrzave"), "", ""));   
                dog.setDatumPocetka(rs.getDate("dog.datumPocetka"));
                dog.setDatumZavrsetka(rs.getDate("dog.datumZavrsetka"));
                
                Prijava p = new Prijava(id, c, dog, motiv, "");
                
                listaPrijava.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrijava;
    }

    @Override
    public String vratiTabelaID() {
        return "idPrijave";
    }

    @Override
    public String vratiPK() {
        return IDPRIJAVE + "=" + idPrijave;
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
        return " join clan c on p.idClana = c.idClana join dogadjaj dog on p.idDogadjaja = dog.idDogadjaja";
    }

    @Override
    public String vratiAlias() {
        return " p"; 
    }

    @Override
    public String whereConn() {
        return "";
    }

    public int getIdPrijave() {
        return idPrijave;
    }

    public void setIdPrijave(int idPrijave) {
        this.idPrijave = idPrijave;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Dogadjaj getDogadaj() {
        return dogadaj;
    }

    public void setDogadaj(Dogadjaj dogadaj) {
        this.dogadaj = dogadaj;
    }

    public String getMotivaciono() {
        return motivaciono;
    }

    public void setMotivaciono(String motivaciono) {
        this.motivaciono = motivaciono;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        final Prijava other = (Prijava) obj;
        if (this.idPrijave != other.idPrijave) {
            return false;
        }
        if (!Objects.equals(this.motivaciono, other.motivaciono)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.clan, other.clan)) {
            return false;
        }
        if (!Objects.equals(this.dogadaj, other.dogadaj)) {
            return false;
        }
        return true;
    }

    

}
