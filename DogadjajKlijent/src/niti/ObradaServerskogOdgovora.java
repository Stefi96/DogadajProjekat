package niti;

import domen.DomenskiObjekat;
import domen.Korisnik;
import domen.Clan;
import forme.AzuriranjeDogadjaja;
import forme.BrisanjeDogadjaja;
import forme.BrisanjeClanova;
import forme.AdministratorForma;
import forme.DijalogUnosPrijave;
import forme.LoginForma;
import forme.ClanForma;
import forme.PregledClanova;
import forme.PretragaDogadjaja;
import forme.PromenaLozinke;
import forme.UnosPrijave;
import forme.UnosDrzave;
import forme.UnosDogadjaja;
import forme.UnosClana;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import kontroler.Kontroler;
import session.Sesija;
import transfer.Operacija;
import transfer.ServerskiOdgovor;

public class ObradaServerskogOdgovora extends Thread {

    LoginForma loginForma;
    AdministratorForma adminForma;
    ClanForma clanForma;
    UnosDogadjaja unosDogadjaja;
    UnosClana unosClanaForma;
    UnosPrijave unosPrijaveForma;
    DijalogUnosPrijave unosPrijaveDijalog;
    BrisanjeDogadjaja brisanjeDogadjajaForma;
    BrisanjeClanova brisanjeClanaForma;
    AzuriranjeDogadjaja azuriranjeDogadjajaForma;
    PregledClanova pregledClanovaForma;
    PretragaDogadjaja pretragaDogadjajaForma;
    PromenaLozinke promenaLozinkeForma;
    UnosDrzave unosDrzaveForma;

    boolean kraj = false;

    public ObradaServerskogOdgovora(LoginForma loginForma) {
        this.loginForma = loginForma;
    }

    @Override
    public void run() {
        while (!kraj) {

            ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().vratiOdgovor();
            switch (so.getOperacija()) {
                case Operacija.LOGIN:
                    List<DomenskiObjekat> lista = (List<DomenskiObjekat>) so.getOdgovor();
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Došlo je do greške prilikom prijavljivanja!");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Uspešno ste se prijavili!");
                    Korisnik k = (Korisnik) lista.get(0);
                    session.Sesija.getInstance().setKorisnik(k);
                    System.out.println(k.getKorisnickoIme());

                    if (k.getAdmin()!= null) {
                        Sesija.getInstance().setClan(k.getClan());
                        adminForma = new AdministratorForma();
                        adminForma.setVisible(true);
                        loginForma.dispose();
                    }
                    if (k.getClan() != null) {
                        session.Sesija.getInstance().setClan(k.getClan());
                        clanForma = new ClanForma();
                        clanForma.setVisible(true);
                        loginForma.dispose();
                    }
                    break;

                case Operacija.DODAJ_DOGADJAJ:
                    unosDogadjaja = adminForma.getUnosDogadjajaForma();
                    unosDogadjaja.unesiDogadjaj(so);
                    break;
                case Operacija.DODAJ_CLANA:
                    unosClanaForma = adminForma.getUnosClanaForma();
                    unosClanaForma.dodajClana(so);
                    break;

                case Operacija.DODAJ_PRIJAVU:
                    unosPrijaveForma = clanForma.getUnosPrijaveForma();
                    unosPrijaveForma.dodajPrijavu(so);
                    break;

                case Operacija.OBRISI_DOGADJAJ:
                    brisanjeDogadjajaForma = adminForma.getBrisanjeDogadjajaForma();
                    brisanjeDogadjajaForma.obrisiDogadjajIzTabele(so);
                    break;

                case Operacija.OBRISI_CLANA:
                    brisanjeClanaForma = adminForma.getBrisanjeClanaForma();
                    brisanjeClanaForma.obrisiClanaIzTabele(so);
                    break;

                case Operacija.IZMENI_DOGADJAJ:
                    azuriranjeDogadjajaForma = adminForma.getAzuriranjeDogadjajaforma();
                    azuriranjeDogadjajaForma.izmeniDogadjaj(so);
                    break;

                case Operacija.VRATI_CLANOVE:
                    pregledClanovaForma = adminForma.getPregledClanovaForma();
                    pregledClanovaForma.vratiClanove(so);
                    break;
                    
                case Operacija.VRATI_DRZAVE:
                    unosDogadjaja = adminForma.getUnosDogadjajaForma();
                    unosDogadjaja.vratiDrzave(so);
                    break;
                    
                case Operacija.VRATI_CLANOVE_ZA_UNOS_FORMU:
                    unosClanaForma = adminForma.getUnosClanaForma();
                    unosClanaForma.vratiClanoveZaUnosFormu(so);
                    break;
                    
                case Operacija.VRATI_DOGAJAJE_ZA_UNOS_FORMU:
                    unosDogadjaja = adminForma.getUnosDogadjajaForma();
                    unosDogadjaja.vratiDogadjajeZaUnosFormu(so);
                    break;
                    
                case Operacija.VRATI_DOGADJAJE_ZA_PRETRAGU:
                    pretragaDogadjajaForma = clanForma.getPretragaDogadjaja();
                    pretragaDogadjajaForma.vratiDogadjajeZaPretragu(so);
                    break;
                    
                case Operacija.VRATI_DOGJADJAJE_ZA_UNOS_PRIJAVE:
                    unosPrijaveForma = clanForma.getUnosPrijaveForma();
                    unosPrijaveForma.vratiDogadjajeZaUnosPrijave(so);
                    break;
                    
                case Operacija.VRATI_PRIJAVE:
                    unosPrijaveForma = clanForma.getUnosPrijaveForma();
                    unosPrijaveForma.vratiPrijave(so);
                    break;
                    
                case Operacija.VRATI_CLANOVE_ZA_BRISANJE_FORMU:
                    brisanjeClanaForma = adminForma.getBrisanjeClanaForma();
                    brisanjeClanaForma.vratiClanoveZaBrisanjeFormu(so);
                    break;
                    
                case Operacija.VRATI_DOGADJAJE_ZA_BRISANJE_FORMU:
                    brisanjeDogadjajaForma = adminForma.getBrisanjeDogadjajaForma();
                    brisanjeDogadjajaForma.vratiDogadjajeZaBrisanjeFormu(so);
                    break;

                    
                case Operacija.VRATI_DOGJADJAJE_ZA_AZURIRANJE_FORMU:
                    azuriranjeDogadjajaForma = adminForma.getAzuriranjeDogadjajaforma();
                    azuriranjeDogadjajaForma.vratiDogadjajeZaAzuriranjeFormu(so);
                    break;
                    
                case Operacija.VRATI_DRZAVE_ZA_AZURIRAJ_DOGADJAJ:
                    azuriranjeDogadjajaForma = adminForma.getAzuriranjeDogadjajaforma();
                    azuriranjeDogadjajaForma.vratiDrzaveZaAzuriranjeDogadjajaForma(so);
                    break;
                    
                case Operacija.PROMENA_LOZINKE:
                    promenaLozinkeForma = clanForma.getPromenaLozinkeForma();
                    promenaLozinkeForma.promeniLozinku(so);
                    break;
                    
                case Operacija.OBRISI_PRIJAVU:
                    unosPrijaveForma = clanForma.getUnosPrijaveForma();
                    unosPrijaveForma.obrisiPrijavuIzTabele(so);
                    break;
                    
                case Operacija.DODAJ_KORISNIKA:
                    unosClanaForma = adminForma.getUnosClanaForma();
                    unosClanaForma.dodajKorisnika(so);
                    break;
                    
                case Operacija.DODAJ_DRZAVU:
                    unosDrzaveForma = adminForma.getUnosDrzaveForma();
                    unosDrzaveForma.unesiDrzavu(so);
                    break;
                    
                case Operacija.VRATI_DRZAVE_ZA_UNOS:
                    unosDrzaveForma = adminForma.getUnosDrzaveForma();
                    unosDrzaveForma.vratiDrzave(so);
                    break;
                    
                case Operacija.SACUVAJ_SVE:
                    unosPrijaveForma = clanForma.getUnosPrijaveForma();
                    unosPrijaveForma.sacuvajPrijave(so);
                    break;
                
                case Operacija.NADJI_DOGADJAJ:
                    pretragaDogadjajaForma = clanForma.getPretragaDogadjaja();
                    pretragaDogadjajaForma.srediPronadjiDogadjaj(so);
                    break;
                    
                case Operacija.NADJI_CLANA:
                    pregledClanovaForma = adminForma.getPregledClanovaForma();
                    pregledClanovaForma.srediPronadjiClanove(so);
                    break;
                    
                case Operacija.VRATI_KORISNIKE:
                    unosClanaForma = adminForma.getUnosClanaForma();
                    unosClanaForma.vratiKorisnike(so);
                    break;
                    
                case Operacija.VRATI_PRIJAVE_ZA_BRISANJE_CLANOVA:
                    brisanjeClanaForma = adminForma.getBrisanjeClanaForma();
                    brisanjeClanaForma.vratiPrijave(so);
                    break;
                    
                case Operacija.VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA:
                    brisanjeDogadjajaForma = adminForma.getBrisanjeDogadjajaForma();
                    brisanjeDogadjajaForma.vratiPrijave(so);
                    break;
            }

        }
    }

}
