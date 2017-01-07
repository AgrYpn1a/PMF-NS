package knjige;

import java.util.Comparator;

/**
 * Created by Rastko on 29-Oct-16.
 */

public interface KnjigaComparator extends Comparator<Knjiga> {}

class PoredakPoId implements KnjigaComparator {

    public int compare(Knjiga x, Knjiga y) {
        return x.compareTo(y);
    }

}

class PoredakPoNaslovu implements KnjigaComparator {

    public int compare(Knjiga x, Knjiga y) {
        return x.getNaslov().compareTo(y.getNaslov());
    }

}

class PoredakPoAutoru implements KnjigaComparator {

    public int compare(Knjiga x, Knjiga y) {
        int rez = x.getPisac().compareTo(y.getPisac());
        if(rez == 0)
            return x.getNaslov().compareTo(y.getNaslov());
        else
            return rez;
    }

}
