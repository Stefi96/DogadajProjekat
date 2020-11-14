package transfer;

public interface Operacija {
    public static final int LOGIN = 1;
    public static final int LOGOUT = 2;
    public static final int DODAJ_DOGADJAJ = 3;
    public static final int DODAJ_CLANA = 4;
    public static final int DODAJ_PRIJAVU = 5;
    public static final int OBRISI_DOGADJAJ = 6;
    public static final int OBRISI_CLANA = 7;
    public static final int IZMENI_DOGADJAJ= 8;
    public static final int IZMENI_CLANA = 9;
    public static final int OBRISI_PRIJAVU= 10;
    public static final int VRATI_CLANOVE = 11;
    public static final int VRATI_DRZAVE = 12;
    public static final int VRATI_CLANOVE_ZA_UNOS_FORMU = 13;
    public static final int VRATI_DOGAJAJE_ZA_UNOS_FORMU = 14;
    public static final int VRATI_DOGADJAJE_ZA_PRETRAGU = 15;
    public static final int VRATI_DOGJADJAJE_ZA_UNOS_PRIJAVE = 16;
    public static final int VRATI_PRIJAVE = 17;
    public static final int VRATI_CLANOVE_ZA_BRISANJE_FORMU = 18;
    public static final int VRATI_DOGADJAJE_ZA_BRISANJE_FORMU = 19;
    public static final int VRATI_CLANOVE_ZA_AZURIRANJE_FORMU = 20;
    public static final int VRATI_DOGJADJAJE_ZA_AZURIRANJE_FORMU = 21;
    public static final int VRATI_DRZAVE_ZA_AZURIRAJ_DOGADJAJ = 22;
    public static final int PROMENA_LOZINKE = 23;
    public static final int DODAJ_KORISNIKA = 24;
    public static final int DODAJ_DRZAVU = 25;
    public static final int VRATI_DRZAVE_ZA_UNOS = 26;
    public static final int SACUVAJ_SVE = 27;
    public static final int NADJI_DOGADJAJ= 28;
    public static final int NADJI_CLANA = 29;
    public static final int VRATI_KORISNIKE = 30;
    public static final int VRATI_PRIJAVE_ZA_BRISANJE_CLANOVA = 31;
    public static final int VRATI_PRIJAVE_ZA_BRISANJE_DOGADJAJA = 32;
}
