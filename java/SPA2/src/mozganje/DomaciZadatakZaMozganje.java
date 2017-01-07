package mozganje;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.svetovid.Svetovid;

/*
 * <a class="autolink" title="Sortiranje" href="https://moodle.pmf.uns.ac.rs/mod/folder/view.php?id=18929">Sortiranje</a>
 * <a class="autolink" title="Domaci zadatak za mozganje" href="https://moodle.pmf.uns.ac.rs/mod/resource/view.php?id=19145">Domaci zadatak za mozganje</a>
 *
 * a) Zasto ovaj program ne sortira niz brojeva kako se ocekuje?
 * b) Kako popraviti program?
 */
public class DomaciZadatakZaMozganje {

    public static void main(String[] args) {

        System.out.println("MAX VALUE: " + Integer.MAX_VALUE);
        // Kreiramo niz brojeva
        Random random = new Random(0);
        Integer[] brojevi = new Integer[12];
        for (int i = 0; i < brojevi.length; i++) {
            brojevi[i] = (int)(random.nextInt());
        }

        // Odstampamo niz
        Svetovid.out.println("Originalni niz:");
        for (Integer broj : brojevi) {
            Svetovid.out.printf("%12d%n", broj);
        }

        System.out.println("Rezultati poredjenja: ");

        // Sortiramo niz
        Arrays.sort(brojevi, new KomparatorBrojeva());

        // Ponovo odstampamo niz
        Svetovid.out.println();
        Svetovid.out.println("Sortirani niz:");
        for (Integer broj : brojevi) {
            Svetovid.out.printf("%12d%n", broj);
        }

    }
}

class KomparatorBrojeva implements Comparator<Integer> {

    @Override
    public int compare(Integer broj1, Integer broj2) {
        float a = broj1;
        float b = broj2;

        int c = (int)10e6;
        //return broj1.compareTo(broj2);
        System.out.println("\t\tZa brojeve: " + broj1 + " i " + broj2 + " rez operacije - je: "+ (broj1 - broj2));
        return (int)(a/c - b/c);
    }
}
