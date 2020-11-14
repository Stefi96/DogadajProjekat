package kontroler;

import domen.Prijava;
import domen.Drzava;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import java.util.ArrayList;
import java.util.List;
import komunikacija.KomunikacijaSaServerom;
import transfer.KlijentskiZahtev;
import transfer.Operacija;

public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public void prijaviSe(Korisnik korisnik) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.LOGIN);
        kz.setParametar(korisnik);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        
    }

    public void dodajDogadjajUbazu(Dogadjaj p) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DODAJ_DOGADJAJ);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void dodajClanaUbazu(Clan p) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DODAJ_CLANA);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void dodajPrijavuUBazu(Prijava aplik) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DODAJ_PRIJAVU);
        kz.setParametar(aplik);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void obrisiDogadjaj(Dogadjaj p) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_DOGADJAJ);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void obrisiClana(Korisnik prakt) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_CLANA);
        kz.setParametar(prakt);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void izmeniDogadjaj(Dogadjaj p) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_DOGADJAJ);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void izmeniClana(Clan clan) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_CLANA);
        kz.setParametar(clan);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiClanove() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_CLANOVE);  
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDrzave() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DRZAVE);  
        kz.setParametar(new Drzava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiClanoveZaUnosFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_CLANOVE_ZA_UNOS_FORMU);  
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDogadjajeZaUnosFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DOGAJAJE_ZA_UNOS_FORMU);  
        kz.setParametar(new Dogadjaj());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDogadjajeZaPretragu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DOGADJAJE_ZA_PRETRAGU);  
        kz.setParametar(new Dogadjaj());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDogadjajeZaUnosPrijave() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DOGJADJAJE_ZA_UNOS_PRIJAVE);  
        kz.setParametar(new Dogadjaj());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiPrijave() {
        KlijentskiZahtev kz = new KlijentskiZahtev();  
        kz.setOperacija(Operacija.VRATI_PRIJAVE);  
        kz.setParametar(new Prijava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiClanoveZaBrisanjeFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_CLANOVE_ZA_BRISANJE_FORMU);  
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDogadjajeZaBrisanjeFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DOGADJAJE_ZA_BRISANJE_FORMU);  
        kz.setParametar(new Dogadjaj());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiClanoveZaAzuriranjeFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_CLANOVE_ZA_AZURIRANJE_FORMU);  
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDogadjajeZaAzuriranjeFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DOGJADJAJE_ZA_AZURIRANJE_FORMU);  
        kz.setParametar(new Dogadjaj());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDrzaveZaAzurirajPraksu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DRZAVE_ZA_AZURIRAJ_DOGADJAJ);  
        kz.setParametar(new Drzava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void promeniLozinku(Korisnik korisnik) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PROMENA_LOZINKE);
        kz.setParametar(korisnik);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void obrisiPrijavu(Prijava ap) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_PRIJAVU);
        kz.setParametar(ap);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void dodajKorisnikaUBazu(Korisnik k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DODAJ_KORISNIKA);
        kz.setParametar(k);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void dodajDrzavuUBazu(Drzava drzava) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.DODAJ_DRZAVU);
        kz.setParametar(drzava);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiDrzaveZaUnosFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_DRZAVE_ZA_UNOS);
        kz.setParametar(new Drzava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

 /*   public void sacuvajAplikacijeUBazu(ArrayList<Aplikacija> listaAplikacija) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.SACUVAJ_SVE);
        kz.setParametar(listaAplikacija);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }*/

    public void nadjiDogadjaj(String kriterijum) {
       KlijentskiZahtev kz = new KlijentskiZahtev();
       kz.setOperacija(Operacija.NADJI_DOGADJAJ);
       kz.setParametar(kriterijum);
       KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void sacuvajPrijaveUBazu(Clan prakt) {
     KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.SACUVAJ_SVE);
        kz.setParametar(prakt);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);   
    }

    public void nadjiClana(String kriterijum) {
       KlijentskiZahtev kz = new KlijentskiZahtev();
       kz.setOperacija(Operacija.NADJI_CLANA);
       kz.setParametar(kriterijum);
       KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiKorisnikeZaUnosFormu() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
       kz.setOperacija(Operacija.VRATI_KORISNIKE);
       kz.setParametar(new Korisnik());
       KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }
    
    public void vratiPrijaveZaBrisanjeClanova() {
         KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_PRIJAVE_ZA_BRISANJE_CLANOVA);  
        kz.setParametar(new Prijava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void vratiPrijaveZaBrisanjeDogadjaja() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA);  
        kz.setParametar(new Prijava());
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

    public void odjaviSe() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.LOGOUT);  
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
    }

}
