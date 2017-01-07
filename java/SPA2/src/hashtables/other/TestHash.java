package hashtables.other;

import org.svetovid.*;
/**
 * Test program za hash funkcije i equals funkciju
 * <p>
 * Napravljen je da prikazuje rezultate ubacivanja istog fajla u tabele
 * razlicitih velicina.
 * <p>
 * Takodje se lako moze promeniti tip podataka koji se ubacuje prosledjivanjem
 * odgovarajuceg tipa i imena foldera u konstruktoru, ili promenama dve
 * promenljive na pocetku klase.
 * <p>
 * Medjutim da bi to radilo tipovi treba da prosiruju klasu InfoTip i da imaju
 * ili prazan konstruktor ili da se nekako drugacije inicijalizuje objekat
 * `element` u ovoj klasi.
 * <p>
 * Takodje se ocekuje da postoje fajlovi tipa "t0" i "t2" za testiranje. Osnova
 * imena fajla se moze proslediti u konstruktoru, ali ce program svakako traziti
 * fajlove koji se zavrsavaju sa 0 i 2. To se moze promeniti u kodu ovog
 * programa.
 */
public class TestHash {

    // treba promeniti tip ovog objekta i folder u kome su adekvatni
    // podaci da bi se radilo sa drugim podacima
    // ovo se moze uraditi u konstruktoru
    private InfoTip element = new Kancelarija();
    private String folder = "kancelarije";
    private String osnova = "/t";

    public TestHash() {

    }

    public TestHash(InfoTip element, String folder, String osnova) {
        this.element = element;
        this.folder = folder;
        this.osnova = osnova;
    }

    public TestHash(InfoTip element, String folder) {
        this(element, folder, "/t");
    }

    /*
     * Pravi praznu mapu i ispisuje je
     */
    public void emptyTest() {
        StatSet<Object> hash = new StatSet<>();
        hash.printStats();
    }

    /*
     * ucitava podatke iz datog fajla u tabelu date velicine, pri cemu su podaci
     * datog tipa, te ispisuje na kraju statistike o tabeli.
     */
    public void infoTest(String fajl, int size, InfoTip i) {
        StatSet<InfoTip> hash = new StatSet<>();
        System.out.println("poceto ucitavanje");
        if (Svetovid.testIn(fajl)) {
            while (Svetovid.in(fajl).hasMore()) {
                InfoTip sledeci = i.ucitaj(Svetovid.in(fajl));
                hash.add(sledeci);
            }
            Svetovid.closeIn(fajl);

            hash.printStats();
        } else {
            System.err.println("ne moze se otvoriti fajl:" + fajl);
        }
    }

    /*
     * Testira ubacivanje i izbacivanje elemenata iz tabele, cime se dodatno
     * proverava da li hash/equals rade kako treba
     */
    public void addRemoveTest(String fajl, int size, InfoTip i) {
        StatSet<InfoTip> hash = new StatSet<>();
        if (Svetovid.testIn(fajl)) {
            while (Svetovid.in(fajl).hasMore()) {
                hash.add(i.ucitaj(Svetovid.in(fajl)));
            }
            Svetovid.closeIn(fajl);

            System.out
                    .println("-- dodatni testovi ubacivanja i izbacivanja --");
            // hash.printStats();
            InfoTip it = hash.someElement();
            if (!hash.add(it)) {
                System.out.println("uspeh: nije ponovo dodat");
            } else {
                System.out.println("neuspeh: ponovo dodat!");
            }
            if (hash.remove(it)) {
                System.out.println("uspeh: uklonjen");
                if (hash.add(it)) {
                    System.out.println("uspeh: vracen");
                } else {
                    System.out.println("neuspeh: nije vracen");
                }
            } else {
                System.out.println("neuspeh: nije uklonjen!");
            }
        } else {
            System.err.println("ne moze se otvoriti fajl!");
        }
    }

    public void run() {
        // emptyTest();

        String fajl = osnova + "2.txt";

        infoTest(folder + fajl, 997, element);
        Svetovid.out.println();

        // add remove radimo na manjem fajlu
        addRemoveTest(folder + osnova + "0.txt", 101, element);

    }

    public static void main(String[] args) {
        new TestHash().run();
    }
}
