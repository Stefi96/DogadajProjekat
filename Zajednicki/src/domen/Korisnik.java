package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Korisnik implements DomenskiObjekat {
    private int idKorisnika;
    private String korisnickoIme;
    private String lozinka;
    private Administrator admin;
    private Clan clan;

    public Korisnik() {
    }

    public Korisnik(int idKorisnika, String korisnickoIme, String lozinka, Administrator admin, Clan clan) {
        this.idKorisnika = idKorisnika;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.admin = admin;
        this.clan = clan;
    }

    
 
    private static final String IDKORISNIKA = "idKorisnika";
    private static final String KORISNICKOIME = "korisnickoIme";
    private static final String LOZINKA = "lozinka";
    
    @Override
    public String vratiImeTabele() {
        return "korisnik";
    }

    @Override
    public String vratiPoljaZaInsert() {
        return " (" + IDKORISNIKA + "," + KORISNICKOIME + "," + LOZINKA + ") ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return idKorisnika+",'" + korisnickoIme + "','" + lozinka + "'";
    }
    
    @Override
    public List<DomenskiObjekat> vratiListuPoRS(ResultSet rs) {
        List<DomenskiObjekat> listaKorisnika = new ArrayList<>();
        
        try {
           while(rs.next()) {
                int id = rs.getInt("k.idKorisnika");
                String korIme = rs.getString("k.korisnickoIme");
                String pass = rs.getString("k.lozinka");
                
                Administrator a = new Administrator();
                a.setIdAdministrator(rs.getInt("a.idAdministrator"));
                a.setIme(rs.getString("a.ime"));
                a.setPrezime(rs.getString("a.prezime"));
                
                Clan c = new Clan();
                c.setIdClana(rs.getInt("c.idClana"));
                c.setIme(rs.getString("c.ime"));
                c.setPrezime(rs.getString("c.prezime"));
                c.setJmbg(rs.getString("c.jmbg"));
                
                Korisnik kor = new Korisnik();
                kor.setIdKorisnika(id);
                kor.setKorisnickoIme(korIme);
                kor.setLozinka(pass);
                
                if(id == a.getIdAdministrator()) {
                    kor.setAdmin(a);
                    kor.setClan(null);
                } 
                if(id == c.getIdClana()) {
                    kor.setClan(c);
                    kor.setAdmin(null);
                } 
                listaKorisnika.add(kor);
            }     
        }   catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaKorisnika;
    }

    @Override
    public String vratiTabelaID() {
        return "idKorisnika";
    }

    @Override
    public String vratiPK() {
        return IDKORISNIKA + "=" + idKorisnika;
    }

    @Override
    public void postaviVrednostPoRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaPromenu() {
        return "korisnickoIme = '" + korisnickoIme + "', lozinka = '" + lozinka + "'";
    }

    @Override
    public String vratiJoin() {
        return " left join Administrator a on k.idKorisnika=a.idAdministrator "
                + "left join Clan c on k.idKorisnika=c.idClana";
    }

    @Override
    public String vratiAlias() {
        return " k";
    }

    @Override
    public String whereConn() {
        return " where k.korisnickoIme = '"+korisnickoIme+"' and k.lozinka = '"+lozinka+"'";
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
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
        final Korisnik other = (Korisnik) obj;
        if (this.idKorisnika != other.idKorisnika) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        if (!Objects.equals(this.admin, other.admin)) {
            return false;
        }
        if (!Objects.equals(this.clan, other.clan)) {
            return false;
        }
        return true;
    }

    
}
