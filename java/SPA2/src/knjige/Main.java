package knjige;

import org.svetovid.Svetovid;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static final ArrayList<KnjigaComparator> komparatori = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        initComparators();

        System.out.println("Unesi putanju do fajla: ");
        Knjiga[] knjige = (new Knjige(Svetovid.in.readLine())).getCollection();
        System.out.println();
        print(knjige);
        System.out.println();

        System.out.println("Izaberi metodu sortiranja: ");
        System.out.println("\t 0) Po id: ");
        System.out.println("\t 1) Po naslovu: ");
        System.out.println("\t 2) Po autoru: ");

        sort(knjige, komparatori.get(Svetovid.in.readInt()));

        System.out.println();
        System.out.println("######################");
        System.out.println();
        System.out.println("Sortirane knjige: ");
        System.out.println();

        print(knjige);
    }

    private static void print(Knjiga[] knjige) {
        for(Knjiga k : knjige)
            System.out.println(k.getId() + " " + k.getNaslov() + " - " + k.getPisac());
    }

    private static void initComparators() {
        /**
         * 0 - Po id
         * 1 - Po naslovu
         * 2 - Po autoru
         */
        komparatori.add(new PoredakPoId());
        komparatori.add(new PoredakPoNaslovu());
        komparatori.add(new PoredakPoAutoru());
    }

    private static void sort(Knjiga[] knjige) {
        for (int i = 0; i < knjige.length; i++)
            for (int j = 0; j < knjige.length - 1 - i; j++) {
                if (knjige[j].compareTo(knjige[j + 1]) > 0) {
                    Knjiga temp = knjige[j];
                    knjige[j] = knjige[j + 1];
                    knjige[j + 1] = temp;
                }
            }
    }

    private static void sort(Knjiga[] knjige, KnjigaComparator comparator) {
        for (int i = 0; i < knjige.length; i++)
            for (int j = 0; j < knjige.length - 1 - i; j++) {
                if (comparator.compare(knjige[j], knjige[j + 1]) > 0) {
                    Knjiga temp = knjige[j];
                    knjige[j] = knjige[j + 1];
                    knjige[j + 1] = temp;
                }
            }
    }

}
