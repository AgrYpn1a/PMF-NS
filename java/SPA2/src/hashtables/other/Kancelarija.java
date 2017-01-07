package hashtables.other;

import java.util.Objects;

import org.svetovid.io.SvetovidReader;

/**
 * Koriscenje kancelarija
 * <p>
 * Prosiruje InfoTip samo zbog jednostavnosti u TestHash, nema razloga inace.
 */
public class Kancelarija extends InfoTip {

    private final int broj;
    private final String prezime;


    public Kancelarija() {
        this.broj = -1;
        this.prezime = null;
    }

    public Kancelarija(String prezime, int broj) {
        this.broj = broj;
        this.prezime = prezime;
    }

    public boolean equals(Object o) {
        // identity check
        if(this == o)
            return true;

        // null check
        if(o == null)
            return false;

        // class check & casting
        if(this.getClass() != o.getClass()) {
            return false;
        }

        Kancelarija k = (Kancelarija) o;

        return Objects.equals(this.prezime, k.prezime) &&
                this.broj == k.broj;
    }

    public int hashCode() {
        return this.prezime.hashCode() + this.broj;
    }

    @Override
    public InfoTip ucitaj(SvetovidReader r) {
        return new Kancelarija(r.readToken(), r.readInt());
    }

    // pomocni metod za lakse testiranje
    public static void main(String[] args) {
        new TestHash(new Kancelarija(), "kancelarije").run();
    }

}
