package stabla;

import org.svetovid.Svetovid;

// Konkretno stablo koje sadrzi Osobe
class StabloO {
    
    // jedan cvor u stablu sa jednom osobom i pokazivacima
    // na "decu"
    private static class Cvor {
        Osoba osoba;
        Cvor levo;
        Cvor desno;
    }
    
    // koren celog stabla
    private Cvor koren;
    
    // Vraca ukupan broj osoba u stablu
    public int brojOsoba() {
        return brojOsoba(koren);
    }

    protected static int brojOsoba(Cvor cvor) {
        if (cvor == null) {
            return 0;
        }
        int broj = 1;
        broj = broj + brojOsoba(cvor.levo);
        broj = broj + brojOsoba(cvor.desno);
        return broj;
    }
    
    public int brojNivoa() {
        // Spremimo argumente i pozovemo rekurzivni metod
        return brojNivoa(koren);
    }

    // Metod koji zapravo resava dati problem
    protected static int brojNivoa(Cvor cvor) {
        if (cvor == null) {
            return 0;
        }
        int brojNivoaLevog = brojNivoa(cvor.levo);
        int brojNivoaDesnog = brojNivoa(cvor.desno);
        return Math.max(brojNivoaLevog, brojNivoaDesnog) + 1;
    }

}

// Glavna klasa
public class BinarnoStablo {

    // Glavni program
    public static void main(String[] args) {

        // Napravimo pomocni objekat za ucitavanje i ispisivanje
        TreeIO<StabloO> io = new TreeIO<>(StabloO.class);

        // Procitamo stablo iz fajla
        StabloO stablo = io.read(Svetovid.in("Osobe.txt"));

        // Ispisemo ucitano stablo
        io.print(Svetovid.out, stablo);

        // ilustracije poziva metoda
        
        int brojElemenata = stablo.brojOsoba();
        Svetovid.out.println("Broj elemenata:", brojElemenata);
        
        int brojNivoa = stablo.brojNivoa();
        Svetovid.out.println("Broj nivoa:", brojNivoa);

        // dodati ovde pozive implementiranih metoda
    }
}
