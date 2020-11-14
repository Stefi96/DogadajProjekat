/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Prijava;
import domen.DomenskiObjekat;
import domen.Drzava;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemskeOperacije.AzurirajDogadjaj;
import sistemskeOperacije.AzuriranjeClana;
import sistemskeOperacije.KreirajPrijavu;
import sistemskeOperacije.KreirajDrzavu;
import sistemskeOperacije.DodajKorisnika;
import sistemskeOperacije.KreirajDogadjaj;
import sistemskeOperacije.KreirajClana;
import sistemskeOperacije.ObrisiPrijavu;
import sistemskeOperacije.ObrisiDogadjaj;
import sistemskeOperacije.ObrisiClana;
import sistemskeOperacije.PromeniLozinku;
import sistemskeOperacije.VratiListuPrijava;
import sistemskeOperacije.VratiListuDrzava;
import sistemskeOperacije.VratiListuDrzavaZaAzuriranjeDogadjajaFormu;
import sistemskeOperacije.VratiListuDrzavaZaUnos;
import sistemskeOperacije.VratiListuDogadjajaZaAzuriranjeFormu;
import sistemskeOperacije.VratiListuDogadjajaZaBrisanjeFormu;
import sistemskeOperacije.VratiListuDogadjajaZaFormu;
import sistemskeOperacije.VratiListuDogadjajaiZaPretragu;
import sistemskeOperacije.VratiListuDogadjajaZaUnosPrijave;
import sistemskeOperacije.VratiListuClanova;
import sistemskeOperacije.VratiListuClanovaZaBrisanjeFormu;
import sistemskeOperacije.VratiListuClanovaZaFormu;
import sistemskeOperacije.PrijaviKorisnika;
import sistemskeOperacije.PronadjiDogadjaj;
import sistemskeOperacije.PronadjiClana;
import sistemskeOperacije.SacuvajPrijave;
import sistemskeOperacije.VratiListuPrijavaZaBrisanjeDogadjaja;
import sistemskeOperacije.VratiListuPrijavaZaBrisanjeClanova;
import sistemskeOperacije.VratiListuKorisnika;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Joka
 */
public class Kontroler {

    private static Kontroler instance;

    public static void testirajParametrer(String url, String username, String password) throws SQLException {
        DBBroker dbb=new DBBroker();
        dbb.testParametars(url, username, password);
    }
    private final DBBroker broker;

    private Kontroler() {
        broker = new DBBroker();

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();

        }
        return instance;
    }

    public ServerskiOdgovor vratiPrijavljenogKorisnika(Korisnik korisnik) {
        return new PrijaviKorisnika().procesTransakcije(korisnik);
    }

    public ServerskiOdgovor unesiDogadjaj(Dogadjaj dogadjajZaDodavanje) {
        return new KreirajDogadjaj().procesTransakcije(dogadjajZaDodavanje);
    }

    public ServerskiOdgovor unesiClana(Clan clanZaDodavanje) {
        return new KreirajClana().procesTransakcije(clanZaDodavanje);
    }

    public ServerskiOdgovor unesiPrijavu(Prijava prijavaZaDodavanje) {
        return new KreirajPrijavu().procesTransakcije(prijavaZaDodavanje);
    }

    public ServerskiOdgovor obrisiDogadjaj(Dogadjaj dogadjajZaBrisanje) {
        return new ObrisiDogadjaj().procesTransakcije(dogadjajZaBrisanje);
    }

    public ServerskiOdgovor obrisiClana(Korisnik clanZaBrisanje) {
        return new ObrisiClana().procesTransakcije(clanZaBrisanje);
    }

    public ServerskiOdgovor izmeniDogadjaj(Dogadjaj dogadjajIzmena) {
        return new AzurirajDogadjaj().procesTransakcije(dogadjajIzmena);
    }

    public ServerskiOdgovor izmeniClana(Clan clanIzmena) {
        return new AzuriranjeClana().procesTransakcije(clanIzmena);
    }
    
    public ServerskiOdgovor vratiClanove(Clan clan) {
        return new VratiListuClanova().procesTransakcije(clan);
    }

    public ServerskiOdgovor vratiDrzave(Drzava drzava) {
        return new VratiListuDrzava().procesTransakcije(drzava);
    }

    public ServerskiOdgovor vratiClanoveZaUnosFormu(Clan clanUnos) {
        return new VratiListuClanovaZaFormu().procesTransakcije(clanUnos);
    }

    public ServerskiOdgovor vratiDogadjajeZaUnosFormu(Dogadjaj dogadjajUnos) {
        return new VratiListuDogadjajaZaFormu().procesTransakcije(dogadjajUnos);
    }

    public ServerskiOdgovor vratiDogadjajeZaPretragu(Dogadjaj dogadjajPretraga) {
        return new VratiListuDogadjajaiZaPretragu().procesTransakcije(dogadjajPretraga);
    }

    public ServerskiOdgovor vratiDogadjajeZaUnosPrijave(Dogadjaj dogadjajUnosPrijava) {
        return new VratiListuDogadjajaZaUnosPrijave().procesTransakcije(dogadjajUnosPrijava);
    }

    public ServerskiOdgovor vratiPrijave(Prijava prijava) {
        return new VratiListuPrijava().procesTransakcije(prijava);
    }

    public ServerskiOdgovor vratiClanoveZaBrisanjeFormu(Clan clanBrisanje) {
        return new VratiListuClanovaZaBrisanjeFormu().procesTransakcije(clanBrisanje);
    }

    public ServerskiOdgovor vratiDogadjajeZaBrisanjeFormu(Dogadjaj dogadjajBrisanje) {
        return new VratiListuDogadjajaZaBrisanjeFormu().procesTransakcije(dogadjajBrisanje);
    }

    public ServerskiOdgovor vratiDogadjajeZaAzuriranjeFormu(Dogadjaj dogadjajAzuriranje) {
        return new VratiListuDogadjajaZaAzuriranjeFormu().procesTransakcije(dogadjajAzuriranje);
    }

    public ServerskiOdgovor vratiDrzaveZaAzurirajDogadjajaFormu(Drzava drzavaAzuriranje) {
        return new VratiListuDrzavaZaAzuriranjeDogadjajaFormu().procesTransakcije(drzavaAzuriranje);
    }

    public ServerskiOdgovor promeniLozinku(Korisnik k) {
        return new PromeniLozinku().procesTransakcije(k);
    }

    public ServerskiOdgovor obrisiPrijavu(Prijava prijavaBrisanje) {
        return new ObrisiPrijavu().procesTransakcije(prijavaBrisanje);
    }

    public ServerskiOdgovor unesiKorisnika(Korisnik korisnikZaDodavanje) {
        return new DodajKorisnika().procesTransakcije(korisnikZaDodavanje);
    }

    public ServerskiOdgovor unesiDrzavu(Drzava drzavaZaDodavanje) {
        return new KreirajDrzavu().procesTransakcije(drzavaZaDodavanje);
    }

    public ServerskiOdgovor vratiDrzaveZaUnos(Drzava dr) {
        return new VratiListuDrzavaZaUnos().procesTransakcije(dr);
    }

    public ServerskiOdgovor nadjiDogadjaj(Dogadjaj dogadjajZaPretragu) {
        return new PronadjiDogadjaj().procesTransakcije(dogadjajZaPretragu);
    }

    public ServerskiOdgovor sacuvajSve(Clan clanCuvanje) {
        return new SacuvajPrijave().procesTransakcije(clanCuvanje);
    }

    public ServerskiOdgovor nadjiClanove(Clan clanZaPretragu) {
        return new PronadjiClana().procesTransakcije(clanZaPretragu);
    }

    public ServerskiOdgovor vratiKorisnike(Korisnik kor) {
        return new VratiListuKorisnika().procesTransakcije(kor);
    }

    public ServerskiOdgovor vratiPrijaveZaBrisanjeClanova(Prijava prijaveBrisanjeClanova) {
        return new VratiListuPrijavaZaBrisanjeClanova().procesTransakcije(prijaveBrisanjeClanova);
    }

    public ServerskiOdgovor vratiPrijaveZaBrisanjeDogadjaja(Prijava prijaveBrisanjeDogadjaja) {
        return new VratiListuPrijavaZaBrisanjeDogadjaja().procesTransakcije(prijaveBrisanjeDogadjaja);
    }

   
}
