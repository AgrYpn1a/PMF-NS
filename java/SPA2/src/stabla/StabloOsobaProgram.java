package stabla;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.svetovid.Svetovid;

// Konkretno stablo koje sadrzi ocene
class StabloOsoba {

	// Tip koji opisuje jedan cvor u stablu
	protected static class Cvor {

		// Sadrzaj cvora
		public final Osoba osoba;

		// Levo i desno podstablo
		public final Cvor levo;
		public final Cvor desno;

		// Jedini konstruktor
		public Cvor(Osoba osoba, Cvor levo, Cvor desno) {
			this.osoba = osoba;
			this.levo = levo;
			this.desno = desno;
		}
	}

	// Stablo ima referencu na korenski cvor
	protected final Cvor koren;

	// Kreiramo prazno stablo
	public StabloOsoba() {
		koren = null;
	}

	// Kreiramo stablo sa jednom osobom u korenu
	// i praznim evim i desnim podstablom
	public StabloOsoba(Osoba osoba) {
		koren = new Cvor(osoba, null, null);
	}

	// Specijalan konstruktor koji koriste neki metodi ove klase
	protected StabloOsoba(Cvor koren) {
		this.koren = koren;
	}

	// Vraca osobu koja je direktor cele firme
	public Osoba getDirektor() {
		if (koren == null) { // Stablo je prazno
			throw new NoSuchElementException();
		}
		return koren.osoba;
	}

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

    // Stampa sve osobe
    public void stampajSveOsobe() {
    	stampajSveOsobe(koren);
    }

    protected static void stampajSveOsobe(Cvor cvor) {
    	if (cvor == null) {
    		return;
    	}
    	stampajSveOsobe(cvor.levo);
    	Svetovid.out.println(cvor.osoba);
    	stampajSveOsobe(cvor.desno);
    }

    // Vraca listu svih osoba
    public List<Osoba> sveOsobe() {
    	List<Osoba> osobe = new ArrayList<>();
    	sveOsobe(koren, osobe);
    	return osobe;
    }

    protected static void sveOsobe(Cvor cvor, List<Osoba> lista) {
    	if (cvor == null) {
    		return;
    	}
    	sveOsobe(cvor.levo, lista);
    	lista.add(cvor.osoba);
    	sveOsobe(cvor.desno, lista);
    }

    // Pronalazi datu osobu i vraca stablo sa korenom u njoj
    public StabloOsoba pronadji(Osoba osoba) {
    	Cvor cvor = pronadji(koren, osoba);
    	if (cvor == null) {
    		return null;
    	}
    	return new StabloOsoba(cvor);
    }

    protected static Cvor pronadji(Cvor cvor, Osoba osoba) {
    	if (cvor == null) {
    		return null;
    	}
    	if (Objects.equals(cvor.osoba, osoba)) {
    		return cvor;
    	}
    	Cvor nadjenLevo = pronadji(cvor.levo, osoba);
    	if (nadjenLevo != null) {
    		return nadjenLevo;
    	}
    	Cvor nadjenDesno = pronadji(cvor.desno, osoba);
    	if (nadjenDesno != null) {
    		return nadjenDesno;
    	}
    	return null;
    }

    // Pronalazi sefa date osobe
    public Osoba sefOd(Osoba podredjeni) {
    	Cvor cvor = sefOd(koren, null, podredjeni);
    	if (cvor == null) {
    		return null;
    	}
    	return cvor.osoba;
    }
    
    protected static Cvor sefOd(Cvor tekuci, Cvor roditelj, Osoba podredjeni) {
    	if (tekuci == null) {
    		return null;
    	}
    	if (Objects.equals(tekuci.osoba, podredjeni)) {
    		return roditelj;
    	}
    	Cvor roditeljLevo = sefOd(tekuci.levo, tekuci, podredjeni);
    	if (roditeljLevo != null) {
    		return roditeljLevo;
    	}
    	Cvor roditeljDesno = sefOd(tekuci.desno, tekuci, podredjeni);
    	if (roditeljDesno != null) {
    		return roditeljDesno;
    	}
    	return null;
    }

    // Vraca listu svih osoba sa platom manjom od granice
    public List<Osoba> sviSaPlatomIspod(int granica) {
    	List<Osoba> osobe = new ArrayList<>();
    	sviSaPlatomIspod(koren, osobe, granica);
    	return osobe;
    }

    protected static void sviSaPlatomIspod(Cvor cvor, List<Osoba> lista, int granica) {
    	if (cvor == null) {
    		return;
    	}
    	if (cvor.osoba.getPlata() < granica) {
    		lista.add(cvor.osoba);
    	}
    	sviSaPlatomIspod(cvor.levo, lista, granica);
    	sviSaPlatomIspod(cvor.desno, lista, granica);
    }

    // Vraca listu svih osoba podredjenih datoj
    public List<Osoba> sviPodredjeni(Osoba sef) {
    	List<Osoba> osobe = new ArrayList<>();
    	Cvor cvor = pronadji(koren, sef);
    	if (cvor != null) {
    		sveOsobe(cvor, osobe);
    	}
    	return osobe;
    }

    // Ispisuje sve puteve u stablu od korena do svih listova
    public void odDirektoraDoSpremacice() {
    	List<Osoba> put = new ArrayList<>();
    	odDirektoraDoSpremacice(koren, put);
    }

    protected static void odDirektoraDoSpremacice(Cvor cvor, List<Osoba> put) {
    	if (cvor == null) {
    		return;
    	}
    	put.add(cvor.osoba);
    	if ((cvor.levo == null) && (cvor.desno == null)) {
        	Svetovid.out.println(put);
    	}
    	odDirektoraDoSpremacice(cvor.levo, put);
    	odDirektoraDoSpremacice(cvor.desno, put);
    	put.remove(put.size() - 1);
    }
}

// Glavna klasa
public class StabloOsobaProgram {

	// Glavni program
	public static void main(String[] args) {

		// Napravimo pomocni objekat za ucitavanje i ispisivanje
		TreeIO<StabloOsoba> io = new TreeIO<>(StabloOsoba.class);

		// Procitamo stablo iz fajla
		StabloOsoba stablo = io.read(Svetovid.in("Osobe.txt"));

		// Ispisemo ucitano stablo
		io.print(Svetovid.out, stablo);

		// Osoba koju cemo traziti u stablu 
		Osoba osobaX = new Osoba("Nikola", "Nikolic-Nikolic", 0);

		// Broj osoba
		int br = stablo.brojOsoba();
		Svetovid.out.println();
		Svetovid.out.println("Broj osoba u firmi: " + br);

		// Stampanje svih osoba
		Svetovid.out.println();
		Svetovid.out.println("Te osobe su: ");
		stablo.stampajSveOsobe();

		// Preuzimanje osoba u listu
	    List<Osoba> sveOsobe = stablo.sveOsobe();
		Svetovid.out.println();
		Svetovid.out.println("Ili kako lista: " + sveOsobe);

	    // Podstablo sa Nikolom kao korenom
	    StabloOsoba podstablo = stablo.pronadji(osobaX);
		Svetovid.out.println();
		Svetovid.out.println(osobaX + " i podredjeni:");
		io.print(Svetovid.out, podstablo);

	    // Ko je Nikolin sef
    	Svetovid.out.println();
	    Osoba sef = stablo.sefOd(osobaX);
	    if (sef != null) {
	    	Svetovid.out.println("Sef od " + osobaX + " je " + sef);
	    } else {
	    	Svetovid.out.println(osobaX + " je direktor");
	    }

	    // Plate
	    int plata = podstablo.getDirektor().getPlata();
		Svetovid.out.println();
    	Svetovid.out.println("Plata od " + podstablo.getDirektor() + " je " + plata + "din");
	    List<Osoba> sviSaPlatomIspod = stablo.sviSaPlatomIspod(plata);
		Svetovid.out.println();
    	Svetovid.out.println("Svi koji imaju platu manju od " + podstablo.getDirektor() + " su: " + sviSaPlatomIspod);

    	// Podredjeni
	    List<Osoba> sviPodredjeni = stablo.sviPodredjeni(osobaX);
		Svetovid.out.println();
    	Svetovid.out.println("Svi koji podredjeni od " + podstablo.getDirektor() + " su: " + sviPodredjeni);

	    // Struktura firme od diroktora do svakog zaposlenog koji nema podredjene
		Svetovid.out.println();
		Svetovid.out.println("Hijerarhija sefova za svakog zaposlenog koji nema svoje podredjene:");
	    stablo.odDirektoraDoSpremacice();

	}
}
