package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dogadjaj implements DomenskiObjekat {
    private int idDogadjaja;
    private String naziv;
    private int brojPrijava;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private Drzava drzava;
    private ArrayList<Prijava> listaPrijava;

    public Dogadjaj() {
    }

    public Dogadjaj(int idDogadjaja, String naziv, int brojPrijava, Date datumPocetka, Date datumZavrsetka, Drzava drzava, ArrayList<Prijava> listaPrijava) {
        this.idDogadjaja = idDogadjaja;
        this.naziv = naziv;
        this.brojPrijava = brojPrijava;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.drzava = drzava;
        this.listaPrijava = listaPrijava;
    }

    private static final String IDDOGADJAJA = "idDogadjaja";
    private static final String NAZIV = "naziv";
    private static final String BROJPRIJAVA = "brojPrijava";
    private static final String DATUMPOCETKA = "datumPocetka";
    private static final String DATUMZAVRSETKA = "datumZavrsetka";
    private static final String IDDRZAVE = "idDrzave";
    
    
    @Override
    public String vratiImeTabele() {
        return "dogadjaj";
    }

    @Override
    public String vratiPoljaZaInsert() {
        return " (" + IDDOGADJAJA + "," + NAZIV + "," + BROJPRIJAVA + "," + DATUMPOCETKA + "," + DATUMZAVRSETKA + "," + IDDRZAVE + ") ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datumPoc = sdf.format(this.datumPocetka);
        String datumZav = sdf.format(this.datumZavrsetka);
        
        return idDogadjaja+",'" + naziv + "','" + brojPrijava + "','" + datumPoc + "','" + datumZav + "'," + drzava.getIdDrzave();
    }

    @Override
    public List<DomenskiObjekat> vratiListuPoRS(ResultSet rs) {
        List<DomenskiObjekat> listaDogadjaja = new ArrayList<>();
        try {
            while(rs.next()) {
                int id = rs.getInt(IDDOGADJAJA);
                String nazivDogadjaja = rs.getString(NAZIV);
                int brPrijava = rs.getInt(BROJPRIJAVA);
                Date datumPoc = rs.getDate(DATUMPOCETKA);
                Date datumZav = rs.getDate(DATUMZAVRSETKA);
                int idDrzave = rs.getInt("d.idDrzave");
                String nazivDrzave = rs.getString("d.naziv");
                String kontinent = rs.getString("d.kontinent");
                Drzava drzavaLokacija = new Drzava(idDrzave, nazivDrzave, kontinent);
                Dogadjaj d = new Dogadjaj(id, nazivDogadjaja, brPrijava, datumPoc, datumZav, drzavaLokacija, new ArrayList<>());
                
                listaDogadjaja.add(d);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Dogadjaj.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDogadjaja;
    }

    @Override
    public String vratiTabelaID() {
        return "idDogadjaja";
    }

    @Override
    public String vratiPK() {
        return IDDOGADJAJA + "=" + idDogadjaja;
    }

    @Override
    public void postaviVrednostPoRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaPromenu() {
        java.sql.Date datumPoc = new java.sql.Date(datumPocetka.getTime());
        java.sql.Date datumZav = new java.sql.Date(datumZavrsetka.getTime());
        return " naziv='" + naziv + "', brojPrijava=" + brojPrijava
                + ", datumPocetka='" + datumPoc + "', datumZavrsetka='" + datumZav + "', idDrzave=" + drzava.getIdDrzave();

    }

    @Override
    public String vratiJoin() {
        return " join drzava d on dog.idDrzave=d.idDrzave";
    }

    @Override
    public String vratiAlias() {
        return " dog ";
    }

    @Override
    public String whereConn() {
        return "";
    }  

    public int getIdDogadjaja() {
        return idDogadjaja;
    }

    public void setIdDogadjaja(int idDogadjaja) {
        this.idDogadjaja = idDogadjaja;
    }

    public int getBrojPrijava() {
        return brojPrijava;
    }

    public void setBrojPrijava(int brojPrijava) {
        this.brojPrijava = brojPrijava;
    }

    public ArrayList<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return naziv; 
    }

     @Override
    public boolean equals(Object obj) {
        Dogadjaj p = (Dogadjaj) obj;
        if(naziv.contains(p.getNaziv()))
            return true;
        return false;
    }
}
