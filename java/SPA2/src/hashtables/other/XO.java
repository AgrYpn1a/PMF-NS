package hashtables.other;

import org.svetovid.io.SvetovidReader;

/**
 * Igra XO
 * <p>
 * Prosiruje InfoTip samo zbog jednostavnosti u TestHash, nema razloga inace.
 */
public class XO extends InfoTip {
    public static final int DIM = 3;
    private final int[][] tabla = new int[DIM][DIM];

    public XO() {
    }

    @Override
    public InfoTip ucitaj(SvetovidReader r) {
        XO rez = new XO();
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                rez.tabla[i][j] = r.readInt();
            }
        }
        return rez;
    }

    public boolean equals(Object o) {
        // Objekat je identican
        if (this == o) {
            return true;
        }
        // Null je uvek razlicit
        if (o == null) {
            return false;
        }
        // Ako su klase razlicite, objekti ne mogu bili jednaki
        if (getClass() != o.getClass()) {
            return false;
        }

        // menjamo tip da mozemo da poredimo
        XO o2 = (XO) o;
        // posto je u ovoj klasi uvek inicijalizovano polje table
        // i uvek je DIM x DIM ne moramo proveravati null
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (o2.tabla[i][j] != tabla[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int rez = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                rez += tabla[i][j];
            }
        }
        return rez;
    }

    // pomocni metod za lakse testiranje
    public static void main(String[] args) {
        new TestHash(new XO(), "xo").run();
    }
}
