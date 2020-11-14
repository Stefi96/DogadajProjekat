package session;

import domen.Administrator;
import domen.Korisnik;
import domen.Clan;


public class Sesija {

    private static Sesija instance;
    private Korisnik korisnik;
    private Administrator administrator;
    private Clan clan;

    private Sesija() {
    }

    public static Sesija getInstance() {
        if (instance == null) {

            instance = new Sesija();
        }
        return instance;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    

}
