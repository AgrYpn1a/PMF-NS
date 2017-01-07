package stabla;

import org.svetovid.Svetovid;

// Konkretno stablo koje sadrzi Osobe
class Stablo {
    private static class Cvor {
    	Osoba osoba;
    	Cvor levo;
    	Cvor desno;
    }
    
    private Cvor koren;
}

// Glavna klasa
public class MinimalnoStablo {

	// Glavni program
	public static void main(String[] args) {

		// Napravimo pomocni objekat za ucitavanje i ispisivanje
		TreeIO<Stablo> io = new TreeIO<>(Stablo.class);

		// Procitamo stablo iz fajla
		Stablo stablo = io.read(Svetovid.in("Osobe.txt"));

		// Ispisemo ucitano stablo
		io.print(Svetovid.out, stablo);
	}
}
