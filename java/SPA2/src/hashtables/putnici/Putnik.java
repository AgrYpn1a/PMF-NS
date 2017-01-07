package hashtables.putnici;

/**
 * Created by Rastko on 15-Nov-16.
 */
public class Putnik {

    private final String ime;
    private final String prezime;
    private final Date datum;

    public Putnik(final String ime, final String prezime, final Date datum) {
        this.ime = ime;
        this.prezime = prezime;
        this.datum = datum;
    }


    @Override
    public boolean equals(Object o) {
        return false;
    }
}
