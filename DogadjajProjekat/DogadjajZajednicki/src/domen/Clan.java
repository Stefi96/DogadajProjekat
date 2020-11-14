package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clan implements DomenskiObjekat {
    private int idClana;
    private String ime;
    private String prezime;
    private String jmbg;
    private String status;
    private ArrayList<Prijava> listaPrijava;

    public Clan() {
    }

    public Clan(int idClana, String ime, String prezime, String jmbg, String status, ArrayList<Prijava> listaPrijava) {
        this.idClana = idClana;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.status = status;
        this.listaPrijava = listaPrijava;
    }

    

    private static final String IDCLANA = "idClana";
    private static final String IME = "ime";
    private static final String PREZIME = "prezime";
    private static final String JMBG = "jmbg";
    private static final String STATUS = "status";
    
    @Override
    public String vratiImeTabele() {
        return "clan";
    }

    @Override
    public String vratiPoljaZaInsert() {
        return " ("+IDCLANA+"," + IME + "," + PREZIME + ","+ JMBG +"," + STATUS +") ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return idClana+",'" + ime + "','" + prezime + "','" + jmbg + "','" + status + "'";
    }

    @Override
    public List<DomenskiObjekat> vratiListuPoRS(ResultSet rs) {
        List<DomenskiObjekat> listaClanova = new ArrayList<>();
        try {
            while(rs.next()) {
                int id = rs.getInt(IDCLANA);
                String imeClana = rs.getString(IME);
                String prezimeClana = rs.getString(PREZIME);
                String jmbgClana = rs.getString(JMBG);
                String statusClana = rs.getString(STATUS);
                
                Clan c = new Clan(id, imeClana, prezimeClana, jmbgClana,statusClana,new ArrayList<>());
                
                listaClanova.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaClanova;
    }

    @Override
    public String vratiTabelaID() {
        return "idClana";
    }

    @Override
    public String vratiPK() {
        return IDCLANA + "=" + idClana;
    }

    @Override
    public void postaviVrednostPoRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaPromenu() {
        return " ime='" + ime + "', prezime='" + prezime + "', jmbg='"+ jmbg +"', status='" + status+ "'";
    }

    @Override
    public String vratiJoin() {
        //return " left join korisnik k ON c.idClana=k.idKorisnika";
        return "";
    }

    @Override
    public String vratiAlias() {
        return " c ";
    }

    @Override
    public String whereConn() {
        return "";
    }

    public int getIdClana() {
        return idClana;
    }

    public void setIdClana(int idClana) {
        this.idClana = idClana;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }   
    
    public ArrayList<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return ime+" "+prezime; 
    }
    
    @Override
    public boolean equals(Object obj) {
        Clan p = (Clan) obj;
        String kr = ime + " " + prezime;
        if(kr.contains(p.getIme()) || kr.contains(p.getPrezime()))
            return true;
        return false;
    }

}
