package niti;

import domen.Prijava;
import domen.Drzava;
import domen.Korisnik;
import domen.Dogadjaj;
import domen.Clan;
import java.net.Socket;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class KlijentNit extends Thread {

    Socket s;
    ServerNit sn;

    public KlijentNit() {
    }

    public KlijentNit(Socket s, ServerNit sn) {
        this.s = s;
        this.sn = sn;
    }

    @Override
    public void run() {
        while (!interrupted()) {

            KlijentskiZahtev kz = Komunikacija.getInstance().prihvatiZahtev(s);
            ServerskiOdgovor so = new ServerskiOdgovor();

            switch (kz.getOperacija()) {
                case Operacija.LOGIN:
                    Korisnik korisnik = (Korisnik) kz.getParametar();
                    so = Kontroler.getInstance().vratiPrijavljenogKorisnika(korisnik);
                    break;
                    
                case Operacija.DODAJ_DOGADJAJ:
                    Dogadjaj dogadjajZaDodavanje = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().unesiDogadjaj(dogadjajZaDodavanje);
                    break;
                    
                case Operacija.DODAJ_CLANA:
                    Clan clanZaDodavanje = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().unesiClana(clanZaDodavanje);
                    break;
                    
                case Operacija.DODAJ_PRIJAVU:
                    Prijava prijavaZaDodavanje = (Prijava) kz.getParametar();
                    so = Kontroler.getInstance().unesiPrijavu(prijavaZaDodavanje);
                    break;
                
                case Operacija.OBRISI_PRIJAVU:
                    Prijava priajvaZaBrisanje = (Prijava) kz.getParametar();
                    so = Kontroler.getInstance().obrisiPrijavu(priajvaZaBrisanje);
                    break;
                    
                case Operacija.OBRISI_CLANA:
                    Korisnik clanZaBrisanje = (Korisnik) kz.getParametar();
                    so = Kontroler.getInstance().obrisiClana(clanZaBrisanje);
                    break;
               
                case Operacija.IZMENI_DOGADJAJ:
                    Dogadjaj dogadjajIzmena = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().izmeniDogadjaj(dogadjajIzmena);
                    break;
                    
                case Operacija.IZMENI_CLANA:
                    Clan clanIzmena = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().izmeniClana(clanIzmena);
                    break;

                case Operacija.VRATI_CLANOVE:
                    Clan clan = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().vratiClanove(clan);
                    break;
                    
                case Operacija.VRATI_DRZAVE:
                    Drzava drzava = (Drzava) kz.getParametar();
                    so = Kontroler.getInstance().vratiDrzave(drzava);
                    break;
                    
                case Operacija.VRATI_CLANOVE_ZA_UNOS_FORMU:
                    Clan clanUnos = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().vratiClanoveZaUnosFormu(clanUnos);
                    break;
                    
                case Operacija.VRATI_DOGAJAJE_ZA_UNOS_FORMU:
                    Dogadjaj dogadjajUnos = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().vratiDogadjajeZaUnosFormu(dogadjajUnos);
                    break;
                    
                case Operacija.VRATI_DOGADJAJE_ZA_PRETRAGU:
                    Dogadjaj dogadjajPretraga = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().vratiDogadjajeZaPretragu(dogadjajPretraga);
                    break;
                    
                case Operacija.VRATI_DOGJADJAJE_ZA_UNOS_PRIJAVE:
                    Dogadjaj dogadjajUnosPrijava = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().vratiDogadjajeZaUnosPrijave(dogadjajUnosPrijava);
                    break;
                    
                case Operacija.VRATI_PRIJAVE:
                    Prijava prijava = (Prijava) kz.getParametar();
                    so = Kontroler.getInstance().vratiPrijave(prijava);
                    break;
                    
                case Operacija.VRATI_CLANOVE_ZA_BRISANJE_FORMU:
                    Clan clanBrisanje = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().vratiClanoveZaBrisanjeFormu(clanBrisanje);
                    break;
                    
                case Operacija.VRATI_DOGADJAJE_ZA_BRISANJE_FORMU:
                    Dogadjaj dogadjajBrisanje = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().vratiDogadjajeZaBrisanjeFormu(dogadjajBrisanje);
                    break;

                case Operacija.VRATI_DOGJADJAJE_ZA_AZURIRANJE_FORMU:
                    Dogadjaj dogadjajAzuriranje = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().vratiDogadjajeZaAzuriranjeFormu(dogadjajAzuriranje);
                    break;
                    
                case Operacija.VRATI_DRZAVE_ZA_AZURIRAJ_DOGADJAJ:
                    Drzava drzavaAzuriranje = (Drzava) kz.getParametar();
                    so = Kontroler.getInstance().vratiDrzaveZaAzurirajDogadjajaFormu(drzavaAzuriranje);
                    break;
                    
                case Operacija.PROMENA_LOZINKE:
                    Korisnik k = (Korisnik) kz.getParametar();
                    so = Kontroler.getInstance().promeniLozinku(k);
                    break;
                    
                case Operacija.OBRISI_DOGADJAJ:
                    Dogadjaj prijavaDogadjaj = (Dogadjaj) kz.getParametar();
                    so = Kontroler.getInstance().obrisiDogadjaj(prijavaDogadjaj);
                    break;
                 
                case Operacija.DODAJ_KORISNIKA:
                    Korisnik korisnikZaDodavanje = (Korisnik) kz.getParametar();
                    so = Kontroler.getInstance().unesiKorisnika(korisnikZaDodavanje);
                    break;  
                    
                case Operacija.DODAJ_DRZAVU:
                    Drzava drzavaZaDodavanje = (Drzava) kz.getParametar();
                    so = Kontroler.getInstance().unesiDrzavu(drzavaZaDodavanje);
                    break;
                    
                case Operacija.VRATI_DRZAVE_ZA_UNOS:
                    Drzava dr = (Drzava) kz.getParametar();
                    so = Kontroler.getInstance().vratiDrzaveZaUnos(dr);
                    break;
                    
                case Operacija.SACUVAJ_SVE:
                    Clan clanCuvanje = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().sacuvajSve(clanCuvanje);
                    break;
                    
                case Operacija.NADJI_DOGADJAJ:
                    String naziv = (String) kz.getParametar();
                    Dogadjaj dogadjajZaPretragu = new Dogadjaj();
                    dogadjajZaPretragu.setNaziv(naziv);
                    so=Kontroler.getInstance().nadjiDogadjaj(dogadjajZaPretragu);
                    break;
                    
                 case Operacija.NADJI_CLANA:
                    String tekst = (String) kz.getParametar();
                    Clan clanZaPretragu = new Clan();
                    clanZaPretragu.setIme(tekst);
                    clanZaPretragu.setPrezime(tekst);
                    so=Kontroler.getInstance().nadjiClanove(clanZaPretragu);
                    break;
                    
                    case Operacija.VRATI_KORISNIKE:
                    Korisnik kor = (Korisnik) kz.getParametar();
                    so = Kontroler.getInstance().vratiKorisnike(kor);
                    break;
                    
                    case Operacija.VRATI_PRIJAVE_ZA_BRISANJE_CLANOVA:
                    Prijava prijaveBrisanjeClanova = (Prijava) kz.getParametar();
                    so = Kontroler.getInstance().vratiPrijaveZaBrisanjeClanova(prijaveBrisanjeClanova);
                    break;
                    
                    case Operacija.VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA:
                    Prijava prijaveBrisanjeDogadjaja = (Prijava) kz.getParametar();
                    so = Kontroler.getInstance().vratiPrijaveZaBrisanjeDogadjaja(prijaveBrisanjeDogadjaja);
                    break;
            }
            Komunikacija.getInstance().posaljiOdgovor(so, s);

        }
    }

    public Socket getS() {
        return s;
    }
    

}
