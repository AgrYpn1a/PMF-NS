package hashtables.other;

import org.svetovid.io.SvetovidReader;

import java.util.Objects;

/**
 * Gadjanje mete
 * <p>
 * Prosiruje InfoTip samo zbog jednostavnosti u TestHash, nema razloga inace.
 */
public class Gadjanje extends InfoTip {
    private int[] rezultati;
    private static int MAX_DUZ = 20;

    public Gadjanje() {
        // prazan konstruktor potreban za test program
    }

    public boolean equals(Object o) {
        // self check
        if(this == o)
            return true;

        // null check
        if(o == null)
            return false;

        if(this.getClass() != o.getClass())
            return false;

        Gadjanje g = (Gadjanje) o;

        if(this.rezultati != null && g.rezultati != null) {

            if(this.rezultati.length == g.rezultati.length) {
                for(int i=0; i<this.rezultati.length; i++)
                    if(this.rezultati[i] != g.rezultati[i])
                        return false;

                return true;
            } else {
                return false;
            }

        } else {
            return this.rezultati == null && g.rezultati == null;
        }
    }

    @Override
    public int hashCode() {
            int rez = 0;
            if (rezultati != null) {
                for (int i = 0; i < rezultati.length; i++) {
                    rez = (rez + rezultati[i] * (MAX_DUZ + 1 - i)) * 3;
                }
            }
            return rez;
        /*
        int rez = 1;
        if(rezultati != null) {
            for(int i=0; i<rezultati.length; i++)
                rez = (rez + rezultati[i]) * (MAX_DUZ + 1 - i);
        }

        return rez;
        */
    }

    @Override
    public InfoTip ucitaj(SvetovidReader r) {
        Gadjanje rez = new Gadjanje();
        int br = r.readInt();
        rez.rezultati = new int[br];
        for (int i = 0; i < br; i++) {
            rez.rezultati[i] = r.readInt();
        }
        return rez;
    }

    public String toString() {
        String str = "Gadjanje (" + rezultati.length + "):";
        for (int i : rezultati) {
            str += " " + i;
        }
        return str;
    }

    // pomocni metod za lakse testiranje
    public static void main(String[] args) {
        new TestHash(new Gadjanje(), "mete").run();
    }

}
