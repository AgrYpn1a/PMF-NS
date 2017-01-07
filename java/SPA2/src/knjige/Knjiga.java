package knjige;

/**
 * Created by Rastko on 29-Oct-16.
 */
public class Knjiga implements Comparable<Knjiga> {
    private int id;
    private String pisac;
    private String naslov;

    public Knjiga(int id, String naslov, String pisac) {
        this.id = id;
        this.naslov = naslov;
        this.pisac = pisac;
    }

    public int getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getPisac() {
        return pisac;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int compareTo(Knjiga that) {
        return this.id - that.getId();
    }
}
